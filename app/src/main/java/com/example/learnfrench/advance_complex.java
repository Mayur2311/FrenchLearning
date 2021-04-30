package com.example.learnfrench;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class advance_complex extends AppCompatActivity {

/*    ListView compoundlistview;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;  */

    Button nextbtn, homebtn, prevbtn, complexWords, complexQuestion,complexClarification;

/*    String complexArray[] = {"• Let’s learn about what makes up compound sentences.\n\n" +
            "• There are two types of conjunctions that join sentences together: Coordinating conjunctions & Subordinating conjunctions.\n\n" +
            "• Coordinating conjunctions create compound sentences, sentences in which neither clause is subordinate to the other. Typical coordinating conjunctions are et, mais, and ou.\n" +

            "• Look at following Examples.\n" +
            "1. I went to his office and asked for an interview.\n" +
            "A. Je suis allé(e) à son bureau et j’ai demandé une interview.\n" +
            "2. We went out, but she stayed home.\n" +
            "A. Nous, on est sortis, mais elle, elle est restée à la maison.\n" +
            "3. Let me work, or I’ll leave.\n" +
            "A. Laissez-moi travailler ou je m’en vais.\n\n" +

            "• The French equivalent of not only… but also is non seulement… mais aussi.\n" +
            "For example:\n" +
            "1. It’s not only cold, but it’s also snowing.\n" +
            "A. Non seulement il fait froid, mais il neige aussi.\n\n" +

            "• The conjunction ou may be expanded to ou alors.\n" +
            "For example:\n" +
            "1. Let me work, or else I’ll leave.\n" +
            "A. Laissez-moi travailler ou alors je m’en vais.\n\n" +

            "• Ou bien adds a note of emphatic exclusion of one of the alternatives. It may appear at the head of both conjoined sentences.\n" +
            "For example:\n" +
            "1. Either he’s lying or she is.\n" +
            "A. Ou bien c’est lui qui ment ou bien c’est elle.\n" +
            "2. Either I continue being a tenant or I become an owner.\n" +
            "A. Ou bien je reste locataire ou bien je deviens propriétaire.\n\n" +

            "• Soit…soit also conjoins two sentences with the meaning either…or.\n" +
            "For example:\n" +
            "1. Either they knew it already or they got an email about it.\n" +
            "A. Soit ils le savaient déjà, soit ils ont reçu un courriel à cet égard\n"};   */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_complex);

/*        //Initialization
        compoundlistview = findViewById(R.id.compoundListView);  */

        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);


        complexWords = findViewById(R.id.advance_complex_words);
        complexQuestion = findViewById(R.id.advance_complex_question);
        complexClarification = findViewById(R.id.advance_complex_clarification);

        complexWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), advance_complex_words.class);
                startActivity(intent);
            }
        });

        complexQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), advance_complex_question.class);
                startActivity(i);
            }
        });

        complexClarification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), advance_complex_clarification.class);
                startActivity(i);
            }
        });


/*        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(complexArray));

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        compoundlistview.setAdapter(adapter);     */

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
                Intent intent = new Intent(getApplicationContext(), advance_conversation.class);
                startActivity(intent);
            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(advance_complex.this, "PRESS NEXT!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
