package cn.njit.myapplication.activity.coupon;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.njit.myapplication.Bean.CouponResult;
import cn.njit.myapplication.R;
import cn.njit.myapplication.activity.coupon.adapter.CouponAllRecyclerViewAdapter;
import cn.njit.myapplication.presenter.presenterImpl.CouponPresenterImpl;
import cn.njit.myapplication.presenter.presenterInterface.CouponPresenter;
import cn.njit.myapplication.view.CouponView;

public class CouponActivity extends AppCompatActivity implements CouponView {


    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private List<CouponResult.TbCouponListBean> couponResultList;
    private CouponPresenter couponPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        getSupportActionBar().hide();
        initView();
        initPresenter();
    }

    private void initView() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initPresenter() {
        showProgress();
        couponPresenter = new CouponPresenterImpl(this);
        couponPresenter.selectAllCoupon(20, 0);
    }

    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CouponAllRecyclerViewAdapter(couponResultList, this));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void loadRecyclerView(CouponResult couponResult) {
        hideProgress();
        couponResultList = couponResult.getTbCouponList();
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                initRecyclerView();
            }
        });
    }

    @Override
    public void hideProgress() {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void showProgress() {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void setError() {

    }
}
