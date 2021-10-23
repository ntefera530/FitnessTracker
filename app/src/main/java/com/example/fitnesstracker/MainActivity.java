package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BUTTONS
        Button home_button = findViewById(R.id.home_button);
        Button nutrition_button = findViewById(R.id.nutrition_button);
        Button photo_button = findViewById(R.id.photo_button);

        //Fragment nutrition_fragment = findViewById(R.id.)

        home_button.setOnClickListener(this);
        nutrition_button.setOnClickListener(this);
        photo_button.setOnClickListener(this);

    }
    public void swap_fragments(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.home_button:
                //home fragment
                swap_fragments(new home());
                break;
            case R.id.photo_button:
                //photos fragment
                swap_fragments(new photos());
                break;
            case R.id.nutrition_button:
                //nutrition fragment
                swap_fragments(new nutrition());
                break;

        }
        System.out.println("PRESSED");
    }
}