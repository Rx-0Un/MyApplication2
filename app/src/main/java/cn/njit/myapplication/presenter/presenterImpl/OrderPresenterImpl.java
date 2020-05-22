package cn.njit.myapplication.presenter.presenterImpl;

import cn.njit.myapplication.Bean.OrderResult;
import cn.njit.myapplication.listener.OnOrderFinishedListener;
import cn.njit.myapplication.model.modelImpl.OrderModelImpl;
import cn.njit.myapplication.model.modelInterface.OrderModel;
import cn.njit.myapplication.presenter.presenterInterface.OrderPresenter;
import cn.njit.myapplication.view.OrderView;

public class OrderPresenterImpl implements OrderPresenter, OnOrderFinishedListener {
    OrderView orderView;
    OrderModel orderModel;

    public OrderPresenterImpl(OrderView orderView) {
        this.orderView = orderView;
        this.orderModel = new OrderModelImpl();
    }

    @Override
    public void selectCouponById(String userId) {
        orderModel.selectCouponById(userId, this);
    }

    @Override
    public void onLoadOrderSuccess(OrderResult orderResult) {
        orderView.loadRecyclerView(orderResult);
    }
}
