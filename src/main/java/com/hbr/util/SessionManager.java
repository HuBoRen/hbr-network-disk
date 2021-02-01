package com.hbr.util;


import com.hbr.model.User.User;
import com.hbr.util.apiConstant.constant.CommonConstants;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * huboren
 */
public class SessionManager {

    /**
     * 退出后调用此方法清除session
     */
    public static void userLogout() {
        HttpSession session = getSession();
        if (session != null) {
            session.invalidate();
        }
       // getSession().setAttribute(CommonConstant.LOGIN_USER, null);
    }

    /**
     * 获取当前用户
     *
     * @return
     */
    public static User getCurrentUser() {
        return  (User) getSession().getAttribute(CommonConstants.LOGIN_USER);
    }



    public static HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request.getSession();
    }



}
