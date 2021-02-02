package com.hbr.service.impl;

import com.hbr.dao.user.UserDAO;
import com.hbr.enums.user.SystemUserStatusEnum;
import com.hbr.model.User.User;
import com.hbr.service.LoginService;
import com.hbr.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDAO userDAO;


    /**
     * 检查用户填写信息是否合法
     * @param user
     * @return
     */
    @Override
    public User checkForPresence(User user) {
        user.setPassword(MD5Utils.getMD5String(user.getPassword()));
        return userDAO.checkForPresence(user);
    }

    @Override
    public int checkForPhone(Integer phone) {
        return userDAO.checkForPhone(phone);
    }

    @Override
    public int checkForUserName(String userName) {
        return userDAO.checkForUserName(userName);
    }

    @Override
    public int checkForMailbox(String mailbox) {
        return userDAO.checkForMailbox(mailbox);
    }

    @Override
    public int registerUser(User user) {
        user.setStatus(Byte.valueOf(SystemUserStatusEnum.AUDIT_STATUS.getCode().toString()));
        user.setPassword(MD5Utils.getMD5String(user.getPassword()));
        user.setRole((byte) 0);
        return userDAO.insert(user);
    }
}
