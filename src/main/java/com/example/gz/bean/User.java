package com.example.gz.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 用户表
 * @Entity	声明类为实体或表。
 * @Table	声明表名。
 */
@Entity
@Table(name = "user")
public class User {

    /**
     * @Id	指定的类的属性，用于识别（一个表中的主键）。
     * @GeneratedValue	指定如何标识属性可以被初始化，
     * 例如自动、手动、或从序列表中获得的值。
     * @SequenceGenerator	指定在@GeneratedValue注解中指定的属性的值。
     * 它创建了一个序列
     * @Column	指定持久属性栏属性
     */
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(strategy = "assigned", name = "id")
    @Column(length = 50)
    private String loginId;// 登录ID 对应数据库的列为 login_id

    @Column(length = 50)
    private String password;

    @Column(columnDefinition = "bit(1) default 0")
    private boolean ifOnline;// 是否在线 对应数据库的列为 if_online

    public User() {
        super();
    }

    public User(String loginId, String password, boolean ifOnline) {
        super();
        this.loginId = loginId;
        this.password = password;
        this.ifOnline = ifOnline;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIfOnline() {
        return ifOnline;
    }

    public void setIfOnline(boolean ifOnline) {
        this.ifOnline = ifOnline;
    }

    @Override
    public String toString() {
        return "User [loginId=" + loginId + ", password=" + password + ", ifOnline=" + ifOnline + "]";
    }
}
