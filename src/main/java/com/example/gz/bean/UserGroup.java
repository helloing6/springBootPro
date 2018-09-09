package com.example.gz.bean;

import javax.persistence.*;

/**
 *  用户组表
 */
@Entity(name = "usergroup")
public class UserGroup {

    /**
     * IDENTITY : 主键由数据库自动生成（主要是自动增长型）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String groupName;// 组名

    @Column(length = 50)
    private String description;// 描述

    public UserGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserGroup(int id, String groupName, String description) {
        super();
        this.id = id;
        this.groupName = groupName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserGroup [id=" + id + ", groupName=" + groupName + ", description=" + description + "]";
    }


}
