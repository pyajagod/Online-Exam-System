package com.bde.exam.entity;

import com.bde.exam.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class UserMapperEntity {

    @Autowired
    private UserMapper userMapper;

    public Map<String, Object> getUserMapper(){
        Map<String, Object> us = new HashMap<>();
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
        us.put("userMapper", userMapper);
        us.put("session", session);
        return us;
    }
}
