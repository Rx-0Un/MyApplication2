package cn.njit.myapplication.presenter.presenterInterface;

import cn.njit.myapplication.listener.OnCouponFinishedListener;

public interface CouponPresenter {
    void selectAllCoupon(int pageNum, int page);

    void selectCouponById(int pageNum, int page, String id);

    void onDestroy();
}
