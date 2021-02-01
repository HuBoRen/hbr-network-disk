package com.hbr.util.apiConstant.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * 携带sessionId识别
 */
@Data
public class Carrier {

    protected Serializable sessionId;
}
