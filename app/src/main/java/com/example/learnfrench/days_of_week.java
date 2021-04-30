package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.learnfrench.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class days_of_week extends AppCompatActivity {

    ListView daysofweekListview;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    Button nextbtn, prevbtn, homebtn;
    String daysofweekArray[]= {"Monday - Lundi","Tuesday - Mardi","Wednesday - Mercredi",
                                "Thursday - Jeudi","Friday - Vendredi","Saturday - Samedi",
                                "Sunday - Dimanche"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_of_week);

        daysofweekListview = findViewById(R.id.daysofweekListView);

        nextbtn =  findViewById(R.id.nextButton);
        prevbtn =  findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);

        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(daysofweekArray));

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        daysofweekListview.setAdapter(adapter);


        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), months_name.class);
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
                Intent intent = new Intent(getApplicationContext(), basic_numbers.class);
                startActivity(intent);
            }
        });
    }
}