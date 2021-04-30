package com.example.learnfrench;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class advance_conversation extends AppCompatActivity {

/*    ListView complexlistview;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;  */
    Button translation, audio, nextbtn, homebtn, prevbtn;

/*    String complexArray[] = {"• Let’s learn about what makes up complex sentences.\n\n" +

            "• What is a complex sentence?\n\n" +
            "• A sentence that contains two or more conjugated verbs is known as a complex sentence (une phrase complexe). These sentences are made up of two or more clauses, whereas simple sentences (les phrases simples) only contain one conjugated verb and therefore only one clause.\n\n" +
            "• A clause is a group of words based around a verb. The verb of a clause is almost always conjugated, however there are some exceptions.\n\n" +
            "• Subordinating conjunctions embed a sentence within a larger sentence, and that embedded sentence is then dependent on, or subordinate to, the main clause. This is called a complex sentence. The most common subordinating conjunction in French is que.\n\n" +

            "• Que is followed by the indicative after verbs that emphasize the truth value of the subordinate clause, like savoir, affirmer, confirmer, déclarer, and  jurer.\n\n" +

            "• Look at the following examples:\n" +
            "1. We know they like France.\n" +
            "A. Nous savons qu‘ils aiment la France.\n" +
            "2. He affirms that he is not at all to blame.\n" +
            "A. Il affirme qu‘il n’y est pour rien.\n" +
            "3. I am confirming that I sold my house.\n" +
            "A. Je confirme que j’ai vendu ma maison.\n" +
            "4. She declared that she was the author of the message.\n" +
            "A. Elle a déclaré qu‘elle était l’auteur du message.\n" +
            "5. I swear that I returned it to him.\n" +
            "A. Je jure que je le lui ai rendu.\n\n" +

            "• Subordinating conjunctions that express cause and result also introduce clauses in the indicative One of the most common is parce que because.\n" +
            "For example:\n" +
            "1. We can’t go out because it’s raining.\n" +
            "A. On ne peut pas sortir parce qu‘il pleut.\n" +
            "2. I can’t go out with you because I have too much to do.\n" +
            "A. Je ne peux pas aller avec vous parce que j’ai trop à faire.\n\n" +

            "• There are many conjunctions of time that are always followed by the indicative.\n" +
            "• après que – after\n" +
            "• aussitôt que/dès que – as soon as\n" +
            "• chaque fois que – each time that\n" +
            "• depuis que – since/from the time that\n" +
            "• lorsque – when\n" +
            "• maintenant que – now that\n" +
            "• pendant que – while\n" +
            "• quand – when\n\n" +

            "Look at the following examples:\n" +
            "1. After you install this software, you will be able to work more efficiently.\n" +
            "A. Après que tu installeras ce logiciel, tu pourras travailler avec plus d’efficacité.\n" +
            "2. Each time I receive one of his emails, I read it with a great deal of interest.\n" +
            "A. Chaque fois que je reçois un de ses courriels, je le lis avec beaucoup d’intérêt.\n" +
            "3. I’m a bit frightened since I received his message.\n" +
            "A. Je suis un peu effrayé depuis que j’ai reçu son message.\n\n" +

            " • Note: aussitôt que, dès que, lorsque, and quand are followed by the future tense when the main clause is in the future or the imperative."};   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_conversation);

/*        //Initialization
        complexlistview = findViewById(R.id.complexListView);  */

        translation = findViewById(R.id.advance_conversation_translation);
        audio = findViewById(R.id.advance_conversation_audio);
        nextbtn = findViewById(R.id.nextButton);
        prevbtn = findViewById(R.id.prevButton);
        homebtn = findViewById(R.id.homeButton);

/*        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(complexArray));

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, complexArray);
        complexlistview.setAdapter(adapter);  */

        translation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), advance_conversation_transalation.class);
                startActivity(intent);
            }
        });

        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), advance_conversation_audio.class);
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
            public void onClick(View view) {
                Toast.makeText(advance_conversation.this,"You have completed learning Advance Level", Toast.LENGTH_SHORT).show();
            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), advance_complex.class);
                startActivity(intent);
            }
        });
    }
}