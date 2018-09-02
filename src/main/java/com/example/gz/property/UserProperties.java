package com.example.gz.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component 的意思就是将该类进行依赖注入的声明 ，之后通过@Autowired就可以直接使用该
 * 类的实体，而无须在new 该对象
 */
@Component
public class UserProperties {

    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private int age;
    @Value("${user.sex}")
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
