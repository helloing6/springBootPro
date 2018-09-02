package com.example.gz.controller;

import com.example.gz.property.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @Controller 处理http请求
 * @RestController Spring4 之后新加的注解，原来返回json需要@ResponseBody配合@Controller
 */
@RestController
public class UserController {

    /**
     * @Autowired 将实体对象进行了依赖注入
     */
    @Autowired
    UserProperties userProperties;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 定义了接口的名称
     * @RequestMapping 配置url映射
     * @return
     */
    @GetMapping("/getUser")
    public String getUser() {
        return userProperties.getName();
    }


    @RequestMapping("/getUsers")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }


}
