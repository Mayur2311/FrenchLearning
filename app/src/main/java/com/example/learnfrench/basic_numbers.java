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

public class basic_numbers extends AppCompatActivity {

    ListView numberListvew;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    Button nextbtn, prevbtn,homebtn;
    String numberArray[]= {"0 - ZERO", "1 - UN", "2 - DEUX", "3 - TROIS","4 - QUATRE",
                           "5 - CINQ","6 - SIX", "7 - SEPT","8 - HUIT","9 - NEUF",
                           "10 - DIX"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_numbers);

        numberListvew =  findViewById(R.id.numbersListView);

        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);

        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(numberArray));

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        numberListvew.setAdapter(adapter);


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
                Intent intent = new Intent(getApplicationContext(), days_of_week.class);
                startActivity(intent);
            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), basic_alphabets.class);
                startActivity(intent);
            }
        });
    }
}