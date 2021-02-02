package com.hbr.dao.user;


import com.hbr.model.User.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User checkForPresence(User user);

    int checkForPhone(@Param("phone") Integer phone);

    int checkForUserName(@Param("userName") String userName);

    int checkForMailbox(@Param("mailbox") String mailbox);

    //int insertLastLoginTime()
}