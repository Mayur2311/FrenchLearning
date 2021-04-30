package com.example.learnfrench;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
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

public class Score extends AppCompatActivity {

    TextView txt_score;
    Button btn_home;

    FirebaseFirestore db;
    FirebaseAuth fauth;
    String fuser;
    DocumentReference documentReference;
    String b, i, a;

    int BasicintentValue, IntermediateintentValue, AdvanceintentValue;
    String BasicScore, IntermediateScore, AdvanceScore;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        BasicintentValue = getIntent().getExtras().getInt("BasiclevelCheck");
        IntermediateintentValue = getIntent().getExtras().getInt("IntermediatelevelCheck");
        AdvanceintentValue = getIntent().getExtras().getInt("AdvancelevelCheck");

        BasicScore = String.valueOf(getIntent().getExtras().getInt("BasicSrc"));
        IntermediateScore = String.valueOf(getIntent().getExtras().getInt("IntermediateSrc"));
        AdvanceScore = String.valueOf(getIntent().getExtras().getInt("AdvanceSrc"));

        db = FirebaseFirestore.getInstance();
        fauth = FirebaseAuth.getInstance();
        fuser =  fauth.getCurrentUser().getUid();

        txt_score =findViewById(R.id.txt_score);
        btn_home =  findViewById(R.id.btn_home);

        if(BasicintentValue == 1)
        {
           // readBasicData();
            txt_score.setText(BasicScore);
        }
        else if(IntermediateintentValue == 2)
        {
            //readIntermediateData();
            txt_score.setText(IntermediateScore);
        }
        else if(AdvanceintentValue == 3)
        {
            //readAdvanceData();
            txt_score.setText(AdvanceScore);
        }
        else
        {
            Toast.makeText(this, "No data found !!!", Toast.LENGTH_SHORT).show();
        }

        btn_home.setOnClickListener(v -> {

            Intent i  = new Intent(this, MainActivity.class);
            startActivity(i);

        });

    }

//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void readBasicData()
//    {
//        documentReference =  db.collection("Score").document(fuser).collection("BasicLevel").document("score");
//        documentReference.get().addOnSuccessListener(documentSnapshot -> {
//            if(documentSnapshot.exists())
//            {
//                 b = String.valueOf(Math.toIntExact(documentSnapshot.getLong("score")));
//
//
//                txt_score.setText(b);
//
////                Toast.makeText(this, s , Toast.LENGTH_SHORT).show();
//
//            }
//            else
//            {
//                Toast.makeText(Score.this, "Error detecting score", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(Score.this, "Error !!!", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//
//
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void readIntermediateData()
//    {
//        documentReference =  db.collection("Score").document(fuser).collection("IntermediateLevel").document("score");
//        documentReference.get().addOnSuccessListener(documentSnapshot -> {
//            if(documentSnapshot.exists())
//            {
//                i = String.valueOf(Math.toIntExact(documentSnapshot.getLong("score")));
//
//
//                txt_score.setText(i);
//
////                Toast.makeText(this, s , Toast.LENGTH_SHORT).show();
//
//            }
//            else
//            {
//                Toast.makeText(Score.this, "Error detecting score", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(Score.this, "Error !!!", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//
//
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void readAdvanceData()
//    {
//        documentReference =  db.collection("Score").document(fuser).collection("AdvanceLevel").document("score");
//        documentReference.get().addOnSuccessListener(documentSnapshot -> {
//            if(documentSnapshot.exists())
//            {
//                a = String.valueOf(Math.toIntExact(documentSnapshot.getLong("score")));
//
//
//                txt_score.setText(a);
//
////                Toast.makeText(this, s , Toast.LENGTH_SHORT).show();
//
//            }
//            else
//            {
//                Toast.makeText(Score.this, "Error detecting score", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(Score.this, "Error !!!", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
}