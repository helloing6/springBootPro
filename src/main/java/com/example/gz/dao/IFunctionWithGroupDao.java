package com.example.gz.dao;

import com.example.gz.bean.FunctionWithGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface IFunctionWithGroupDao extends JpaRepository<FunctionWithGroup, Long> {

    List<FunctionWithGroup> findByGroupId(int groupId);

}
