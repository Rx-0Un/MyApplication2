package cn.njit.myapplication.listener;

import cn.njit.myapplication.Bean.LoginBean;
import cn.njit.myapplication.Bean.RegisterResult;

public interface OnLoginFinishedListener {
    void onUsernameError();

    void onPasswordError();

    void onSuccess(LoginBean loginBean);


    void setRegisteredSuccess(RegisterResult registerResult);
}
