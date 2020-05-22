package cn.njit.myapplication.model.modelImpl;

import android.util.Log;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import cn.njit.myapplication.Bean.MyPageBean;
import cn.njit.myapplication.listener.OnMyPageLoadFinishListener;
import cn.njit.myapplication.model.modelInterface.MyPageModel;
import cn.njit.myapplication.tool.ConnectUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyPageModelImpl implements MyPageModel {

    @Override
    public void selectPageDetail(String phone, OnMyPageLoadFinishListener listener) {
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("phone", phone)
                .build();
        final Request request = new Request.Builder()
                .url(ConnectUtil.Base_Url + "/App/myPage/selectRowByPhone")
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.v("！！", "失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseData = response.body().string();
                Log.e("成功", responseData);
                MyPageBean myPageBean = new Gson().fromJson(responseData, MyPageBean.class);
                Log.e("解析", myPageBean.toString());
                listener.onLoadMyPageSuccess(myPageBean);
            }
        });
    }
}
