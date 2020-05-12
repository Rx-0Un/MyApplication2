package cn.njit.myapplication.presenter.presenterImpl;

import cn.njit.myapplication.Bean.LoginBean;
import cn.njit.myapplication.Bean.RegisterResult;
import cn.njit.myapplication.listener.OnLoginFinishedListener;
import cn.njit.myapplication.model.modelImpl.LoginModelImpl;
import cn.njit.myapplication.model.modelInterface.LoginModel;
import cn.njit.myapplication.presenter.presenterInterface.LoginPresenter;
import cn.njit.myapplication.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginModel.login(username, password, this);
    }

    @Override
    public void addNewUser(String username, String password, String password_again) {
        if (loginView != null) {
            loginView.showProgress();
        }
        if (password.equals(password_again)) {
            loginModel.addNewUser(username, password, password_again, this);
        } else {
            loginView.setPasswordNotEqual();
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        if (loginView != null) {
            if (loginBean.getLoginCode() == 1) {
                loginView.navigateToHome();
            } else if ("用户不存在".equals(loginBean.getLoginDetail())) {
                loginView.setUsernameError();
            } else {
                loginView.setPasswordError();
            }
        }
    }

    @Override
    public void setRegisteredSuccess(RegisterResult registerResult) {
        if (loginView != null) {
            if (registerResult.getRegisterCode() == 1) {
                loginView.setUserExist();
            } else {
                loginView.setRegisteredSuccess();
            }
        }
    }
}
