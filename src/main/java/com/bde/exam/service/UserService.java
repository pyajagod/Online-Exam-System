package com.bde.exam.service;

import com.bde.exam.model.UserModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface UserService {
    boolean isExit(UserModel user);
    void addUser(UserModel user);
    void deleteUser(int userId);
    void updateUser(UserModel user);
    void updateProsition(UserModel user);
    UserModel queryUser(UserModel user);
    List<UserModel> queryUserByPage(Map<String, Object> params);
    LinkedList<UserModel> queryUserByIds(LinkedList<Integer> ids);
    int queryUserCounts();

}
