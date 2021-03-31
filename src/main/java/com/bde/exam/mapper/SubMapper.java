package com.bde.exam.mapper;

import com.bde.exam.model.SubModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface SubMapper {
    void addSub(SubModel obj);
    void deleteSub(int id);
    void updateSub(SubModel obj);

    SubModel querySub(int id);
    int querySubCounts();
    List<SubModel> querySubByPage(Map params);

    Set<SubModel> querySubById(@Param("set") Set<Integer> list);
}
