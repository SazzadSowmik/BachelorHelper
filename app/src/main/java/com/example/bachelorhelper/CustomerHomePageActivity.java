package com.example.bachelorhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CustomerHomePageActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home_page);

        button = (Button) findViewById(R.id.customerHomePageAptButton);
        button.setOnClickListener(view -> ApartmentSearchListPage());
        button = (Button) findViewById(R.id.customerHomePageMaidButton);
        button.setOnClickListener(view -> maidSearchListPage());
    }

    public void ApartmentSearchListPage(){
        Intent intent = new Intent(this, apartmentListActivity.class);
        startActivity(intent);
    }

    public void maidSearchListPage(){
        Intent intent = new Intent(this, MaidListActivity.class);
        startActivity(intent);
    }
}