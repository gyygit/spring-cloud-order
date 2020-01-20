package com.lean.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.SystemUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lean.entity.ResponseModel;
import com.lean.util.ApiUtils;

@RestController
public class HelloWord {

    @Value("${spring.application.name}")
    private String serviceName;
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/order/helloWord")
    public String helloWord() {
        String str = "您访问的是：【" + serviceName + "】服务,【端口号】" + port;
        return str;
    }

    @RequestMapping(value = "/order/getUserOrderInfo")
    public ResponseModel getUserOrderInfo(HttpServletRequest request) {
        ResponseModel responseModel = new ResponseModel(200, "成功", null);
        HashMap<String, Object> par = new HashMap<String, Object>();
        // 把request中的参数放到HashMap中
        ApiUtils.setRequestPar(request, par);
        System.out.println(par.get("id") + request.getParameter("id"));
        // 传怎什么值过来 就返回怎么值 检测服务之间通信是否畅通
        responseModel.setData(par);
        return responseModel;
    }

    @RequestMapping(value = "/testFeignClient")
    public ResponseModel testFeignClient(HttpServletRequest request) {
        ResponseModel responseModel = new ResponseModel(200, "成功", null);
        HashMap<String, Object> par = new HashMap<String, Object>();
        // 把request中的参数放到HashMap中
        ApiUtils.setRequestPar(request, par);
        // 传怎什么值过来 就返回怎么值 检测服务之间通信是否畅通
        responseModel.setData(par);
        return responseModel;
    }
}
