package cn.njit.myapplication.fragment.mypager;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import cn.njit.myapplication.R;
import cn.njit.myapplication.activity.login.LoginActivity;
import cn.njit.myapplication.activity.login.PersonActivity;
import cn.njit.myapplication.application.UserApplication;
import cn.njit.myapplication.fragment.BaseFragment;
import de.hdodenhof.circleimageview.CircleImageView;


public class OtherFragment extends BaseFragment implements View.OnClickListener {


    private static final String TAG = OtherFragment.class.getSimpleName();//"CommonFrameFragment"

    CircleImageView circleImageView;
    private RelativeLayout relativePerson;


    @Override
    protected View initView() {
        Log.e(TAG, "其他Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_other_frame, null);
        circleImageView = view.findViewById(R.id.profile_image);
        relativePerson = view.findViewById(R.id.relative_person);
        relativePerson.setOnClickListener(this);
        circleImageView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_image:
                startActivity(new Intent(mContext, LoginActivity.class));
                break;
            case R.id.relative_person:
                startActivity(new Intent(mContext, PersonActivity.class));
                initUserApplication();
                break;
            default:
                break;
        }
    }

    private void initUserApplication() {
        UserApplication application = (UserApplication) getActivity().getApplication();
        if (!application.getUserPhone().isEmpty()) {

        }
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "其他Fragment数据被初始化了...");

    }
}
