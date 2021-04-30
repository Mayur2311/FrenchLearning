package com.example.learnfrench.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.learnfrench.R;

public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;
    Button basic, intermediate, advance;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        basic=root.findViewById(R.id.basic);
        intermediate=root.findViewById(R.id.intermediate);
        advance=root.findViewById(R.id.advance);
        TextView basicText=root.findViewById(R.id.basicText);
        TextView textintermediate=root.findViewById(R.id.textintermediate);
        TextView textadvance=root.findViewById(R.id.textadvance);

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_Basic_level);
            }
        });

        basicText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_Basic_level);
                //
                // Intent i=new Intent(getActivity(), MainActivity2.class);
                // startActivity(i);
                //Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();

            }});
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_intermediate_level);
            }
        });

        textintermediate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_intermediate_level);
                //
                // Intent i=new Intent(getActivity(), MainActivity2.class);
                // startActivity(i);
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();

            }});
        advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_advance_level);
            }
        });
        textadvance.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_advance_level);
                //
                // Intent i=new Intent(getActivity(), MainActivity2.class);
                // startActivity(i);
                //  Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();

            }});



        return root;
    }
}