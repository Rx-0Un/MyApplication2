package cn.njit.myapplication.fragment.mypager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.njit.myapplication.Bean.MyPageBean;
import cn.njit.myapplication.R;
import cn.njit.myapplication.activity.login.LoginActivity;
import cn.njit.myapplication.activity.login.PersonActivity;
import cn.njit.myapplication.application.UserApplication;
import cn.njit.myapplication.fragment.BaseFragment;
import cn.njit.myapplication.presenter.presenterImpl.MyPagePresenterImpl;
import cn.njit.myapplication.presenter.presenterInterface.MyPagePresenter;
import cn.njit.myapplication.view.MyPageView;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_FIRST_USER;


public class OtherFragment extends BaseFragment implements View.OnClickListener, MyPageView {


    private static final String TAG = OtherFragment.class.getSimpleName();

    CircleImageView circleImageView;


    private RelativeLayout relativePerson;

    //进度条
    ProgressBar progressBar;


    MyPagePresenter myPagePresenter;
    TextView tvBalance;
    TextView tvCard;
    TextView tvDiscount;
    TextView tvExit;
    TextView tvUserName;

    @Override
    protected View initView() {
        Log.e(TAG, "其他Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_other_frame, null);
        progressBar = view.findViewById(R.id.progressBar);
        tvBalance = view.findViewById(R.id.tv_balance);
        tvCard = view.findViewById(R.id.tv_card);
        tvExit = view.findViewById(R.id.tv_exit);
        tvUserName = view.findViewById(R.id.tv_user_name);
        tvDiscount = view.findViewById(R.id.tv_discount);
        circleImageView = view.findViewById(R.id.profile_image);
        relativePerson = view.findViewById(R.id.relative_person);
        relativePerson.setOnClickListener(this);
        circleImageView.setOnClickListener(this);
        tvExit.setOnClickListener(this);
        myPagePresenter = new MyPagePresenterImpl(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_image:
                if (!VerifyLogin()) {
                    startActivityForResult(new Intent(mContext, LoginActivity.class), 1);
                } else {
                    Toast.makeText(getActivity(), "已登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.relative_person:
                startActivity(new Intent(mContext, PersonActivity.class));
                break;
            case R.id.tv_exit:
                if (VerifyLogin()) {
                    Intent intent = getActivity().getIntent();
                    intent.removeExtra("UserId");
                    Toast.makeText(getActivity(), "退出登录", Toast.LENGTH_SHORT).show();
                    tvBalance.setText("——");
                    tvCard.setText("——");
                    tvDiscount.setText("——");
                    tvExit.setVisibility(View.GONE);
                }
            default:
                break;
        }
    }

    public Boolean VerifyLogin() {
        Intent intent = getActivity().getIntent();
        String UserId = intent.getStringExtra("UserId");
        if (UserId != null) {
            return true;
        }
        return false;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "其他Fragment数据被初始化了...");

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_FIRST_USER) {
            if (data != null) {
                String phone = data.getStringExtra("userPhone");
                myPagePresenter.selectPageDetail(phone);
            }
        }
    }

    @Override
    public void onLoadMyPageSuccess(MyPageBean myPageBean) {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                hideProgress();
                UserApplication app = (UserApplication) getActivity().getApplication();
                tvBalance.setText(String.valueOf(myPageBean.getMyBalance()));
                tvCard.setText(String.valueOf(myPageBean.getMySpace()));
                tvDiscount.setText(String.valueOf(myPageBean.getMyCoupon()));
                tvUserName.setText(String.valueOf(myPageBean.getTbUser().getUserName()));
                tvExit.setVisibility(View.VISIBLE);
                Intent intent = getActivity().getIntent();
                Bundle bundle = new Bundle();
                intent.putExtra("UserId", String.valueOf(myPageBean.getTbUser().getUserId()));
                intent.putExtras(bundle);
            }
        });

    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
