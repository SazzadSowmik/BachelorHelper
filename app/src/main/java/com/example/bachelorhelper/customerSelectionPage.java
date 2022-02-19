package com.example.bachelorhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class customerSelectionPage extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_selection_page);

        button = (Button) findViewById(R.id.apartmentDetails);
        button.setOnClickListener(view -> ApartmentSearchListPage());
        button = (Button) findViewById(R.id.maidDetails);
        button.setOnClickListener(view -> maidSearchListPage());
    }

    public void ApartmentSearchListPage(){
        Intent intent = new Intent(this, ApartmentSearchListPage.class);
        startActivity(intent);
    }

    public void maidSearchListPage(){
        Intent intent = new Intent(this, maidSearchListPage.class);
        startActivity(intent);
    }
}