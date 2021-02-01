package com.hbr.util.apiConstant.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * huboren
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiRequest implements Serializable {
    private static final long serialVersionUID = -8343999498164748017L;
    /**
     * 当前用户
     */
    private String user;
}
