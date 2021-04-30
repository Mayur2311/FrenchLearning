package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class advance_complex_words extends AppCompatActivity {

    Button prevbtn, homebtn, nextbtn;

    public void playPhrase(View view) {

        Button buttonPressed = (Button) view;

        Log.i("Button pressed", buttonPressed.getTag().toString());

        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(buttonPressed.getTag().toString(), "raw", getPackageName()));

        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_complex_words);

        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);
        nextbtn = findViewById(R.id.nextButton);

       prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), advance_complex.class);
                startActivity(intent);
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), advance_complex_question.class);
                startActivity(intent);
            }
        });
    }
}