package com.hbr.controller.User;

import com.aliyuncs.exceptions.ClientException;
import com.hbr.util.AliyunUtils;
import com.hbr.util.apiConstant.resp.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @RequestMapping("testSms")
    public ApiResponse test(@RequestParam("phone") String phone) throws ClientException {
        return ApiResponse.buildSuccessRespData(AliyunUtils.sendSms(phone));
    }
}
