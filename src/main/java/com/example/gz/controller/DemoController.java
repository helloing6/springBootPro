package com.example.gz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Api : swagger 标题
 * @ApiOperation : swagger 这个接口的描述
 * @ApiImplicitParam : swagger 方法参数
 */
@RestController
@Api("swaggerController相关的api")
public class DemoController {

    private static final Logger logger= LoggerFactory.getLogger(DemoController.class);

    @ApiOperation(value = "demo测试", notes = "试一试吧")
//    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping("/demo")
    public String demo() {
        return "Hello Spring Boot! The BookName is ";
    }
}
