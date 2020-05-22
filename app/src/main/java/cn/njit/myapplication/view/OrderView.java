package cn.njit.myapplication.view;

import cn.njit.myapplication.Bean.OrderResult;

public interface OrderView {
    void showProgress();

    void hideProgress();

    void loadRecyclerView(OrderResult orderResult);
}
