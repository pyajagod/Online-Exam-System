package com.bde.exam.model;

public class PaperGradeModel {
    private int id;
    private int itemId;
    private int itemGrade;
    private int gradeUploaderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemGrade() {
        return itemGrade;
    }

    public void setItemGrade(int itemGrade) {
        this.itemGrade = itemGrade;
    }

    public int getGradeUploaderId() {
        return gradeUploaderId;
    }

    public void setGradeUploaderId(int gradeUploaderId) {
        this.gradeUploaderId = gradeUploaderId;
    }

    public PaperGradeModel() {
    }

    public PaperGradeModel(int itemId, int itemGrade, int gradeUploaderId) {
        this.itemId = itemId;
        this.itemGrade = itemGrade;
        this.gradeUploaderId = gradeUploaderId;
    }

    public PaperGradeModel(int id, int itemId, int itemGrade, int gradeUploaderId) {
        this.id = id;
        this.itemId = itemId;
        this.itemGrade = itemGrade;
        this.gradeUploaderId = gradeUploaderId;
    }
}
