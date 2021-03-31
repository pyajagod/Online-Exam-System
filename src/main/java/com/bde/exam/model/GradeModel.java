package com.bde.exam.model;

import java.util.List;

public class GradeModel {
    private int id;
    private String paperName;
    private int paperGrade;
    private int userId;
    private String userName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public int getPaperGrade() {
        return paperGrade;
    }

    public void setPaperGrade(int paperGrade) {
        this.paperGrade = paperGrade;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public GradeModel() {
    }

    public GradeModel(int id, String paperName, int paperGrade, String userName) {
        this.id = id;
        this.paperName = paperName;
        this.paperGrade = paperGrade;
        this.userName = userName;
    }

    public GradeModel(int id, String paperName, int paperGrade, int userId, String userName) {
        this.id = id;
        this.paperName = paperName;
        this.paperGrade = paperGrade;
        this.userId = userId;
        this.userName = userName;
    }
}
