package com.example.learnfrench.ui.advancelevel;

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

import com.example.learnfrench.R;
import com.example.learnfrench.advance_conversation;
import com.example.learnfrench.advance_complex;
import com.example.learnfrench.advance_quiz;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AdvanceFragment extends Fragment {

    FirebaseFirestore db =  FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    String fuser = firebaseAuth.getCurrentUser().getUid();

    ImageView imgComplex,imgConversation;
    Button btn_quiz;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root= inflater.inflate(R.layout.fragment_advance, container, false);
        imgComplex=root.findViewById(R.id.imgComplex);
        imgConversation=root.findViewById(R.id.imgConversation);
        btn_quiz=root.findViewById(R.id.Quiz);

        imgComplex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStatus(10);
                Intent i= new Intent(getActivity(), advance_complex.class);
                startActivity(i);
            }
        });

        imgConversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStatus(11);
                Intent i= new Intent(getActivity(), advance_conversation.class);
                startActivity(i);
            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(getActivity(), advance_quiz.class);
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
