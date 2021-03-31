package com.bde.exam.model;

import java.util.Date;

public class UserModel {
    private int id;
    private int userId;
    private String userName;
    private String userSex;
    private Date userBirthday;
    private String userPwd;
    private String pwdQues;
    private String pwdAns;
    private String userProfession;
    private String userProsition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPwdQues() {
        return pwdQues;
    }

    public void setPwdQues(String pwdQues) {
        this.pwdQues = pwdQues;
    }

    public String getPwdAns() {
        return pwdAns;
    }

    public void setPwdAns(String pwdAns) {
        this.pwdAns = pwdAns;
    }

    public String getUserProfession() {
        return userProfession;
    }

    public void setUserProfession(String userProfession) {
        this.userProfession = userProfession;
    }

    public String getUserProsition() {
        return userProsition;
    }

    public void setUserProsition(String userProsition) {
        this.userProsition = userProsition;
    }

    public UserModel() {
    }

    public UserModel(int userId, String userName, String userSex, Date userBirthday, String userPwd, String pwdQues, String pwdAns, String userProfession, String userProsition) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userPwd = userPwd;
        this.pwdQues = pwdQues;
        this.pwdAns = pwdAns;
        this.userProfession = userProfession;
        this.userProsition = userProsition;
    }

    public UserModel(int id, int userId, String userName, String userSex, Date userBirthday, String userPwd, String pwdQues, String pwdAns, String userProfession, String userProsition) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userPwd = userPwd;
        this.pwdQues = pwdQues;
        this.pwdAns = pwdAns;
        this.userProfession = userProfession;
        this.userProsition = userProsition;
    }
}
