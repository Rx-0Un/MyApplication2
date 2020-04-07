package cn.njit.myapplication.presenter.presenterInterface;

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
