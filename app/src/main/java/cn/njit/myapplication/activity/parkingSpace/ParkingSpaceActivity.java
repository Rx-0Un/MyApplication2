package cn.njit.myapplication.activity.parkingSpace;

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

import cn.njit.myapplication.Bean.ParkingSpaceResult;
import cn.njit.myapplication.R;
import cn.njit.myapplication.activity.parkingSpace.adapter.ParkingSpaceRecyclerViewAdapter;
import cn.njit.myapplication.listener.OnParkingSpaceFinishedListener;
import cn.njit.myapplication.presenter.presenterImpl.ParkingPresenterImpl;
import cn.njit.myapplication.presenter.presenterInterface.ParkingSpacePresenter;
import cn.njit.myapplication.view.ParkingSpaceView;

public class ParkingSpaceActivity extends AppCompatActivity implements OnParkingSpaceFinishedListener, ParkingSpaceView {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private TextView titleStudentName;
    private List<ParkingSpaceResult.ListBean> list;
    private ParkingSpacePresenter parkingSpacePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_space);
        getSupportActionBar().hide();
        initView();
        initPresenter();
    }

    private void initView() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        titleStudentName = findViewById(R.id.title_student_name);
        titleStudentName.setText("闲置车位");
    }

    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ParkingSpaceRecyclerViewAdapter(list, this));
    }

    private void initPresenter() {
        parkingSpacePresenter = new ParkingPresenterImpl(this);
        parkingSpacePresenter.selectNotOccupy();
    }

    @Override
    public void onLoadParkingSpaceSuccess(ParkingSpaceResult parkingSpaceResult) {
        hideProgress();
        list = parkingSpaceResult.getList();
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
    public void loadRecyclerView(ParkingSpaceResult parkingSpaceResult) {
        hideProgress();
        list = parkingSpaceResult.getList();
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                initRecyclerView();
            }
        });
    }
}
