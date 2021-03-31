package com.bde.exam.entity;

import com.bde.exam.mapper.ObjMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjMapperEntity {

    @Autowired
    public ObjMapper objMapper;
    public Map<String, Object> getObjMapper(){
        Map<String, Object> us = new HashMap<>();
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        objMapper = session.getMapper(ObjMapper.class);
        us.put("objMapper", objMapper);
        us.put("session", session);
        return us;
    }
}
