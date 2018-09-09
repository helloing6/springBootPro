package com.example.gz.service.impl;

import com.example.gz.bean.User;
import com.example.gz.dao.IUserDao;
import com.example.gz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional(propagation = Propagation.REQUIRED)
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public Map<?,?> userLogin(String loginId, String password) {
        Map<String, Object> result = new HashMap<>();
        try {
            User user = userDao.findByLoginId(loginId);
            if(user == null){
                result.put("code",201);
                result.put("result","该账号为注册");
                return result;
            }
            if (user.getPassword().equals(password)) {
                result.put("code",200);
                result.put("result",user);
            } else {
                result.put("code",201);
                result.put("result","密码错误");
            }
        }catch (Exception ex){
            System.err.println("用户密码验证失败");
            result.put("code",201);
            result.put("result","内部错误");
        }
        return result;
    }

    @Override
    public Map<?, ?> changePsw(String loginId, String oldPsw, String newPsw) {
        Map<String, Object> result = new HashMap<>();
        User user = userDao.findByLoginId(loginId);
        if(user == null){
            result.put("code",201);
            result.put("result","该账号为注册");
            return result;
        }
        if(oldPsw.equals(user.getPassword())){
            user.setPassword(newPsw);
            userDao.save(user);
            result.put("code",200);
            result.put("result","成功");
        }else {
            result.put("code",201);
            result.put("result","旧密码不正确");
        }
        return result;
    }
}
