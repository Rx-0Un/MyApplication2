package cn.njit.myapplication.tool;

import android.util.Log;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectUtil {
    public static void connect(String url){
//        "http://218.244.153.72:8080/App/login"
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

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
}
