package com.example.gz.service;

import java.util.Map;

public interface IUserService {

    //登录
    Map<?, ?> userLogin(String loginId, String password);

    //修改密码
    Map<?,?> changePsw(String loginId, String oldPsw, String newPsw);
}
