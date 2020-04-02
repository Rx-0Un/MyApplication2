package cn.njit.myapplication.fragment.nearfragment;

import android.util.Log;
import android.view.View;


import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

import cn.njit.myapplication.R;
import cn.njit.myapplication.fragment.BaseFragment;


public class CustomFragment extends BaseFragment {
    MapView mapView;
    AMap aMap;
    private static final String TAG = CustomFragment.class.getSimpleName();//"CommonFrameFragment"

    @Override
    protected View initView() {
        Log.e(TAG, "自定义Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_custom_fragment, null);
        mapView = view.findViewById(R.id.mapView);//找到地图控件
        mapView.onCreate(getArguments());
        aMap = mapView.getMap();//初始化地图控制器对象
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "自定义Fragment数据被初始化了...");
    }
}
