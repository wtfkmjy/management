package com.example.management.handle;

import com.alibaba.fastjson.JSON;
import com.example.management.utils.CommonResult;
import com.example.management.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FailureHandle implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        CommonResult result = new CommonResult(HttpStatus.FORBIDDEN.value(),"认证失败");
        String json = JSON.toJSONString(result);
        //处理移除
        WebUtils.renderString(response,json);
    }
}
