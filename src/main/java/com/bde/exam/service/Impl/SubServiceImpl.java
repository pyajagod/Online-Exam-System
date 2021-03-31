package com.bde.exam.service.Impl;

import com.bde.exam.entity.SubMapperEntity;
import com.bde.exam.mapper.SubMapper;
import com.bde.exam.model.SubModel;
import com.bde.exam.service.SubService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class SubServiceImpl implements SubService {
    private SubMapperEntity subMapperEntity = new SubMapperEntity();
    private Map<String, Object> subjectMap = subMapperEntity.getSubMapper();
    private SubMapper subMapper = (SubMapper) subjectMap.get("subMapper");
    private SqlSession session = (SqlSession) subjectMap.get("session");

    @Override
    public void addSub(SubModel obj) {
        subMapper.addSub(obj);
        session.commit();
    }

    @Override
    public void deleteSub(int id) {
        subMapper.deleteSub(id);
        session.commit();
    }

    @Override
    public void updateSub(SubModel obj) {
        subMapper.updateSub(obj);
        session.commit();
    }

    @Override
    public SubModel querySub(int id) {
        SubModel subItem = subMapper.querySub(id);
        session.commit();
        return subItem;
    }

    @Override
    public int querySubCounts() {
        int count = subMapper.querySubCounts();
        session.commit();
        return count;
    }

    @Override
    public List<SubModel> querySubByPage(Map params) {
        List<SubModel> subItems = subMapper.querySubByPage(params);
        session.commit();
        return subItems;
    }

    @Override
    public Set<SubModel> querySubById(Set<Integer> list) {
        Set<SubModel> subItems = subMapper.querySubById(list);
        session.commit();
        return subItems;
    }
}
