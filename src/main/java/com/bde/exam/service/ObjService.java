package com.bde.exam.service;

import com.bde.exam.model.ObjModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ObjService {
    void addObj(ObjModel obj);
    void deleteObj(int id);
    void updateObj(ObjModel obj);

    ObjModel queryObj(int id);
    int queryObjCounts();
    List<ObjModel> queryObjByPage(Map params);
    Set<ObjModel> queryObjById(Set<Integer> list);
}
