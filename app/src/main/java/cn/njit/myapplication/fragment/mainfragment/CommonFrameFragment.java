package cn.njit.myapplication.fragment.mainfragment;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

import com.google.gson.Gson;
import com.youth.banner.Banner;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

import cn.njit.myapplication.R;
import cn.njit.myapplication.activity.YueActivity;
import cn.njit.myapplication.activity.charge.ChargeActivity;
import cn.njit.myapplication.activity.coupon.CouponActivity;
import cn.njit.myapplication.activity.order.OrderActivity;
import cn.njit.myapplication.activity.parkingSpace.ParkingSpaceActivity;
import cn.njit.myapplication.fragment.BaseFragment;
import cn.njit.myapplication.tool.ImageAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CommonFrameFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = CommonFrameFragment.class.getSimpleName();//"CommonFrameFragment"


    GridLayout gridLayout2;

    LinearLayout linearLayout;

    LinearLayout linearLayout2;

    RelativeLayout gridLayout;

    SearchView searchView;

    RelativeLayout layoutManage;
    RelativeLayout layoutCouponManage;
    RelativeLayout layoutWatch;
    RelativeLayout layoutCharge;
    RelativeLayout layoutOrder;
    RelativeLayout layoutPrkingSpace;
    private Banner banner;


    @Override
    protected View initView() {
        Log.e(TAG, "常用框架Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        SearchView searchView = view.findViewById(R.id.searchView);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "开始进行网络请求...");
                OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder()
//                        .url("http://www.jianshu.com/u/9df45b87cfdf")
                        .url("http://218.244.153.72:8080/App/login")
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                        Looper.prepare();
//                        Toast.makeText(mContext, "get failed", Toast.LENGTH_SHORT).show();
//                        Looper.loop();
                        Log.v("！！", "失败");
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        Log.e("成功", response.body().string());
                        String responseData = response.body().toString();
                        Gson gson = new Gson();
                        String str = gson.toJson(responseData);
                        Log.e("解析", str);
                    }
                });
            }
        });
        banner = view.findViewById(R.id.banner);
        layoutManage = view.findViewById(R.id.layout_manage);
        layoutManage.setOnClickListener(this);
        layoutCouponManage = view.findViewById(R.id.layout_coupon_manage);
        layoutCouponManage.setOnClickListener(this);
        layoutWatch = view.findViewById(R.id.layout_watch);
        layoutWatch.setOnClickListener(this);
        layoutCharge=view.findViewById(R.id.layout_charge);
        layoutCharge.setOnClickListener(this);
        layoutOrder=view.findViewById(R.id.layout_order);
        layoutOrder.setOnClickListener(this);
        layoutPrkingSpace=view.findViewById(R.id.layout_parking_space);
        layoutPrkingSpace.setOnClickListener(this);
        initBanner();
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架Fragment数据被初始化了...");
    }

    public void initBanner() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.mipmap.parking_box_line);
        list.add(R.mipmap.parking_box_line);
        list.add(R.mipmap.parking_box_line);
        banner.setAdapter(new ImageAdapter(list)).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_manage:
                Uri uri = Uri.parse("http://218.244.153.72:8080/index");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                break;
            case R.id.layout_coupon_manage:
                startActivity(new Intent(mContext, CouponActivity.class));
                break;
            case R.id.layout_watch:
                startActivity(new Intent(mContext, YueActivity.class));
                break;
            case R.id.layout_charge:
                startActivity(new Intent(mContext, ChargeActivity.class));
                break;
            case R.id.layout_order:
                if (VerifyLogin()!=null) {
                    Intent intent=new Intent(mContext, OrderActivity.class);
                    String UserId=getActivity().getIntent().getStringExtra("UserId");
                    intent.putExtra("UserId",UserId);
                    startActivity(intent);
                }else {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.layout_parking_space:
                startActivity(new Intent(mContext, ParkingSpaceActivity.class));
                break;
            default:
                break;
        }
    }
    public String VerifyLogin() {
        Intent intent = getActivity().getIntent();
        String UserId = intent.getStringExtra("UserId");
        if (UserId != null) {
            return UserId;
        }
        return null;
    }
}
