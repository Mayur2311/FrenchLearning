package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class words extends AppCompatActivity {

    ListView wordslistView;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    Button nextbtn, prevbtn, homebtn;
    String wordsArray[]= {"Hi-  Salut ","Hello-  Bonjur","Please-  Sil-vous plait","Thank You-  Merci","Welcome-  Bienvenue","Excuse me-  Excusez moi","Sorry-  Pardon","Goodbye-  Au revoir",
            "Yes-  Oui","No-  Non","Open-  Ouvert ","Thank you very much-  Merci beaucoup","Girl-  Fille","Boy-  Garcon","Men-  Hommes",
            "Women-  Femmes","Father-  père","Mother-  mère","Brother-  frère","Sister-  \n" +
            "Sœur","French-  français","You'r Welcome(formal way)-  Je vous en prie","You'r Welcome(casual,informal way)-  De Rien",
            "Time-  Temps","Days-  Jour"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        wordslistView = findViewById(R.id.wordslistView);

        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);

        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(wordsArray));

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        wordslistView.setAdapter(adapter);


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
                Intent intent = new Intent(getApplicationContext(),simplesentence.class);
                startActivity(intent);
            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(words.this, "PRESS NEXT!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}