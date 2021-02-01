package com.hbr.util.apiConstant.resp;

import com.hbr.util.apiConstant.constant.ApiRespConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * huboren
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -8754557150193581761L;

    private String code;
    private String msg;
    private T data;

    public static <T> ApiResponse<T> buildSuccessRespData(T data) {
        return buildRespData(ApiRespConstants.CODE_SUCCESS, ApiRespConstants.MSG_SUCCESS, data);
    }

    public static <T> ApiResponse<T> buildSuccess() {
        return buildRespData(ApiRespConstants.CODE_SUCCESS, ApiRespConstants.MSG_SUCCESS, null);
    }

    public static <T> ApiResponse<T> buildBreakerResp() {
        return buildResp(ApiRespConstants.CODE_ERR_BREAKER, ApiRespConstants.MSG_ERR_BREAKER);
    }

    public static <T> ApiResponse<T> buildErrorParamResp() {
        return buildResp(ApiRespConstants.CODE_ERR_PARAMS, ApiRespConstants.MSG_ERR_PARAMS);
    }

    public static <T> ApiResponse<T> buildErrorParamResp(String msg) {
        return buildResp(ApiRespConstants.CODE_ERR_PARAMS, msg);
    }

    public static <T> ApiResponse<T> buildFailResp() {
        return buildResp(ApiRespConstants.CODE_ERR_UNKNOW, ApiRespConstants.MSG_ERR_UNKNOW);
    }

    public static <T> ApiResponse<T> buildDataNotFoundResp() {
        return buildResp(ApiRespConstants.CODE_DATA_NOT_FOUND, ApiRespConstants.MSG_DATA_NOT_FOUND);
    }

    public static <T> ApiResponse<T> buildFailResp(String msg) {
        return buildResp(ApiRespConstants.CODE_ERR_UNKNOW, msg);
    }

    public static <T> ApiResponse<T> buildTokenSuccessRespData(T data){
        return buildRespTokenData(ApiRespConstants.CODE_SUCCESS, ApiRespConstants.TOKEN_MSG_SUCCESS, data);
    }

    public static <T> ApiResponse<T> buildTokenFailureRespData(String msg){
        return buildRespTokenData(ApiRespConstants.CODE_ERR_PARAMS, msg, null);
    }

    public static <T> ApiResponse<T> buildAuthenticationFailureResp(){
        return buildRespTokenData(ApiRespConstants.auth_COED_FAILED, ApiRespConstants.auth_MSG_FAILED,null);
    }

    public static ApiResponse<String> buildTokenToLoginRespData(){
        return buildRespTokenData(ApiRespConstants.TOKEN_COED_OVERDUE,ApiRespConstants.TOKEN_MSG_OVERDUE,null);
    }

    /**
     * 请求重试
     * @param data 响应失败部分
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> buildRetryData(T data,String msg){
        return buildRespData(ApiRespConstants.CODE_RETEY,msg,data);
    }

    /**
     * 多图上失败，返回失败图片id
     */
    public static <T> ApiResponse<T> buildRetryUploadResp(T data){
        return buildRespData(ApiRespConstants.CODE_RETRY_UPLOAD,ApiRespConstants.MSG_RETRY_UPLOAD,data);
    }

    public static <T> ApiResponse<T> buildRetryUploadResp(String msg, T data){
        return buildRespData(ApiRespConstants.CODE_RETRY_UPLOAD,msg,data);
    }

    /**
     * 前端需要提示用户
     */
    public static <T> ApiResponse<T> buildWarnMsgResp(String msg) {
        return buildResp(ApiRespConstants.CODE_WARN_MSG, msg);
    }

    /**
     * 携带sessionId响应
     * @param codeSuccess
     * @param msgSuccess
     * @param data
     * @param <T>
     * @return
     */
    private static <T> ApiResponse<T> buildRespTokenData(String codeSuccess, String msgSuccess, T data) {
        ApiResponse<T> apiResponse = new ApiResponse<T>();
        apiResponse.setCode(codeSuccess);
        apiResponse.setMsg(msgSuccess);
        apiResponse.setData(data);
        return apiResponse;
    }

    public static <T> ApiResponse<T> buildResp(String code, String msg) {

        ApiResponse<T> apiResponse = new ApiResponse<T>();
        apiResponse.setCode(code);
        apiResponse.setMsg(msg);
        return apiResponse;
    }


    public static <T> ApiResponse<T> buildResp(String code, String msg,boolean success) {

        ApiResponse<T> apiResponse = new ApiResponse<T>();
        apiResponse.setCode(code);
        apiResponse.setMsg(msg);
        return apiResponse;
    }
//
    public static <T> ApiResponse<T> buildRespData(String code, String msg, T data) {
        ApiResponse<T> apiResponse = new ApiResponse<T>();
        apiResponse.setCode(code);
        apiResponse.setMsg(msg);
        if (data != null) {
            apiResponse.setData(data);
        }
        return apiResponse;
    }

    /**
     * 响应结果是否成功
     * @param response 响应信息
     * @return
     */
    public static boolean isSuccess(ApiResponse response) {
        return response != null && ApiRespConstants.CODE_SUCCESS.equals(response.getCode());
    }

    /**
     * 响应结果是否成功
     * @param response 响应信息
     * @param <T> T
     * @return
     */
    public static <T> boolean isSuccessCollection(ApiResponse<List<T>> response) {
        return response != null && ApiRespConstants.CODE_SUCCESS.equals(response.getCode()) && !CollectionUtils.isEmpty(response.getData());
    }

    /**
     * 响应结果是否失败
     * @param response 响应信息
     * @return
     */
    public static boolean isFail(ApiResponse response) {
        return !isSuccess(response);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
