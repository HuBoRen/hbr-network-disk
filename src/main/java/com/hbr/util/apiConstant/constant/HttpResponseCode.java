package com.hbr.util.apiConstant.constant;

/**
 * huboren
 */
public class HttpResponseCode {

    public static final int CODE_CONTINUE = 100;
    public static final String MSG_CONTINUE = "继续";

    public static final int CODE_OK = 200;
    public static final String MSG_OK = "请求成功";

    public static final int CODE_CREATED = 201;
    public static final String MSG_CREATED = "已创建";

    public static final int CODE_ACCEPTED = 202;
    public static final String MSG_ACCEPTED = "已接受";

    public static final int CODE_NON_AUTHORITATIVE_INFORMATION = 203;
    public static final String MSG_NON_AUTHORITATIVE_INFORMATION = "非授权信息";

    public static final int CODE_NO_CONTENT = 204;
    public static final String MSG_NO_CONTENT = "无内容";

    public static final int CODE_RESET_CONTENT = 205;
    public static final String MSG_RESET_CONTENT = "重置内容";

    public static final int CODE_PARTIAL_CONTENT = 206;
    public static final String MSG_PARTIAL_CONTENT = "部分内容";

    public static final int CODE_MULTIPLE_CHOICES = 300;
    public static final String MSG_MULTIPLE_CHOICES = "多种选择";

    public static final int CODE_MOVED_PERMANENTLY = 301;
    public static final String MSG_MOVED_PERMANENTLY = "永久重定向";

    public static final int CODE_MOVED_TEMPORARILY = 302;
    public static final String MSG_MOVED_TEMPORARILY = "临时重定向";

    public static final int CODE_BAD_REQUEST = 400;
    public static final String MSG_BAD_REQUEST = "请求无效";

    public static final int CODE_UNAUTHORIZED = 401;
    public static final String MSG_UNAUTHORIZED = "请求需要用户验证";

    public static final int CODE_FORBIDDEN = 403;
    public static final String MSG_FORBIDDEN = "无访问权限";

    public static final int CODE_NOT_FOUND = 404;
    public static final String MSG_NOT_FOUND = "资源未找到";

    public static final int CODE_METHOD_NOT_ALLOWED = 405;
    public static final String MSG_METHOD_NOT_ALLOWED = "请求中的方法被禁止";

    public static final int CODE_INTERNAL_SERVER_ERROR = 500;
    public static final String MSG_INTERNAL_SERVER_ERROR = "服务器内部错误";

    public static final int CODE_NOT_IMPLEMENTED = 501;
    public static final String MSG_NOT_IMPLEMENTED = "服务器不支持请求的功能";

    public static final int CODE_BAD_GATEWAY = 502;
    public static final String MSG_BAD_GATEWAY = "网关错误";

    public static final int CODE_SERVICE_UNAVAILABLE = 503;
    public static final String MSG_SERVICE_UNAVAILABLE = "服务不可用";

    public static final int CODE_GATEWAY_TIMEOUT = 504;
    public static final String MSG_GATEWAY_TIMEOUT = "网关超时";

    public static final int CODE_HTTP_VERSION_NOT_SUPPORTED = 505;
    public static final String MSG_HTTP_VERSION_NOT_SUPPORTED = "HTTP版本不受支持";

}
