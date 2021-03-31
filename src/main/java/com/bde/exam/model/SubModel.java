package com.bde.exam.model;

public class SubModel {
    private int id;
    private String subDesc;
    private String subAns;
    private int subUploaderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubDesc() {
        return subDesc;
    }

    public void setSubDesc(String subDesc) {
        this.subDesc = subDesc;
    }

    public String getSubAns() {
        return subAns;
    }

    public void setSubAns(String subAns) {
        this.subAns = subAns;
    }

    public int getSubUploaderId() {
        return subUploaderId;
    }

    public void setSubUploaderId(int subUploaderId) {
        this.subUploaderId = subUploaderId;
    }

    public SubModel() {
    }

    public SubModel(String subDesc, String subAns) {
        this.subDesc = subDesc;
        this.subAns = subAns;
    }

    public SubModel(String subDesc, String subAns, int subUploaderId) {
        this.subDesc = subDesc;
        this.subAns = subAns;
        this.subUploaderId = subUploaderId;
    }
}
