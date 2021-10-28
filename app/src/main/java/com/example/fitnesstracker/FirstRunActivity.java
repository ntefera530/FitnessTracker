package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;

public class FirstRunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_run);

        Button confirm_button = findViewById(R.id.confirm_button);

        String name = "Nathan Tefera";
        String birthday = "April 18 1996";
        int weight = 155;
        int age = 25;


        confirm_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent data = new Intent(FirstRunActivity.this, MainActivity.class);

                data.putExtra("name",name);
                data.putExtra("age",age);
                data.putExtra("weight",weight);
                data.putExtra("birthday",birthday);



                SharedPreferences preferences = getSharedPreferences("PREFERENCE", 0);
                SharedPreferences.Editor myEdit = preferences.edit();

                myEdit.putBoolean("first_run",false);
                myEdit.commit();

                setResult(RESULT_OK, data);
                finish();

            }
        });

    }




}