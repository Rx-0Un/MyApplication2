package cn.njit.myapplication.listener;

import cn.njit.myapplication.Bean.OrderResult;

public interface OnOrderFinishedListener {
    void onLoadOrderSuccess(OrderResult orderResult);
}
