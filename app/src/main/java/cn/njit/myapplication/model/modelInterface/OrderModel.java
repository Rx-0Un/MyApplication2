package cn.njit.myapplication.model.modelInterface;


import cn.njit.myapplication.listener.OnOrderFinishedListener;

public interface OrderModel {
    void selectCouponById(String userId, OnOrderFinishedListener listener);
}
