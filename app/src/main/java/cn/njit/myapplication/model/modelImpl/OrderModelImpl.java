package cn.njit.myapplication.model.modelImpl;

import android.util.Log;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import cn.njit.myapplication.Bean.OrderResult;
import cn.njit.myapplication.listener.OnOrderFinishedListener;
import cn.njit.myapplication.model.modelInterface.OrderModel;
import cn.njit.myapplication.tool.ConnectUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OrderModelImpl implements OrderModel {
    @Override
    public void selectCouponById(String userId, OnOrderFinishedListener listener) {
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("userId", userId)
                .build();
        final Request request = new Request.Builder()
                .url(ConnectUtil.Base_Url + "/App/Order/selectOrderByName")
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
                OrderResult orderResult = new Gson().fromJson(responseData, OrderResult.class);
                Log.e("解析", orderResult.toString());
                listener.onLoadOrderSuccess(orderResult);
            }
        });
    }
}
