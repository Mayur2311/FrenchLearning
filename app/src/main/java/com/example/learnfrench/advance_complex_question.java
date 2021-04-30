package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class advance_complex_question extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    Button nextbtn, prevbtn, homebtn;

    public void play(View view){
        mediaPlayer.start();
    }
    public void pause(View view){
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_complex_question);

        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);
        mediaPlayer= MediaPlayer.create(this,R.raw.complexquestion);
        audioManager=(AudioManager)getSystemService(AUDIO_SERVICE);

        int currentvolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxvolume= audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        SeekBar volumeControl=(SeekBar)findViewById(R.id.seekBar);
        volumeControl.setMax(maxvolume);
        volumeControl.setProgress(currentvolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("Seekbar changed",Integer.toString(i));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar scrub= (SeekBar)findViewById(R.id.scrub);
        scrub.setMax(mediaPlayer.getDuration());

        scrub.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("scrub sucessful",Integer.toString(i));
                mediaPlayer.seekTo(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrub.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,300);

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),advance_complex_words.class);
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

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), advance_complex_clarification.class);
                startActivity(intent);
            }
        });
    }
}