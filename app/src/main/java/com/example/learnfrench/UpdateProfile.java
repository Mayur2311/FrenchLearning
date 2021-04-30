package com.example.learnfrench;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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


public class UpdateProfile extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    String fuser = firebaseAuth.getCurrentUser().getUid();
    DocumentReference documentReference;

    EditText firstname, lastname, email, mobilenumber;
    Button btn_updateData;

    String fname, lname, mnum;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_update_profile, container, false);

        firstname = root.findViewById(R.id.firstName);
        lastname = root.findViewById(R.id.lastName);
        mobilenumber = root.findViewById(R.id.mobile);
        btn_updateData = root.findViewById(R.id.btn_update);


        documentReference = db.collection("Profile").document(fuser);

        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

                    firstname.setText(value.getString("firstname"));
                    lastname.setText(value.getString("lastname"));
                    mobilenumber.setText(value.getString("mobilenumber"));



            }
        });




        btn_updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fname = firstname.getText().toString();
                lname = lastname.getText().toString();
                mnum = mobilenumber.getText().toString();

                Map<String, Object> profileData = new HashMap<>();

                profileData.put("firstname", fname);
                profileData.put("lastname", lname);
                profileData.put("mobilenumber", mnum);


                db.collection("Profile").document(fuser).set(profileData)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getContext().getApplicationContext(), "Profile data updated", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getContext().getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext().getApplicationContext(), "Error adding data" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });



        return root;
    }
}