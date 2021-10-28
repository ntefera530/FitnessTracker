package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String name = "No Name";
    String birthday = "None";
    int weight = 0;
    int age = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        boolean first_open = preferences.getBoolean("first_run",true);
        //preferences.edit().remove("first_run").commit();

        int request_code = 0;


        if (first_open == true) {
            //show start activity
            startActivityForResult(new Intent(MainActivity.this, FirstRunActivity.class), request_code);
            Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG).show();
        }






        //BUTTONS
        Button home_button = findViewById(R.id.home_button);
        Button nutrition_button = findViewById(R.id.nutrition_button);
        Button photo_button = findViewById(R.id.photo_button);

        //Fragment nutrition_fragment = findViewById(R.id.)

        home_button.setOnClickListener(this);
        nutrition_button.setOnClickListener(this);
        photo_button.setOnClickListener(this);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == requestCode) {
            name = data.getStringExtra("name");
            birthday = data.getStringExtra("birthday");
            age = data.getIntExtra("age",25);
            weight = data.getIntExtra("weight",150);
        }
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