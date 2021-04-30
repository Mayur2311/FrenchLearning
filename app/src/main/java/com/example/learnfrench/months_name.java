package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.learnfrench.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class months_name extends AppCompatActivity {

    ListView monthsnameListView;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    Button nextbtn, prevbtn, homebtn;
    String monthsnameArray[]= {"January - Janvier","February - Fevrier","March - Mars","April - Aavril",
                                "May - Mai","June - Juin ","July - Juilettet","August - aout",
                                "September - Septembre","October - Octobre", "November - Novembre","December - Decembre"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months_name);

        monthsnameListView =  findViewById(R.id.monthsnameListView);

        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);

        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(monthsnameArray));


        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, monthsnameArray);
        monthsnameListView.setAdapter(adapter);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(months_name.this,"You have completed learning Basic Level", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                  }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), days_of_week.class);
                startActivity(intent);
            }
        });
    }
}