package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Arrays;

public class grammar extends AppCompatActivity {

   // MediaPlayer mediaPlayer;

  /* public void play(View view){
       mediaPlayer.start();
   }

   */

  Button nextbtn, prevbtn, homebtn,nouns,verbs,tenses,adjectives,pronouns,adverbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

     //   mediaPlayer= MediaPlayer.create(this,R.raw.purevowels);
        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);
        nouns=findViewById(R.id.nouns);
        verbs=findViewById(R.id.verbs);
        tenses=findViewById(R.id.tenses);
        adjectives=findViewById(R.id.adjective);
        pronouns=findViewById(R.id.pronoun);
        adverbs=findViewById(R.id.adverb);

        nouns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent i =new Intent(getApplicationContext(),nouns.class);
                 startActivity(i);
            }
        });

         verbs.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i =new Intent(getApplicationContext(),verbs.class);
                 startActivity(i);
             }
         });

        adjectives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),adjective.class);
                startActivity(i);
            }
        });

        pronouns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),pronoun.class);
                startActivity(i);
            }
        });

        adverbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),adverb.class);
                startActivity(i);
            }
        });
        tenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),tenses.class);
                startActivity(i);
            }
        });





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
                Toast.makeText(grammar.this,"You have completed learning Intermediate Level", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), simplesentence.class);
                startActivity(intent);
            }
        });




        VideoView videoView=(VideoView)findViewById(R.id.video);
        videoView.setVideoPath("android.resource://"+getPackageName() +"/"+R.raw.grammar);
        MediaController mediaController =new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}