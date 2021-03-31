package com.bde.exam.model;

public class ObjModel {
    private int id;
    private String objQues;
    private String objDescA;
    private String objDescB;
    private String objDescC;
    private String objDescD;
    private String objAns;
    private int objUploaderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjQues() {
        return objQues;
    }

    public void setObjQues(String objQues) {
        this.objQues = objQues;
    }

    public String getObjDescA() {
        return objDescA;
    }

    public void setObjDescA(String objDescA) {
        this.objDescA = objDescA;
    }

    public String getObjDescB() {
        return objDescB;
    }

    public void setObjDescB(String objDescB) {
        this.objDescB = objDescB;
    }

    public String getObjDescC() {
        return objDescC;
    }

    public void setObjDescC(String objDescC) {
        this.objDescC = objDescC;
    }

    public String getObjDescD() {
        return objDescD;
    }

    public void setObjDescD(String objDescD) {
        this.objDescD = objDescD;
    }

    public String getObjAns() {
        return objAns;
    }

    public void setObjAns(String objAns) {
        this.objAns = objAns;
    }

    public int getObjUploaderId() {
        return objUploaderId;
    }

    public void setObjUploaderId(int objUploaderId) {
        this.objUploaderId = objUploaderId;
    }

    public ObjModel() {
    }

    public ObjModel(String objQues, String objDescA, String objDescB, String objDescC, String objDescD, String objAns) {
        this.objQues = objQues;
        this.objDescA = objDescA;
        this.objDescB = objDescB;
        this.objDescC = objDescC;
        this.objDescD = objDescD;
        this.objAns = objAns;
    }

    public ObjModel(String objQues, String objDescA, String objDescB, String objDescC, String objDescD, String objAns, int objUploaderId) {
        this.objQues = objQues;
        this.objDescA = objDescA;
        this.objDescB = objDescB;
        this.objDescC = objDescC;
        this.objDescD = objDescD;
        this.objAns = objAns;
        this.objUploaderId = objUploaderId;
    }
}
