package cn.njit.myapplication.presenter.presenterImpl;

import cn.njit.myapplication.Bean.MyPageBean;
import cn.njit.myapplication.listener.OnMyPageLoadFinishListener;
import cn.njit.myapplication.model.modelImpl.MyPageModelImpl;
import cn.njit.myapplication.model.modelInterface.MyPageModel;
import cn.njit.myapplication.presenter.presenterInterface.MyPagePresenter;
import cn.njit.myapplication.view.MyPageView;

public class MyPagePresenterImpl implements MyPagePresenter, OnMyPageLoadFinishListener {
    private MyPageView myPageView;
    private MyPageModel myPageModel;

    public MyPagePresenterImpl(MyPageView myPageView) {
        this.myPageView = myPageView;
        this.myPageModel = new MyPageModelImpl();
    }

    @Override
    public void selectPageDetail(String phone) {
        if (myPageView != null) {
            myPageView.showProgress();
        }
        myPageModel.selectPageDetail(phone, this);
    }

    @Override
    public void onLoadMyPageSuccess(MyPageBean myPageBean) {
        myPageView.onLoadMyPageSuccess(myPageBean);
    }
}
