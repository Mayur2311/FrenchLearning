package com.example.learnfrench.ui.basicLevel;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.learnfrench.Basic_quiztest;
import com.example.learnfrench.R;
import com.example.learnfrench.Score;
import com.example.learnfrench.advance_complex_clarification;
import com.example.learnfrench.basic_alphabets;
import com.example.learnfrench.basic_numbers;
import com.example.learnfrench.days_of_week;
import com.example.learnfrench.months_name;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class BasicFragment extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    String fuser = firebaseAuth.getCurrentUser().getUid();


    ImageView imgAlphabets,imgNumbers,imgDaysofweek,imgMonthsName;
    Button btn_quiz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root= inflater.inflate(R.layout.fragment_basic, container, false);
        imgAlphabets=root.findViewById(R.id.imgAlphabets);
        imgNumbers=root.findViewById(R.id.imgNumbers);
        imgDaysofweek=root.findViewById(R.id.imgDaysofweek);
        imgMonthsName=root.findViewById(R.id.imgMonthsName);
        btn_quiz =  root.findViewById(R.id.quiz_btn);


        imgAlphabets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStatus(1);
                Intent i= new Intent(getActivity(), basic_alphabets.class);
                startActivity(i);



            }
        });

        imgNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStatus(2);
                Intent i= new Intent(getActivity(), basic_numbers.class);
                startActivity(i);
            }
        });
        imgDaysofweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStatus(3);
                Intent i= new Intent(getActivity(), days_of_week.class);
                startActivity(i);

            }
        });
        imgMonthsName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStatus(4);
                Intent i= new Intent(getActivity(), months_name.class);
                startActivity(i);
            }
        });


        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplicationContext(), Basic_quiztest.class);
                startActivity(i);
            }
        });


        return root;
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
                Toast.makeText(getContext().getApplicationContext(), "Error adding status" + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

