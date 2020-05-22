package cn.njit.myapplication.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cn.njit.myapplication.R;
import cn.njit.myapplication.application.UserApplication;
import cn.njit.myapplication.presenter.presenterImpl.LoginPresenterImpl;
import cn.njit.myapplication.presenter.presenterInterface.LoginPresenter;
import cn.njit.myapplication.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

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

    //进度条
    ProgressBar progressBar;


    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
        presenter = new LoginPresenterImpl(this);
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
        progressBar = findViewById(R.id.progressBar);
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
                presenter.validateCredentials(et_login_name.getText().toString(), et_login_password.getText().toString());
                break;
            case R.id.register:
                Log.v("R.id.register", "点击注册");
                presenter.addNewUser(
                        et_register_phone.getText().toString(),
                        et_register_password.getText().toString(),
                        et_register_password_again.getText().toString());

                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                hideProgress();
                Toast.makeText(LoginActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setPasswordError() {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                hideProgress();
                Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void navigateToHome() {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                hideProgress();
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                UserApplication app=(UserApplication)getApplication();
                app.setUserPhone(et_login_name.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("userPhone", et_login_name.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void setPasswordNotEqual() {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                hideProgress();
                Toast.makeText(LoginActivity.this, "两个密码不一致", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setUserExist() {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                hideProgress();
                Toast.makeText(LoginActivity.this, "用户已经存在", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setRegisteredSuccess() {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                hideProgress();
                Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                et_login_name.setText(et_register_phone.getText());
                et_login_password.setText(et_login_password.getText());
                et_register_phone.setText("");
                et_register_password.setText("");
                et_register_password_again.setText("");
                layout_register.setVisibility(View.GONE);
            }
        });
    }

}
