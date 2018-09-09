package com.example.gz.controller;

import com.example.gz.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *  @ControllerAdvice : 注解定义全局异常处理类
 *  @RestController : 声明为controller
 *  @Api : swagger标题
 *  @CrossOrigin ： 是用来处理跨域请求的注解
 */
@CrossOrigin
@RestController
@Api(value = "UserController")
@ControllerAdvice
public class UserController extends ReturnType {

    @Autowired
    private IUserService userService;

    /**
     * 登陆接口
     * @param loginId
     * @param password
     * @return
     */
    @ApiOperation(value = "用户登录验证", notes = "根据用户Id验证用户密码是否正确，进行登录验证; 登录成功后，置为上线")
    @ApiImplicitParam(name = "loginId", value = "用户Id", paramType = "Query", required = true, dataType = "String")
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public Map<?, ?> login(String loginId, String password) {

        Map<?, ?> result = userService.userLogin(loginId, password);
        return result;
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/changePsw", method = RequestMethod.POST)
    public Map<?, ?> changePsw(String loginId,String oldPsw,String newPsw){
        System.out.println(loginId + " " + oldPsw + " " + newPsw);
        return userService.changePsw(loginId, oldPsw, newPsw);
    }
}
