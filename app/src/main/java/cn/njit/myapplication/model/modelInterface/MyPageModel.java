package cn.njit.myapplication.model.modelInterface;

import cn.njit.myapplication.listener.OnMyPageLoadFinishListener;

public interface MyPageModel {

    void selectPageDetail(String phone, OnMyPageLoadFinishListener listener);
}
