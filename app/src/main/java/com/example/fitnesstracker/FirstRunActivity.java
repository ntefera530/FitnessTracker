package com.example.fitnesstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FirstRunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_run);

        Button confirm_button = findViewById(R.id.confirm_button);

        //DEFULT VALUES
        //String name = "Nathan Tefera";
        //String birthday = "04/18/1996";
        //int weight = 155;
        //int age = 25;

        //lose = 0, strength = 2, gain = 3;
        //int goal = 3;

        boolean valid = false;

        EditText name_text = findViewById(R.id.name_text);
        EditText birthday_text = findViewById(R.id.birthday_text);
        EditText weight_text = findViewById(R.id.weight_text);

        RadioGroup goal_group = findViewById(R.id.goal);
        RadioGroup gender_group = findViewById(R.id.gender);

        confirm_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Only swap activites if all data is valid

                Intent data = new Intent(FirstRunActivity.this, MainActivity.class);

                String name = name_text.getText().toString();

                String[] birthday = birthday_text.getText().toString().split("/");
                int birth_month = Integer.parseInt(birthday[0]);
                int birth_day = Integer.parseInt(birthday[1]);
                int birth_year = Integer.parseInt(birthday[2]);

                // TODO calutate timers
                int age = 25;

                int gender =1;
                int goal=1;

                String weight = weight_text.getText().toString();


                //Checks which goals radio button is selected
                if (gender_group.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // get selected radio button from radioGroup
                    int selectedId = gender_group.getCheckedRadioButtonId();

                    switch(selectedId){

                        case R.id.male:
                            gender = 1;
                            break;

                        case R.id.female:
                            gender = 2;
                            break;
                    }

                    // find the radiobutton by returned id
                    //RadioButton selectedRadioButton = (RadioButton)findViewById(selectedId);
                    //Toast.makeText(getApplicationContext(), selectedRadioButton.getText().toString()+" is selected", Toast.LENGTH_SHORT).show();


                }


                //Checks which goals radio button is selected
                if (goal_group.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getApplicationContext(), "Please select Goal", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // get selected radio button from radioGroup
                    int selectedId = goal_group.getCheckedRadioButtonId();
                    switch(selectedId){

                        case R.id.lose:
                            goal = 1;
                            break;

                        case R.id.strenght:
                            goal = 2;
                            break;

                        case R.id.gain:
                            goal = 3;
                            break;

                    }
                    // find the radiobutton by returned id
                    //RadioButton selectedRadioButton = (RadioButton)findViewById(selectedId);
                    //Toast.makeText(getApplicationContext(), selectedRadioButton.getText().toString()+" is selected", Toast.LENGTH_SHORT).show();


                }

                data.putExtra("name",name);
                data.putExtra("age",age);
                data.putExtra("weight",weight);
                data.putExtra("birthday",birthday);
                data.putExtra("gender",gender);
                data.putExtra("goal",goal);





                //SETS first result shared preferences so this activity doesnt run again after the first time
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