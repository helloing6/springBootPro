package com.example.gz.dao;

import com.example.gz.bean.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 组
 * UserGroup 组的实体
 * Integer  组的id类型
 */
public interface IGroupDao extends JpaRepository<UserGroup, Integer> {

    UserGroup findById(int id);
}
