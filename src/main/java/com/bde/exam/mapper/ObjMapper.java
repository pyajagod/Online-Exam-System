package com.bde.exam.mapper;

import com.bde.exam.model.ObjModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface ObjMapper {
    void addObj(ObjModel obj);
    void deleteObj(int id);
    void updateObj(ObjModel obj);

    ObjModel queryObj(int id);
    int queryObjCounts();
    List<ObjModel> queryObjByPage(Map<String, Object> params);

    Set<ObjModel> queryObjById(@Param("set") Set<Integer> list);
}
