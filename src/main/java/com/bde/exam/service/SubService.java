package com.bde.exam.service;

import com.bde.exam.model.SubModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SubService {
    void addSub(SubModel obj);
    void deleteSub(int id);
    void updateSub(SubModel obj);

    SubModel querySub(int id);
    int querySubCounts();
    List<SubModel> querySubByPage(Map params);
    Set<SubModel> querySubById(Set<Integer> list);
}
