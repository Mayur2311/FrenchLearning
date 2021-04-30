package com.example.learnfrench;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class MyStatus extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    String fuser = firebaseAuth.getCurrentUser().getUid();
    DocumentReference documentReference;


    TextView txt_showStatus;
    Button btn_home;
    int statusNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_my_status, container, false);

        txt_showStatus =  root.findViewById(R.id.txt_basicStatus);
        btn_home =  root.findViewById(R.id.btn_home);

        //------------------------------------------------------------------------

        documentReference = db.collection("Status").document(fuser).collection("basicStatus").document("status");

        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                statusNumber = Math.toIntExact(value.getLong("status"));

                if(statusNumber == 1 || statusNumber == 2 || statusNumber == 3) {

                    txt_showStatus.setText("In the Learning Phase: Basic Level");

                }else if( statusNumber == 4){
                    txt_showStatus.setText("Basic Level: Quiz is remaining to complete learning.");
                }
                else if(statusNumber == 5) {
                    txt_showStatus.setText("Completed Leaning: Basic Level");
                }
                else if(statusNumber == 6 || statusNumber == 7 )
                {
                   txt_showStatus.setText("In the Learning Phase: Intermediate Level");
                }
                else if(statusNumber == 8)
                {
                  txt_showStatus.setText("Intermediate Level: Quiz is remaining to complete learning.");
                }
                else if(statusNumber == 9)
                {
                    txt_showStatus.setText("Completed Leaning: Intermediate Level");
                }
                else if(statusNumber == 10)
                {
                    txt_showStatus.setText("In the learning phase: Advance Level");
                }
                else if(statusNumber == 11)
                {
                    txt_showStatus.setText("Advance Level: Quiz is remaining to complete learning.");
                }
                else if(statusNumber == 12)
                {
                    txt_showStatus.setText("Completed Leaning: Advance Level"+"\n\n"+"You have completed French course.");
                }
                else {
                    txt_showStatus.setText("No data found!");
                }

            }
        });

        //------------------------------------------------------------------------


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });


        return  root;
    }

}