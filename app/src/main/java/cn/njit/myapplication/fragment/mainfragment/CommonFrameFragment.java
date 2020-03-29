package cn.njit.myapplication.fragment.mainfragment;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.youth.banner.Banner;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

import cn.njit.myapplication.ImageAdapter;
import cn.njit.myapplication.R;
import cn.njit.myapplication.fragment.BaseFragment;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CommonFrameFragment extends BaseFragment {

    private static final String TAG = CommonFrameFragment.class.getSimpleName();//"CommonFrameFragment"


    private Banner banner;

    @Override
    protected View initView() {
        Log.e(TAG, "常用框架Fragment页面被初始化了...");
        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        androidx.appcompat.widget.SearchView searchView = view.findViewById(R.id.searchView);
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
}
