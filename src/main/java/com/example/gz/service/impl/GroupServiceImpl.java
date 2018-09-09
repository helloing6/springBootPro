package com.example.gz.service.impl;

import com.example.gz.bean.UserGroup;
import com.example.gz.dao.IGroupDao;
import com.example.gz.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "groupService")
public class GroupServiceImpl implements IGroupService {

    @Autowired
    private IGroupDao groupDao;
    Map<String, Object> result = new HashMap<>();

    @Override
    public Map<?,?> save(UserGroup userGroup) {
        try {
            groupDao.save(userGroup);
            result.put("code",200);
            result.put("result","成功");
        } catch (Exception ex) {
            System.err.println("用户组表插入失败！");
            result.put("code",201);
            result.put("result","失败");
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<?, ?> deleteGroup(int id) {
        try {
            UserGroup res = groupDao.findById(id);
            groupDao.delete(res);
            result.put("code",200);
            result.put("result","成功");
        }catch (Exception ex){
            ex.printStackTrace();
            result.put("code",201);
            result.put("result","失败");
        }
        return result;
    }

    @Override
    public Map<?, ?> selectGroupById(int id) {
        UserGroup group = groupDao.findById(id);
        if(group != null){
            result.put("code",200);
            result.put("result",group);
        }else {
            result.put("code",201);
            result.put("result","失败");
        }
        return result;
    }

    @Override
    public Map<?, ?> update(int id, String description) {
        UserGroup userGroup = groupDao.findById(id);
        if(userGroup == null){
            result.put("code",201);
            result.put("result","失败");
            return result;
        }
        userGroup.setDescription(description);
        UserGroup res = groupDao.save(userGroup);
        result.put("code",200);
        result.put("result",res);
        return result;
    }

    @Override
    public Map<?, ?> findAll() {
        List<UserGroup> res = groupDao.findAll();
        result.put("code",200);
        result.put("result",res);
        return result;
    }
}
