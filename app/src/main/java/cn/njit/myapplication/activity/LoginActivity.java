package cn.njit.myapplication.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.njit.myapplication.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    //按钮用于切换
    TextView tv_register;
    TextView tv_login;
    RelativeLayout layout_login;
    RelativeLayout layout_register;
    //输入栏用
    EditText et_login_name;
    EditText et_login_password;
    EditText et_register_phone;
    EditText et_register_password;
    EditText et_register_password_again;

    //登录注册按钮
    TextView login;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    public void initView() {
        layout_register = findViewById(R.id.layout_register);
        layout_login = findViewById(R.id.layout_register);
        tv_login = findViewById(R.id.tv_login);
        tv_register = findViewById(R.id.tv_register);
        et_login_name = findViewById(R.id.et_login_name);
        et_login_password = findViewById(R.id.et_login_password);
        et_register_phone = findViewById(R.id.et_register_phone);
        et_register_password = findViewById(R.id.et_register_password);
        et_register_password_again = findViewById(R.id.et_register_password_again);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
    }

    public void initListener() {
        tv_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                layout_login.setVisibility(View.GONE);
                layout_register.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_login:
                layout_register.setVisibility(View.GONE);
                break;
            case R.id.login:
                Log.v("R.id.login", "点击登录");
                doLogin(et_login_name.getText().toString(),
                        et_login_password.getText().toString());
                break;
            case R.id.register:
                Log.v("R.id.register", "点击注册");
                break;
            default:
                break;
        }
    }
    public void doLogin(String phone,String password){

    }
}
