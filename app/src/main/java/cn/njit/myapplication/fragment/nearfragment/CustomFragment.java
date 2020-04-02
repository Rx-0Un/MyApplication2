package cn.njit.myapplication.fragment.nearfragment;

import android.util.Log;
import android.view.View;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;

import cn.njit.myapplication.R;
import cn.njit.myapplication.fragment.BaseFragment;


public class CustomFragment extends BaseFragment {


    private static final String TAG = CustomFragment.class.getSimpleName();//"CommonFrameFragment"

    @Override
    protected View initView() {
        Log.e(TAG, "自定义Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_custom_fragment, null);
        MapView mapView = view.findViewById(R.id.map);//找到地图控件
//在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mapView.onCreate(getArguments());
        AMap aMap = mapView.getMap();//初始化地图控制器对象

        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "自定义Fragment数据被初始化了...");
    }
}
