package com.example.bachelorhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ApartmentOwnerSignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_owner_signup);
        Button aptOwnerSignupToLogin = (Button) findViewById(R.id.aptOwnerSignupPageLoginButton);
        aptOwnerSignupToLogin.setOnClickListener(v -> openLoginPageActivity());

    }

    public void openLoginPageActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}