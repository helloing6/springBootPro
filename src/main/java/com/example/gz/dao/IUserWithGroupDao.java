package com.example.gz.dao;

import com.example.gz.bean.FunctionWithGroup;
import com.example.gz.bean.UserWithGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserWithGroupDao extends JpaRepository<UserWithGroup, Long> {

    UserWithGroup findByUserId(String userId);
}
