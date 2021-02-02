package com.hbr.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱账号
     */
    private String mailbox;

    /**
     * 用户姓名
     */
    private String nickName;

    /**
     * 状态，0 审核中， 1 正常，-1 禁用
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 最近登录时间
     */
    private Date lastLoginTime;

    /**
     * 移动电话
     */
    private Integer mobilePhone;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 0:普通用户,1:管理员
     */
    private Byte role;
}
