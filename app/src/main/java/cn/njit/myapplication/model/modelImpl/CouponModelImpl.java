package cn.njit.myapplication.model.modelImpl;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.njit.myapplication.Bean.CouponResult;
import cn.njit.myapplication.listener.OnCouponFinishedListener;
import cn.njit.myapplication.model.modelInterface.CouponModel;
import cn.njit.myapplication.tool.ConnectUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CouponModelImpl implements CouponModel {
    @Override
    public void selectAllByPage(int pageNum, int page, OnCouponFinishedListener listener) {
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("pageNum", String.valueOf(pageNum))
                .add("page", String.valueOf(page))
                .build();
        final Request request = new Request.Builder()
                .url(ConnectUtil.Base_Url + "App/couponManage/selectCouponByPage")
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.v("Coupon", "Coupon失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseData = response.body().string();
                Log.e("成功", responseData);
                CouponResult couponResult = new Gson().fromJson(responseData, CouponResult.class);
                Log.e("解析", couponResult.toString());
                listener.onSuccess(couponResult);
            }
        });
    }

    @Override
    public void selectCouponById(int pageNum, int page, String userId, OnCouponFinishedListener listener) {

    }
}
