package com.hbr.service;

import com.hbr.model.User.User;

public interface LoginService {
    User checkForPresence(User user);

    int checkForPhone(Integer phone);

    int checkForUserName(String userName);

    int checkForMailbox(String mailbox);

    int registerUser(User user);
}
