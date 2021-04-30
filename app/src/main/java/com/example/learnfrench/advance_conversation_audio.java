package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class advance_conversation_audio extends AppCompatActivity {

    Button prevbtn, homebtn, nextbtn;
    MediaPlayer mediafirst, mediasecond, mediathird, mediafourth, mediafifth, mediasixth, mediaseventh, mediaeighth, medianinegth, mediatength;
            ;
    public void play1(View view){
        mediafirst.start();
    }
    public void pause1(View view){
        mediafirst.pause();
    }

    public void play2(View view){
        mediasecond.start();
    }
    public void pause2(View view){
        mediasecond.pause();
    }

    public void play3(View view){
        mediathird.start();
    }
    public void pause3(View view){
        mediathird.pause();
    }

    public void play4(View view){
        mediafourth.start();
    }
    public void pause4(View view){
        mediafourth.pause();
    }

    public void play5(View view){
        mediafifth.start();
    }
    public void pause5(View view){
        mediafifth.pause();
    }

    public void play6(View view){
        mediasixth.start();
    }
    public void pause6(View view){
        mediasixth.pause();
    }

    public void play7(View view){
        mediaseventh.start();
    }
    public void pause7(View view){
        mediaseventh.pause();
    }

    public void play8(View view){
        mediaeighth.start();
    }
    public void pause8(View view){
        mediaeighth.pause();
    }

    public void play9(View view){
        medianinegth.start();
    }
    public void pause9(View view){
        medianinegth.pause();
    }

    public void play10(View view){
        mediatength.start();
    }
    public void pause10(View view){
        mediatength.pause();
    }

/*    public void playPhrase(View view) {

        Button buttonPressed = (Button) view;

        Log.i("Button pressed", buttonPressed.getTag().toString());

        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(buttonPressed.getTag().toString(), "raw", getPackageName()));

        mediaPlayer.start();
    }  */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_conversation_audio);

        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);
        nextbtn = findViewById(R.id.nextButton);

        mediafirst= MediaPlayer.create(this,R.raw.audiofirst);
        mediasecond= MediaPlayer.create(this,R.raw.audiosecond);
        mediathird= MediaPlayer.create(this,R.raw.audiothird);
        mediafourth= MediaPlayer.create(this,R.raw.audiofourth);
        mediafifth= MediaPlayer.create(this,R.raw.audiofifth);
        mediasixth= MediaPlayer.create(this,R.raw.audiosixth);
        mediaseventh= MediaPlayer.create(this,R.raw.audioseventh);
        mediaeighth= MediaPlayer.create(this,R.raw.audioeighth);
        medianinegth= MediaPlayer.create(this,R.raw.audioninegth);
        mediatength= MediaPlayer.create(this,R.raw.audiotength);

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), advance_conversation_transalation.class);
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
                Toast.makeText(advance_conversation_audio.this,"You have completed learning Advance Level", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}