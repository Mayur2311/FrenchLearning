package com.example.learnfrench;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Basic_quiztest extends AppCompatActivity {

    Button  btn_optA, btn_optB, btn_optC, btn_optD,btn_next;
    TextView txt_question, score_lbl;
    int levelCheck = 1;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    String fuser = firebaseAuth.getCurrentUser().getUid();

    int score = 0, questionNumner = 0, finalscore = 0;



    String[] questionArray = new String[5];
    String[] optionA_Array = new String[5];
    String[] optionB_Array = new String[5];
    String[] optionC_Array = new String[5];
    String[] optionD_Array = new String[5];
    String[] rightAns_Array = new String[5];

    String question1, question2, question3, question4, question5;

    String optionA_que1, optionB_que1, optionC_que1, optionD_que1,
            optionA_que2, optionB_que2, optionC_que2, optionD_que2,
            optionA_que3, optionB_que3, optionC_que3, optionD_que3,
            optionA_que4, optionB_que4, optionC_que4, optionD_que4,
            optionA_que5, optionB_que5, optionC_que5, optionD_que5;

    String rightanswer1, rightanswer2, rightanswer3, rightanswer4, rightanswer5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_quiztest);

        txt_question = findViewById(R.id.txt_question);
        btn_optA = findViewById(R.id.btn_option1);
        btn_optB = findViewById(R.id.btn_option2);
        btn_optC = findViewById(R.id.btn_option3);
        btn_optD = findViewById(R.id.btn_option4);
//        btn_next = findViewById(R.id.btn_next);
//        score_lbl = findViewById(R.id.score_lable);

//      btn_next.setVisibility(View.INVISIBLE);

        question1 = "How to pronounce K in french ?";
        optionA_que1 = "key";
        optionB_que1 = "Car";
        optionC_que1 = "Ke";
        optionD_que1 = "Ca";
        rightanswer1 = "key";

        question2 = "How to speak thursday in french ?";
        optionA_que2 = "Mardi";
        optionB_que2 = "Lundi";
        optionC_que2 = "Mercrdi";
        optionD_que2 = "Jeudi";
        rightanswer2 = "Jeudi";

        question3 = "How to spea k sunday in french  ?";
        optionA_que3 = "Dimanche";
        optionB_que3 = "Samedi";
        optionC_que3 = "Vendredi";
        optionD_que3 = "Jeudi";
        rightanswer3 = "Dimanche";

        question4 = "How to speak 8 number in french ?";
        optionA_que4 = "Eight";
        optionB_que4 = "Huit";
        optionC_que4 = "Trois";
        optionD_que4 = "Sept";
        rightanswer4 = "Huit";


        question5 = "How to speak month of March in French ?";
        optionA_que5 = "Mars";
        optionB_que5 = "Avril";
        optionC_que5 = "Mai";
        optionD_que5 = "Juin";
        rightanswer5 = "Mars";

        questionArray = new String[]{question1, question2, question3, question4, question5};
        optionA_Array = new String[]{optionA_que1, optionA_que2, optionA_que3, optionA_que4, optionA_que5};
        optionB_Array = new String[]{optionB_que1, optionB_que2, optionB_que3, optionB_que4, optionB_que5};
        optionC_Array = new String[]{optionC_que1, optionC_que2, optionC_que3, optionC_que4, optionC_que5};
        optionD_Array = new String[]{optionD_que1, optionD_que2, optionD_que3, optionD_que4, optionD_que5};

        rightAns_Array = new String[]{rightanswer1, rightanswer2, rightanswer3, rightanswer4, rightanswer5};

        txt_question.setText(questionArray[questionNumner]);
        btn_optA.setText(optionA_Array[questionNumner]);
        btn_optB.setText(optionB_Array[questionNumner]);
        btn_optC.setText(optionC_Array[questionNumner]);
        btn_optD.setText(optionD_Array[questionNumner]);


        btn_optA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(btn_optA.getText() == rightAns_Array[questionNumner])
                {
                    btn_optA.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

                    finalscore++;
                }
                else
                {
                    btn_optA.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

                    if(btn_optB.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optB.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }
                    else if(btn_optC.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optC.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }
                    else if(btn_optD.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optD.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }

                }

                questionNumner++;

                if(questionNumner >=5)
                {
                    insertStatus(5);
                    insertBasicScore(finalscore);
                    Intent i = new Intent(getApplicationContext(), Score.class);
                    i.putExtra("BasiclevelCheck",levelCheck);
                    i.putExtra("BasicSrc",finalscore);
                    startActivity(i);
                }
                else {

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            txt_question.setText(questionArray[questionNumner]);
                            btn_optA.setText(optionA_Array[questionNumner]);
                            btn_optB.setText(optionB_Array[questionNumner]);
                            btn_optC.setText(optionC_Array[questionNumner]);
                            btn_optD.setText(optionD_Array[questionNumner]);

                            btn_optA.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optB.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optC.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optD.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));

                        }
                    }, 2000);

                }


            }
        });

        btn_optB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(btn_optB.getText().equals(rightAns_Array[questionNumner]))
                {
                     btn_optB.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

                     finalscore++;
                }
                else
                {
                    btn_optB.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

                    if(btn_optA.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optA.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }
                    else if(btn_optC.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optC.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }
                    else if(btn_optD.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optD.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }


                }

                questionNumner++;

                if(questionNumner >=5)
                {
                    insertStatus(5);
                    insertBasicScore(finalscore);
                    Intent i = new Intent(getApplicationContext(), Score.class);
                    i.putExtra("BasiclevelCheck",levelCheck);
                    i.putExtra("BasicSrc",finalscore);
                    startActivity(i);
                }
                else {

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            txt_question.setText(questionArray[questionNumner]);
                            btn_optA.setText(optionA_Array[questionNumner]);
                            btn_optB.setText(optionB_Array[questionNumner]);
                            btn_optC.setText(optionC_Array[questionNumner]);
                            btn_optD.setText(optionD_Array[questionNumner]);

                            btn_optA.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optB.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optC.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optD.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));

                        }
                    }, 2000);


                }

            }
        });

        btn_optC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(Basic_quiztest.this, "RightAnswer:"+rightAns_Array[questionNumner], Toast.LENGTH_SHORT).show();


                if(btn_optC.getText().equals(rightAns_Array[questionNumner]))
                {
                    btn_optC.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

                    finalscore++;
                }
                else
                {
                    btn_optC.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

                    if(btn_optA.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optA.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }
                    else if(btn_optB.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optB.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }
                    else if(btn_optD.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optD.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }


                }

                questionNumner++;

                if(questionNumner >=5)
                {
                    insertStatus(5);
                    insertBasicScore(finalscore);
                    Intent i = new Intent(getApplicationContext(), Score.class);
                    i.putExtra("BasiclevelCheck",levelCheck);
                    i.putExtra("BasicSrc",finalscore);
                    startActivity(i);

                }else {

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            txt_question.setText(questionArray[questionNumner]);
                            btn_optA.setText(optionA_Array[questionNumner]);
                            btn_optB.setText(optionB_Array[questionNumner]);
                            btn_optC.setText(optionC_Array[questionNumner]);
                            btn_optD.setText(optionD_Array[questionNumner]);

                            btn_optA.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optB.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optC.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optD.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));

                        }
                    }, 2000);

                }


            }
        });

        btn_optD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(Basic_quiztest.this, "RightAnswer:"+rightAns_Array[questionNumner], Toast.LENGTH_SHORT).show();

                if(btn_optD.getText().equals(rightAns_Array[questionNumner]))
                {
                    btn_optD.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    finalscore++;
                }
                else
                {
                    btn_optD.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

                    if(btn_optA.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optA.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }
                    else if(btn_optB.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optB.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }
                    else if(btn_optC.getText().equals(rightAns_Array[questionNumner]))
                    {
                        btn_optC.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }

                }

                questionNumner++;

                if(questionNumner >=5)
                {
                    insertStatus(5);
                    insertBasicScore(finalscore);
                    Intent i = new Intent(getApplicationContext(), Score.class);
                    i.putExtra("BasiclevelCheck",levelCheck);
                    i.putExtra("BasicSrc",finalscore);
                    startActivity(i);
                }else {

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            txt_question.setText(questionArray[questionNumner]);
                            btn_optA.setText(optionA_Array[questionNumner]);
                            btn_optB.setText(optionB_Array[questionNumner]);
                            btn_optC.setText(optionC_Array[questionNumner]);
                            btn_optD.setText(optionD_Array[questionNumner]);

                            btn_optA.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optB.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optC.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));
                            btn_optD.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#3F51B5")));

                        }
                    }, 2000);

                }


            }
        });

    }


    public void insertBasicScore(int finalscore) {

        Map<String, Object> score = new HashMap<>();

        score.put("score", finalscore);

        db.collection("Score").document(fuser).collection("BasicLevel").add(score)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Basic_quiztest.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void insertStatus(int statusCode)
    {
        Map<String, Object> status = new HashMap<>();
        status.put("status",statusCode);

        db.collection("Status").document(fuser).collection("basicStatus").document("status").set(status)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Basic_quiztest.this, "Error adding status" + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
