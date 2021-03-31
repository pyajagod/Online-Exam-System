package com.bde.exam.model;

public class PaperSubModel {
    private int id;
    private int itemId;
    private String subDesc;
    private String subAns;

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

    public PaperSubModel() {
    }

    public PaperSubModel(int itemId, String subDesc, String subAns) {
        this.itemId = itemId;
        this.subDesc = subDesc;
        this.subAns = subAns;
    }

    public PaperSubModel(int id, int itemId, String subDesc, String subAns) {
        this.id = id;
        this.itemId = itemId;
        this.subDesc = subDesc;
        this.subAns = subAns;
    }
}
