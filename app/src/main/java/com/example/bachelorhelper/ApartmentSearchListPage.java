package com.example.bachelorhelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.bachelorhelper.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class ApartmentSearchListPage extends AppCompatActivity {
    Spinner sp_parent, sp_child;

    //arraylist to choose cities
    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;

    //for area dropdown
    ArrayList<String> arrayList_Dhaka, arrayList_Chittagong, arrayList_Rajshahi;
    ArrayAdapter<String> arrayAdapter_child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_search_list_page);

        Button apartmentSearchButtuon = (Button) findViewById(R.id.apartmentSearchListButton);
        apartmentSearchButtuon.setOnClickListener(view -> AllRelatedApartments());

        //get id from the xml
        sp_parent = (Spinner) findViewById(R.id.sp_parent);
        sp_child = (Spinner) findViewById(R.id.sp_child);

        //add on the arraylist
        String [] cities = {"Dhaka", "Chittagong", "Rajshahi"};
        arrayList_parent = new ArrayList<>();
        arrayList_parent.addAll(Arrays.asList(cities));

        //display_cities
        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, arrayList_parent);

        sp_parent.setAdapter(arrayAdapter_parent);

        //*************    area part     **************
        arrayList_Dhaka = new ArrayList<>();
        String [] dhakaArea = {"Mirpur", "Mohakhali", "Farmgate", "Gulsan", "Badda",
                "Tejgaon", "Khilgaon", "Mohammadpur", "Dhanmondi"};
        arrayList_Dhaka.addAll(Arrays.asList(dhakaArea));

        arrayList_Chittagong = new ArrayList<>();
        String [] chitArea = {"Chittagong Sadar", "Hathazari", "Sitakunda"};
        arrayList_Chittagong.addAll(Arrays.asList(chitArea));

        arrayList_Rajshahi = new ArrayList<>();
        String [] rajArea = {"Rajshahi Sadar", "Bagha", "Putia", "Durgapur"};
        arrayList_Rajshahi.addAll(Arrays.asList(rajArea));



        sp_parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                String city = parent.getItemAtPosition(i).toString();
                if (i == 0){
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item,arrayList_Dhaka);
                }
                if (i == 1){
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item,arrayList_Chittagong);
                }
                if (i == 2){
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_dropdown_item,arrayList_Rajshahi);
                }

                sp_child.setAdapter(arrayAdapter_child);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void AllRelatedApartments() {
        Intent intent = new Intent(this, AllRelatedApartments.class);
        startActivity(intent);
    }


}