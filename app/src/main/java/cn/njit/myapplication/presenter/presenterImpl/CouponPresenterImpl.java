package cn.njit.myapplication.presenter.presenterImpl;

import cn.njit.myapplication.Bean.CouponResult;
import cn.njit.myapplication.listener.OnCouponFinishedListener;
import cn.njit.myapplication.model.modelImpl.CouponModelImpl;
import cn.njit.myapplication.model.modelInterface.CouponModel;
import cn.njit.myapplication.presenter.presenterInterface.CouponPresenter;
import cn.njit.myapplication.view.CouponView;

public class CouponPresenterImpl implements CouponPresenter, OnCouponFinishedListener {
    private CouponView couponView;
    private CouponModel couponModel;

    public CouponPresenterImpl(CouponView couponView) {
        this.couponView = couponView;
        this.couponModel = new CouponModelImpl();
    }

    @Override
    public void onSuccess(CouponResult couponResult) {
        if (couponView != null) {
            couponView.hideProgress();
            couponView.loadRecyclerView(couponResult);
        }
    }

    @Override
    public void onDestroy() {
        couponView = null;
    }

    @Override
    public void onError() {
        if (couponView != null) {
            couponView.setError();
            couponView.hideProgress();
        }
    }

    @Override
    public void selectCouponById(int pageNum, int page, String id) {
        couponModel.selectCouponById(pageNum, page, id, this);
    }

    @Override
    public void selectAllCoupon(int pageNum, int page) {
        couponModel.selectAllByPage(pageNum, page, this);
    }
}
