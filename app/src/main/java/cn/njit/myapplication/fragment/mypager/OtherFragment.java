package cn.njit.myapplication.fragment.mypager;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import cn.njit.myapplication.R;
import cn.njit.myapplication.activity.LoginActivity;
import cn.njit.myapplication.fragment.BaseFragment;
import de.hdodenhof.circleimageview.CircleImageView;


public class OtherFragment extends BaseFragment implements View.OnClickListener {


    private static final String TAG = OtherFragment.class.getSimpleName();//"CommonFrameFragment"

    CircleImageView circleImageView;


    @Override
    protected View initView() {
        Log.e(TAG, "其他Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_other_frame, null);
        circleImageView = view.findViewById(R.id.profile_image);
        circleImageView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_image:
                startActivity(new Intent(mContext, LoginActivity.class));
                break;

            default:
                break;
        }
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "其他Fragment数据被初始化了...");

    }
}
