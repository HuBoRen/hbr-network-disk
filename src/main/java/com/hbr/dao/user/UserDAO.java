package com.hbr.dao.user;


import com.hbr.model.User.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}