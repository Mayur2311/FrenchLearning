package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.learnfrench.ui.home.HomeFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class basic_alphabets extends AppCompatActivity {

    ListView alphalistview;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    Button nextbtn, prevbtn, homebtn;
    String alphaArray[]= {"A - ah","B - bay","C - say","D - day","E - er","F - eff","G - shay","H - ash",
                          "I - ee","J - shee","K - car","L - air","M - emm","N - enn","O - oh","P - pay",
                          "Q - coo","R - air","S - ess","T - ash","U - ee","V - shay","W - ash","X - ee",
                          "Y - shay","Z - ash"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_alphabets);

        //Initialization
        alphalistview = findViewById(R.id.alphaListView);

        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);

        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(alphaArray));

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        alphalistview.setAdapter(adapter);


        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),basic_numbers.class);
                startActivity(intent);
            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(basic_alphabets.this, "PRESS NEXT!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}