package cn.njit.myapplication.model.modelInterface;

import cn.njit.myapplication.listener.OnCouponFinishedListener;

public interface CouponModel {
    void selectAllByPage(int pageNum, int page, OnCouponFinishedListener listener);

    void selectCouponById(int pageNum, int page, String userId, OnCouponFinishedListener listener);
}
