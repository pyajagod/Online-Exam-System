package com.bde.exam.model;

public class ExamModel {
    private int id;
    private String paperName;
    private int paperUploaderId;

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

    public int getPaperUploaderId() {
        return paperUploaderId;
    }

    public void setPaperUploaderId(int paperUploaderId) {
        this.paperUploaderId = paperUploaderId;
    }

    public ExamModel() {
    }

    public ExamModel(String paperName, int paperUploaderId) {
        this.paperName = paperName;
        this.paperUploaderId = paperUploaderId;
    }

    public ExamModel(int id, String paperName, int paperUploaderId) {
        this.id = id;
        this.paperName = paperName;
        this.paperUploaderId = paperUploaderId;
    }
}
