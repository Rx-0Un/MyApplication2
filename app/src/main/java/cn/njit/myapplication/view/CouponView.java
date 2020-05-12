package cn.njit.myapplication.view;

import cn.njit.myapplication.Bean.CouponResult;

public interface CouponView {
    void showProgress();

    void hideProgress();

    void setError();

    void loadRecyclerView(CouponResult couponResult);
}
