package cn.njit.myapplication.model.modelImpl;

import android.util.Log;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import cn.njit.myapplication.Bean.ParkingSpaceResult;
import cn.njit.myapplication.listener.OnParkingSpaceFinishedListener;
import cn.njit.myapplication.model.modelInterface.ParkingSpaceModel;
import cn.njit.myapplication.tool.ConnectUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ParkingSpaceModelImpl implements ParkingSpaceModel {
    @Override
    public void selectNotOccupy(OnParkingSpaceFinishedListener listener) {
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .build();
        final Request request = new Request.Builder()
                .url(ConnectUtil.Base_Url + "/App/ParkingSpace/selectNotOccupy")
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
                ParkingSpaceResult parkingSpaceResult = new Gson().fromJson(responseData, ParkingSpaceResult.class);
                Log.e("解析", parkingSpaceResult.toString());
                listener.onLoadParkingSpaceSuccess(parkingSpaceResult);
            }
        });
    }

    @Override
    public void selectParkingSpaceByUserId(String userId, OnParkingSpaceFinishedListener listener) {
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("userId",userId)
                .build();
        final Request request = new Request.Builder()
                .url(ConnectUtil.Base_Url + "/App/ParkingSpace/selectOrderByUserId")
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
                ParkingSpaceResult parkingSpaceResult = new Gson().fromJson(responseData, ParkingSpaceResult.class);
                Log.e("解析", parkingSpaceResult.toString());
                listener.onLoadParkingSpaceSuccess(parkingSpaceResult);
            }
        });
    }
}
