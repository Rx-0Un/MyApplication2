package cn.njit.myapplication.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cn.njit.myapplication.R;
import cn.njit.myapplication.fragment.mainfragment.CommonFrameFragment;

public class YueActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private ArrayList<Integer> data;
    private static final String TAG = CommonFrameFragment.class.getSimpleName();//"YueActivity"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }
    protected void initView() {
        Log.e(TAG, "余额页面被初始化了...");
        initData();
        setContentView(R.layout.activity_yue);
        mRecyclerView = findViewById(R.id.recycler_view3);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new YueRecylerViewAdapter(data));
    }
    protected void initData() {
        Log.e(TAG, "余额页面数据被初始化了...");
        //准备数据
        data = new ArrayList<>();
        data.add(0);
        data.add(2);
        data.add(2);
    }
}
