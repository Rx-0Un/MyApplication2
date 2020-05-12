package cn.njit.myapplication.listener;

import cn.njit.myapplication.Bean.CouponResult;

public interface OnCouponFinishedListener {
    void onError();


    void onSuccess(CouponResult couponResult);
}
