package cn.njit.myapplication.activity.order;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.njit.myapplication.Bean.OrderResult;
import cn.njit.myapplication.R;
import cn.njit.myapplication.activity.order.adapter.OrderRecyclerViewAdapter;
import cn.njit.myapplication.presenter.presenterImpl.OrderPresenterImpl;
import cn.njit.myapplication.presenter.presenterInterface.OrderPresenter;
import cn.njit.myapplication.view.OrderView;

public class OrderActivity extends AppCompatActivity implements OrderView {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private TextView titleStudentName;
    private OrderPresenter orderPresenter;
    private List<OrderResult.ListBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().hide();
        initView();
        initPresenter();
    }

    private void initView() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        titleStudentName = findViewById(R.id.title_student_name);
        titleStudentName.setText("我的订单");
    }

    private void initPresenter() {
        showProgress();
        orderPresenter = new OrderPresenterImpl(this);
        Intent intent =getIntent();
        orderPresenter.selectCouponById(intent.getStringExtra("UserId"));

    }

    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OrderRecyclerViewAdapter(list, this));
    }

    @Override
    public void loadRecyclerView(OrderResult orderResult) {
        hideProgress();
        list = orderResult.getList();
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

}
