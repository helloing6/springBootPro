package com.example.gz.dao;

import com.example.gz.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * user 用户表 查询
 */
public interface IUserDao extends JpaRepository<User, Long> {

    User findByLoginId(String loginId);

}