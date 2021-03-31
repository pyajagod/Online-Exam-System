package com.bde.exam.service.Impl;

import com.bde.exam.entity.ObjMapperEntity;
import com.bde.exam.mapper.ObjMapper;
import com.bde.exam.mapper.SubMapper;
import com.bde.exam.model.ObjModel;
import com.bde.exam.service.ObjService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ObjServiceImpl implements ObjService {

    private ObjMapperEntity objMapperEntity = new ObjMapperEntity();
    private Map<String, Object> objectMap = objMapperEntity.getObjMapper();
    private ObjMapper objMapper = (ObjMapper) objectMap.get("objMapper");
    private SqlSession session = (SqlSession) objectMap.get("session");

    @Override
    public void addObj(ObjModel obj) {
        objMapper.addObj(obj);
        session.commit();
    }

    @Override
    public void deleteObj(int id) {
        objMapper.deleteObj(id);
        session.commit();
    }

    @Override
    public void updateObj(ObjModel obj) {
        objMapper.updateObj(obj);
        session.commit();
    }

    @Override
    public ObjModel queryObj(int id) {
        ObjModel objItem = objMapper.queryObj(id);
        session.commit();
        return objItem;
    }

    @Override
    public int queryObjCounts() {
        int count = objMapper.queryObjCounts();
        session.commit();
        return count;
    }

    @Override
    public List<ObjModel> queryObjByPage(Map params) {
        List<ObjModel> objItems = objMapper.queryObjByPage(params);
        session.commit();
        return objItems;
    }

    @Override
    public Set<ObjModel> queryObjById(Set<Integer> list) {
        Set<ObjModel> objItems = objMapper.queryObjById(list);
        session.commit();
        return objItems;
    }
}
