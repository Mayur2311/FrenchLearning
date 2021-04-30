package com.example.learnfrench;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class rating extends Fragment {

    TextView rateCount,showRating;
    EditText review;
    Button submit,home;
    RatingBar ratingBar;
    float rateValue;
    String rateCountString;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    String fuser = firebaseAuth.getCurrentUser().getUid();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_rating, container, false);

        rateCount=root.findViewById(R.id.rateCount);
        ratingBar=root.findViewById(R.id.ratingBar);
        review=root.findViewById(R.id.review);
        submit=root.findViewById(R.id.submitBtn);
        showRating=root.findViewById(R.id.showRating);
        home = root.findViewById(R.id.hmbtn);

        home.setVisibility(View.INVISIBLE);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rateValue=ratingBar.getRating();
                if(rateValue<=1&& rateValue>0)
                    rateCount.setText("Bad" +rateValue+"/5");
                else if(rateValue<=2&&rateValue>1)
                    rateCount.setText("OK"+rateValue+"/5");
                else if(rateValue<=3&&rateValue>2)
                    rateCount.setText("Good"+rateValue+"/5");
                else if(rateValue<=4&&rateValue>3)
                    rateCount.setText("VeryGood"+rateValue+"/5");
                else if(rateValue<=5&&rateValue>4)
                    rateCount.setText("Best"+rateValue+"/5");

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rateCountString = rateCount.getText().toString();
                showRating.setText("YOUR RATING:\n"+rateCountString+"\n"+review.getText());

                String Review = review.getText().toString();
                String RatingBar = rateCount.getText().toString();

                Map<String, Object> rate =  new HashMap<>();

                rate.put("Rating", RatingBar);
                rate.put("Review", Review);

                db.collection("Rating").document(fuser).set(rate)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getContext().getApplicationContext(), "Ratings submitted successfully", Toast.LENGTH_SHORT).show();
                                submit.setVisibility(View.INVISIBLE);
                                home.setVisibility(View.VISIBLE);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext().getApplicationContext(), "Error sending ratings !!!", Toast.LENGTH_SHORT).show();
                    }
                });

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        return root;
    }
}