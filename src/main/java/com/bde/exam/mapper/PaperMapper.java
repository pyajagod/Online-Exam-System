package com.bde.exam.mapper;

import com.bde.exam.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Mapper
public interface PaperMapper {
    void addPaper(ExamModel exam);
    void addPaperObj(PaperObjModel paperObj);
    void addPaperSub(PaperSubModel paperSub);

    void addPaperGrade(PaperGradeModel paperGrade);

    void deletePaper(int itemId);
    void deletePaperObj(int itemId);
    void deletePaperSub(int itemId);
    void deleteOneObj(int id);
    void deleteOneSub(int id);

    void updatePaper(ExamModel exam);
    void updateOneObj(PaperObjModel paperObj);
    void updateOneSub(PaperSubModel paperSub);

    int queryPaperCounts();
    int queryPaperObjCounts(int itemId);
    int queryPaperSubCounts(int itemId);

//    int queryOnePaperAns(int itemId, int userId);
    List<GradeModel> queryPaperGrades(int userId);
    List<GradeModel> queryAllPaperGrades(int itemId);

    ExamModel queryOnePaper(int itemId);
    List<ExamModel> queryPapers(Map<String, Object> params);
    PaperSubModel queryOneSub(int id);
    PaperObjModel queryOneObj(int id);
    List<PaperSubModel> querySubs(int ItemId);
    List<PaperObjModel> queryObjs(int ItemId);


}
