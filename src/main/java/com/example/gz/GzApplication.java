package com.example.gz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动应用类
 * @SpringBootApplication：Spring Boot 应用的标识
 * http://localhost:8080/
 */
@SpringBootApplication
public class GzApplication {

    /**
     * Application很简单，一个main函数作为主入口。SpringApplication引导应用，
     * 并将Application本身作为参数传递给run方法。
     * 具体run方法会启动嵌入式的Tomcat并初始化Spring环境及其各Spring组件。
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(GzApplication.class, args);
    }
}
