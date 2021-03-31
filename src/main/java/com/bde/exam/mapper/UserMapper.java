package com.bde.exam.mapper;

import com.bde.exam.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    void addUser(UserModel user);
    void deleteUser(int userId);
    void updateUser(UserModel user);
    void updateProsition(UserModel user);
    UserModel queryUser(UserModel user);
    List<UserModel> queryUserByPage(Map<String, Object> map);
    LinkedList<UserModel> queryUserByIds(LinkedList<Integer> ids);
    int queryUserCounts();
}
