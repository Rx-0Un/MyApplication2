package cn.njit.myapplication.presenter.presenterInterface;

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void addNewUser(String username, String password,String password_again);


    void onDestroy();
}
