package com.example.bachelorhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HouseMaidSignupActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_maid_signup);
        Button maidSignupToLogin = (Button) findViewById(R.id.maidSignupPageLoginButton);
        maidSignupToLogin.setOnClickListener(v -> openLoginPageActivity());

    }

    public void openLoginPageActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}