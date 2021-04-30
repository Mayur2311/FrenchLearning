package com.example.learnfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class simplesentence extends AppCompatActivity {
    Button nextbtn, prevbtn, homebtn;
    public void playPhrase(View view) {

        Button buttonPressed = (Button) view;

        Log.i("Button pressed", buttonPressed.getTag().toString());

        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(buttonPressed.getTag().toString(), "raw", getPackageName()));

        mediaPlayer.start();

    }
  /*  ListView simplelistView;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    Button nextbtn, prevbtn, homebtn;
    String simpleArray[]= {"• So, you’ve learned the basics of French and you’re ready to practice.\n\n"+
    "• Congratulations! Give yourself a well-deserved pat on the back.\\n\\n\" +" +
     "Having a conversation in French is much like having one in English, as parler de tout et de rien (small talk) is essentially the same all around the world.\n\n"+
    "But there are some basic words and phrases you should know before you say “bonjour” to your new acquaintance and get into the thick of conversation.\n\n"+
    "• Must-know French Sentences for Basic Conversation are.\n\n"+
    "• 1.Comment vous appelez-vous? (What’s your name?)\n\n" +
    "• 2.Je m’appelle… (My name is…)\n\n"+
    "• 3.Comment ca va? (How are you?)\n\n"+
    "• 4.Je vais bien (I am fine)\n\n"+
    "• 5.How's your day? (Comment est ta journee?)\n\n" +
    "• 6.Enchanté(e)! (Pleased to meet you!)\n\n"+
    "• 7.Je viens de… (I’m from…)\n\n"+
    "• 8.J’habite à… (I live in…)\n\n"+
    "• 9.Qu’est-ce que vous faites? (What is your profession?)\n\n"+
    "• 10.Qu’est-ce que vous aimez faire pendant votre temps libre? (What do you do in your free time?)\n\n"+
    "• 11.Quel temps fait-il? (How’s the weather?)\n\n"+
    "• 12.Est-ce que vous avez des frères et sœurs? (Do you have siblings?)\n\n"+
    "• 13.Quel est ton/votre film préféré? (What’s your favorite movie?)\n\n"+
    "• 14.Est-ce que vous avez visité…? (Have you visited… ?)\n\n"+
    "• 15.Pourriez-vous répéter? (Can you please repeat that?)\n\n"+
    "• 16.Je ne comprends pas. (I don’t understand.)\n\n"+
    "• 17.Comment dit-on ~ en français? (How do you say ~ in French?)\n\n"+
    "From a coffee shop chat to a quick catch-up on the subway, these quick conversations can happen anytime – and these phrases will help you succeed whenever they occur!"};

   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplesentence);
     /*   simplelistView = findViewById(R.id.simplelistView);


        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(simpleArray));

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        simplelistView.setAdapter(adapter);

      */
        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);


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
                Intent intent = new Intent(getApplicationContext(),grammar.class);
                startActivity(intent);
            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), words.class);
                startActivity(intent);
            }
        });


    }
}