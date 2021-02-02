package com.hbr.controller.User;

import com.hbr.model.User.User;
import com.hbr.model.mail.MailUser;
import com.hbr.redis.service.RedisService;
import com.hbr.service.LoginService;
import com.hbr.util.SessionManager;
import com.hbr.util.apiConstant.constant.CommonConstants;
import com.hbr.util.apiConstant.constant.MailConstants;
import com.hbr.util.apiConstant.resp.ApiResponse;
import com.hbr.util.mail.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/Login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailUser mailUser;

    @Autowired
    private RedisService redisService;


    @RequestMapping("registerUser")
    public ApiResponse registerUser(User user) {
        if (loginService.checkForMailbox(user.getMailbox()) > 0) {
            return ApiResponse.buildFailResp("该邮箱已经被注册过了，请您换个再试");
        }
        if (loginService.checkForPhone(user.getMobilePhone()) > 0) {
            return ApiResponse.buildFailResp("该手机号已经被注册过了，请您换个再试");
        }
        if (loginService.checkForUserName(user.getUserName()) > 0) {
            return ApiResponse.buildFailResp("该用户名已经被注册过了，请您换个再试");
        }
        if (loginService.registerUser(user) > 0) {
            mailUser.setToUser(new String[]{user.getMailbox()});
            mailUser.setSubject(MailConstants.AUDIT_SUBJECT);
            mailUser.setPersonal(MailConstants.AUDIT_SUBJECT);
            mailUser.setContent(EmailUtils.getAuditMailContent(user.getUserName()));
            EmailUtils.htmlEmail(mailUser, javaMailSender);
            return ApiResponse.buildSuccessRespData(user.getUserName() + ":" + "等待管理员审核");
        }
        return ApiResponse.buildFailResp("注册失败，请晚点再试");
    }

    @RequestMapping("/toLogin")
    public ApiResponse toLogin(User user) {
        if (Objects.isNull(user.getMailbox()) || Objects.isNull(user.getPassword())) {
            return ApiResponse.buildFailResp("邮箱或者密码不能为空");
        }
        if (loginService.checkForMailbox(user.getMailbox()) == 0) {
            return ApiResponse.buildFailResp("该邮箱没有被注册过，或者还在审核中，请稍后再试");
        }
        User userInfo = loginService.checkForPresence(user);
        if (Objects.isNull(userInfo)) {
            return ApiResponse.buildFailResp("用户名或者密码错误");
        }
        String token = user.getMailbox() + UUID.randomUUID().toString() + System.currentTimeMillis();
        HttpSession session = SessionManager.getSession();
        session.setAttribute(CommonConstants.LOGIN_USER, userInfo);
        session.setMaxInactiveInterval(3600 * 24);
        if (redisService.hasKey(user.getMailbox())) {
            redisService.del(user.getMailbox());
        }
        redisService.set(user.getMailbox(), token);
        return ApiResponse.buildSuccessRespData(token);
    }

    @RequestMapping("/loginOut")
    public ApiResponse loginOut() {
        User currentUser = SessionManager.getCurrentUser();
        SessionManager.userLogout();
        return ApiResponse.buildSuccessRespData(currentUser.getUserName() + ":" + "退出登录成功");
    }

}
