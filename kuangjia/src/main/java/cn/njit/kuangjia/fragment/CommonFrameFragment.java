package cn.njit.kuangjia.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import cn.njit.kuangjia.R;
import cn.njit.kuangjia.adapter.CommonFrameFragmentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommonFrameFragment extends BaseFragment {
    private static final String TAG = CommonFrameFragment.class.getSimpleName();

    private ListView mListview;
    private String [] datas;
    private CommonFrameFragmentAdapter adapter;
    @Override
    protected View initView() {
        Log.e(TAG,"常用框架页面初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_common_frame,null);
        mListview = (ListView) view.findViewById(R.id.listview);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = datas[position];
                Toast.makeText(mContext, "data=="+data, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架数据初始化了...");

        //准备数据
        datas = new String[]{ "OKHttp", "xUtils3","Retrofit2","Fresco","Glide","greenDao","RxJava","volley","Gson","FastJson","picasso","evenBus","jcvideoplayer","pulltorefresh","Expandablelistview","UniversalVideoView","....."};

        //设置适配器
        adapter = new CommonFrameFragmentAdapter(mContext,datas);
        mListview.setAdapter(adapter);
    }
}

