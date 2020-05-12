package cn.njit.myapplication.application;

import android.app.Application;

import java.util.Date;

public class UserApplication extends Application {
    private static UserApplication app;
    private Integer userId;
    private String userName;
    private String userPhone;
    private String userAdress;
    private String userPwd;
    private String userEmail;
    private String userSex;
    private Date userRegtime;
    @Override
    public void onCreate() {
        super.onCreate();
        userId = new Integer(0);
        userName = new String();
        userPhone = new String();
        userAdress = new String();
        userPwd = new String();
        userEmail = new String();
        userSex = new String();
        userRegtime = new Date();
    }

    public static UserApplication getInstance() {
        return app;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserRegtime() {
        return userRegtime;
    }

    public void setUserRegtime(Date userRegtime) {
        this.userRegtime = userRegtime;
    }
}
