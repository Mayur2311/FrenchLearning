package com.example.learnfrench.ui.intermediatelevel;

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
import com.example.learnfrench.grammar;
import com.example.learnfrench.intermediate_quiz;
import com.example.learnfrench.simplesentence;
import com.example.learnfrench.words;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class IntermediateFragment extends Fragment {

    FirebaseFirestore db =  FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth =  FirebaseAuth.getInstance();
    String fuser = firebaseAuth.getCurrentUser().getUid();


    ImageView imgwords,imgsimple,imggrammar;
    Button quiz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root= inflater.inflate(R.layout.fragment_intermediate, container, false);
        imgwords=root.findViewById(R.id.imgwords);
        imgsimple=root.findViewById(R.id.imgsimple);
        imggrammar=root.findViewById(R.id.imggrammar);
        quiz=root.findViewById(R.id.Quiz);

        imgwords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStatus(6);
              Intent i=new Intent(getActivity(), words.class);
              startActivity(i);

            }
        });
        imgsimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStatus(7);
                Intent i=new Intent(getActivity(), simplesentence.class);
                startActivity(i);
            }
        });
        imggrammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStatus(8);
                Intent i=new Intent(getActivity(), grammar.class);
                startActivity(i);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(), intermediate_quiz.class);
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
