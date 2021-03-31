package com.bde.exam.service.Impl;

import com.bde.exam.entity.PaperMapperEntity;
import com.bde.exam.mapper.PaperMapper;
import com.bde.exam.model.*;
import com.bde.exam.service.PaperService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaperServiceImpl implements PaperService {

    private PaperMapperEntity paperMapperEntity = new PaperMapperEntity();
    private Map<String,Object> params = paperMapperEntity.getObjMapper();
    private PaperMapper paperMapper = (PaperMapper) params.get("paperMapper");
    private SqlSession session = (SqlSession) params.get("session");

    @Override
    public void addPaper(ExamModel exam) {
        paperMapper.addPaper(exam);
        session.commit();
    }

    @Override
    public void addPaperObj(PaperObjModel paperObj) {
        paperMapper.addPaperObj(paperObj);
        session.commit();
    }

    @Override
    public void addPaperSub(PaperSubModel paperSub) {
        paperMapper.addPaperSub(paperSub);
        session.commit();
    }

    @Override
    public void addPaperGrade(PaperGradeModel paperGrade) {
        paperMapper.addPaperGrade(paperGrade);
        session.commit();
    }

    @Override
    public void deletePaper(int itemId) {
        paperMapper.deletePaper(itemId);
        session.commit();
    }

    @Override
    public void deletePaperObj(int itemId) {
        paperMapper.deletePaperObj(itemId);
        session.commit();
    }

    @Override
    public void deletePaperSub(int itemId) {
        paperMapper.deletePaperSub(itemId);
        session.commit();
    }

    @Override
    public void deleteOneObj(int id) {
        paperMapper.deleteOneObj(id);
        session.commit();
    }

    @Override
    public void deleteOneSub(int id) {
        paperMapper.deleteOneSub(id);
        session.commit();
    }

    @Override
    public void updatePaper(ExamModel exam) {
        paperMapper.updatePaper(exam);
        session.commit();
    }

    @Override
    public void updateOneObj(PaperObjModel paperObj) {
        paperMapper.updateOneObj(paperObj);
        session.commit();
    }

    @Override
    public void updateOneSub(PaperSubModel paperSub) {
        paperMapper.updateOneSub(paperSub);
        session.commit();
    }

    @Override
    public List<GradeModel> queryPaperGrades(int userId) {
        List<GradeModel> grades = paperMapper.queryPaperGrades(userId);
        session.commit();
        return grades;
    }

    @Override
    public List<GradeModel> queryAllPaperGrades(int itemId) {
        List<GradeModel> allGrades = paperMapper.queryAllPaperGrades(itemId);
        session.commit();
        return allGrades;
    }

    @Override
    public int queryPaperCounts() {
        int count = paperMapper.queryPaperCounts();
        session.commit();
        return count;
    }

    @Override
    public int queryPaperObjCounts(int itemId) {
        int count = paperMapper.queryPaperObjCounts(itemId);
        session.commit();
        return count;
    }

    @Override
    public int queryPaperSubCounts(int itemId) {
        int count = paperMapper.queryPaperSubCounts(itemId);
        session.commit();
        return count;
    }


    @Override
    public ExamModel queryOnePaper(int itemId) {
        ExamModel exam = paperMapper.queryOnePaper(itemId);
        session.commit();
        return exam;
    }

    @Override
    public List<ExamModel> queryPapers(Map<String, Object> params) {
        List<ExamModel> exams = paperMapper.queryPapers(params);
        session.commit();
        return exams;
    }

    @Override
    public List<PaperSubModel> querySubs(int ItemId) {
        List<PaperSubModel> subs = paperMapper.querySubs(ItemId);
        session.commit();
        return subs;
    }

    @Override
    public List<PaperObjModel> queryObjs(int ItemId) {
        List<PaperObjModel> objs = paperMapper.queryObjs(ItemId);
        session.commit();
        return objs;
    }

    @Override
    public PaperSubModel queryOneSub(int id) {
        PaperSubModel sub = paperMapper.queryOneSub(id);
        session.commit();
        return sub;
    }

    @Override
    public PaperObjModel queryOneObj(int id) {
        PaperObjModel obj = paperMapper.queryOneObj(id);
        session.commit();
        return obj;
    }
}
