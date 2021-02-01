package com.hbr.util.apiConstant.constant;

/**
 * huboren
 */
public class ApiRespConstants {

    public static final String CODE_SUCCESS = "000000";
    public static final String MSG_SUCCESS = "操作成功";

    public static final String CODE_ERR_PARAMS = "999998";
    public static final String MSG_ERR_PARAMS = "参数错误";

    public static final String CODE_ERR_BREAKER = "999980";
    public static final String MSG_ERR_BREAKER = "请求熔断";

    public static final String CODE_DATA_NOT_FOUND = "100000";
    public static final String MSG_DATA_NOT_FOUND = "没有查到数据";

    public static final String CODE_ERR_UNKNOW = "999900";
    public static final String MSG_ERR_UNKNOW = "未知异常";

    public static final String CODE_EXISTED = "100000";
    public static final String MSG_EXISTED = "记录已存在";

    public static final String CODE_EMPTY = "100001";
    public static final String MSG_EMPTY = "请求数据为空";

    /**
     * 携带token的响应码
     */
    public static final String TOKEN_COED_SUCCESS = "444001";
    public static final String TOKEN_MSG_SUCCESS = "接口请求成功";

    public static final String TOKEN_COED_FAILURE = "444002";
    public static final String TOKEN_MSG_FAILURE = "接口请求失败";

    public static final String TOKEN_COED_OVERDUE = "444003";
    public static final String TOKEN_MSG_OVERDUE = "Session过期";

    public static final String auth_COED_FAILED = "444004";
    public static final String auth_MSG_FAILED = "鉴权失败";

    /**
     * 需要响应提示信息的响应码，前端需提示用户响应message
     */
    public static final String CODE_WARN_MSG = "555001";

    /**
     * 多文件上传失败，失败文件id返回，重新上传
     */
    public static final String CODE_RETEY = "666000"; //请求重试，传输的数据有部分成功了，失败的部分返回请求者
    public static final String CODE_RETRY_UPLOAD = "666001";
    public static final String MSG_RETRY_UPLOAD = "部分文件上传失败,请重新上传失败图片";

    /**
     * 登录失败
     */
    public static final String CODE_LOGIN_FAIL = "888888";
    public static final String USERNAME_OR_PASSWORD_ERROR = "账号或密码错误";

    /**
     * 权限验证失败
     */
    public static final String CODE_AUTHORIZATION_FAIL = "888889";
    public static final String MSG_AUTHORIZATION_FAIL = "权限验证失败";

}
