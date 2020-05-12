package cn.njit.myapplication.model.modelInterface;

import cn.njit.myapplication.listener.OnLoginFinishedListener;

public interface LoginModel {
    void login(String username, String password, OnLoginFinishedListener listener);

    void addNewUser(String username, String password, String password_again, OnLoginFinishedListener listener);
}
