package com.example.learnfrench;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.DocumentsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MyScore extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    String fuser = firebaseAuth.getCurrentUser().getUid();

    TextView txt_all_score, txt_heading;
    Button btn_basicScore, btn_intermediateScore, btn_advanceScore, btn_back, btn_home;
    String scoreConcatination;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_my_score, container, false);

        txt_all_score = root.findViewById(R.id.txt_scoreView);
        btn_basicScore = root.findViewById(R.id.btn_basicScore);
        btn_intermediateScore = root.findViewById(R.id.btn_intermediateScore);
        btn_advanceScore = root.findViewById(R.id.btn_advanceScore);
        btn_back = root.findViewById(R.id.backButton);
        btn_home = root.findViewById(R.id.homeButton);
        txt_heading = root.findViewById(R.id.txt_heading);

        btn_back.setVisibility(View.INVISIBLE);
        btn_home.setVisibility(View.INVISIBLE);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_myscore);
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        btn_basicScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_back.setVisibility(View.VISIBLE);
                btn_home.setVisibility(View.VISIBLE);
                btn_basicScore.setVisibility(View.INVISIBLE);
                btn_intermediateScore.setVisibility(View.INVISIBLE);
                btn_advanceScore.setVisibility(View.INVISIBLE);
                txt_heading.setText("Basic level quiz results");
                showBasicScore();
            }
        });

        btn_intermediateScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_back.setVisibility(View.VISIBLE);
                btn_home.setVisibility(View.VISIBLE);
                btn_basicScore.setVisibility(View.INVISIBLE);
                btn_intermediateScore.setVisibility(View.INVISIBLE);
                btn_advanceScore.setVisibility(View.INVISIBLE);
                txt_heading.setText("Intermediate level quiz results");
                showIntermediateScore();
            }
        });

        btn_advanceScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_back.setVisibility(View.VISIBLE);
                btn_home.setVisibility(View.VISIBLE);
                btn_basicScore.setVisibility(View.INVISIBLE);
                btn_intermediateScore.setVisibility(View.INVISIBLE);
                btn_advanceScore.setVisibility(View.INVISIBLE);
                txt_heading.setText("Advance level quiz results");
                showAdvanceScore();
            }
        });
        return root;
    }

    public void showBasicScore()
    {
        txt_all_score.setText("");
        scoreConcatination = " ";

        db.collection("Score").document(fuser).collection("BasicLevel")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                List<DocumentSnapshot>  snapshotList = queryDocumentSnapshots.getDocuments();

                for(DocumentSnapshot snapshot:snapshotList)
                {
                    Log.d("Data", String.valueOf(snapshot.getLong("score")));

                    scoreConcatination += "\n" + "Score : " + String.valueOf(snapshot.getLong("score"));

//                    txt_all_score.setText(String.valueOf(snapshot.getLong("score"))+"/n");
                }
                txt_all_score.setText(scoreConcatination);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

//                Toast.makeText(getActivity().getApplicationContext(), "Error getting data", Toast.LENGTH_SHORT).show();
                txt_all_score.setText("No records found");

            }
        });
    }


    public void showIntermediateScore()
    {
        txt_all_score.setText("");
        scoreConcatination = "";

        db.collection("Score").document(fuser).collection("IntermediateLevel")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                List<DocumentSnapshot>  snapshotList = queryDocumentSnapshots.getDocuments();

                for(DocumentSnapshot snapshot:snapshotList)
                {
                    Log.d("Data", String.valueOf(snapshot.getLong("score")));

                    scoreConcatination += "\n"+ "Score : " +String.valueOf(snapshot.getLong("score"));

//                    txt_all_score.setText(String.valueOf(snapshot.getLong("score"))+"/n");
                }
                txt_all_score.setText(scoreConcatination);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

//                Toast.makeText(getActivity().getApplicationContext(), "Error getting data", Toast.LENGTH_SHORT).show();
                txt_all_score.setText("No records found");

            }
        });
    }


    public void showAdvanceScore()
    {
        txt_all_score.setText("");
        scoreConcatination = " ";

        db.collection("Score").document(fuser).collection("AdvanceLevel")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                List<DocumentSnapshot>  snapshotList = queryDocumentSnapshots.getDocuments();

                for(DocumentSnapshot snapshot:snapshotList)
                {
                    Log.d("Data", String.valueOf(snapshot.getLong("score")));

                    scoreConcatination += "\n"+ "Score : " +String.valueOf(snapshot.getLong("score"));

//                    txt_all_score.setText(String.valueOf(snapshot.getLong("score"))+"/n");
                }
                txt_all_score.setText(scoreConcatination);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

//                Toast.makeText(getActivity().getApplicationContext(), "Error getting data", Toast.LENGTH_SHORT).show();
                txt_all_score.setText("No records found");

            }
        });
    }
}