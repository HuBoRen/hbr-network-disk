package com.hbr.enums.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum SystemUserStatusEnum {
    AUDIT_STATUS("审核中",0),
    DISABLED_STATUS("禁用",-1),
    VALID_STATUS("有效",1);

    private String desc;
    private Integer code;


}
