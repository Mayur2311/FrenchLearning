package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class advance_conversation_transalation extends AppCompatActivity {

    Button nextbtn, homebtn, prevbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_conversation_transalation);

        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), advance_conversation_audio.class);
                startActivity(intent);
            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), advance_conversation.class);
                startActivity(intent);
            }
        });
    }
}