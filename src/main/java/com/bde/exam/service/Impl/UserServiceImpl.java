package com.bde.exam.service.Impl;

import com.bde.exam.entity.UserMapperEntity;
import com.bde.exam.mapper.UserMapper;
import com.bde.exam.model.UserModel;
import com.bde.exam.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private UserMapperEntity userMapperEntity = new UserMapperEntity();
    private UserModel user;
    private Map<String, Object> userMap = userMapperEntity.getUserMapper();
    private SqlSession session = (SqlSession) userMap.get("session");
    private UserMapper userMapper = (UserMapper) userMap.get("userMapper");

    @Override
    public boolean isExit(UserModel user) {
        if (this.queryUser(user) != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void addUser(UserModel user) {
        userMapper.addUser(user);
        session.commit();

    }

    @Override
    public void deleteUser(int userId) {
//        UserMapper userMapper = userMapperEntity.getUserMapper();
        userMapper.deleteUser(userId);
        session.commit();

    }

    @Override
    public void updateUser(UserModel user) {
        userMapper.updateUser(user);
        session.commit();

    }

    @Override
    public void updateProsition(UserModel user) {
        userMapper.updateProsition(user);
        session.commit();
    }

    @Override
    public UserModel queryUser(UserModel user) {
        UserModel userModel = userMapper.queryUser(user);
//        System.out.println(userModel);
        session.commit();
        return userModel;
    }

    @Override
    public List<UserModel> queryUserByPage(Map<String, Object> params) {
        List<UserModel> users = userMapper.queryUserByPage(params);
        session.commit();
        return users;
    }

    @Override
    public LinkedList<UserModel> queryUserByIds(LinkedList<Integer> ids) {

        LinkedList<UserModel> users = userMapper.queryUserByIds(ids);
        session.commit();
        return users;
    }

    @Override
    public int queryUserCounts() {
        int counts = userMapper.queryUserCounts();
        session.commit();
        return counts;
    }
}
