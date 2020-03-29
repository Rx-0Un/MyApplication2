package cn.njit.myapplication.fragment.mypager;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import cn.njit.myapplication.R;
import cn.njit.myapplication.fragment.BaseFragment;


public class OtherFragment extends BaseFragment {


    private static final String TAG = OtherFragment.class.getSimpleName();//"CommonFrameFragment"

    RecyclerView mRvMine;


    @Override
    protected View initView() {
        Log.e(TAG,"其他Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_other_frame,null);

        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "其他Fragment数据被初始化了...");

    }
}
