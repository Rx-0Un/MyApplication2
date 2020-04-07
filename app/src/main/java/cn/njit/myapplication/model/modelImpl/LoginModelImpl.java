package cn.njit.myapplication.model.modelImpl;

import android.util.Log;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import cn.njit.myapplication.listener.OnLoginFinishedListener;
import cn.njit.myapplication.model.modelInterface.LoginModel;
import cn.njit.myapplication.tool.ConnectUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(String username, String password, OnLoginFinishedListener listener) {
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("phone", username)
                .add("password", password)
                .build();
        final Request request = new Request.Builder()
                .url(ConnectUtil.Base_Url+"App/login")
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
                Log.e("成功", response.body().string());
                String responseData = response.body().toString();
                Gson gson = new Gson();
                String str = gson.toJson(responseData);
                Log.e("解析", str);
                listener.onSuccess();
            }
        });
    }
}
