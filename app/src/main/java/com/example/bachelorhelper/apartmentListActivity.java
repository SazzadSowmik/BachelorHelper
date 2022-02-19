package com.example.bachelorhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class apartmentListActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_apartment_list);

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


}