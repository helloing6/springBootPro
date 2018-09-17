package com.example.gz.service;

import com.example.gz.bean.UserGroup;

import java.util.Map;

public interface IGroupService {

    Map<?,?> save(UserGroup userGroup);

    Map<?,?> deleteGroup(int id);

    Map<?, ?> selectGroupById(int id);

    Map<?,?> update(int id, String description);

    Map<?,?> findAll();

    Map<?,?> findByLoginId(String loginId);
}
