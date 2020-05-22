package cn.njit.myapplication.view;

import cn.njit.myapplication.Bean.MyPageBean;

public interface MyPageView {
    void showProgress();

    void hideProgress();

    void onLoadMyPageSuccess(MyPageBean myPageBean);
}
