package cn.njit.myapplication.view;

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void setPasswordNotEqual();

    void setUserExist();

    void setRegisteredSuccess();
}
