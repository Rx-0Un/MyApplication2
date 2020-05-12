package cn.njit.myapplication.activity.charge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.njit.myapplication.R;

public class ChargeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_charge);
    }
}
