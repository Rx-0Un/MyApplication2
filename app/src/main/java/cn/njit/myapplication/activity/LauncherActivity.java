package cn.njit.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import cn.njit.myapplication.R;

public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startMainActivity();
            }
        }, 3000);
    }

    /**
     * 启动主页面
     */
    private void startMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        //关闭当前页面
        finish();

    }
}
