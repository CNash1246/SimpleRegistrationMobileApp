package com.example.assignment03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class maritalStatus extends AppCompatActivity {

    RadioGroup radioGroup;
    String maritalStatus;

    final static public String MS_KEY = "MS_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marital_status);

        radioGroup = findViewById(R.id.radioGroupMS);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonNM){
                    maritalStatus = "Not Married";
                } else if(checkedId == R.id.radioButtonM){
                    maritalStatus = "Married";
                } else if(checkedId == R.id.radioButtonPer){
                    maritalStatus = "Prefer not to say";
                }
            }
        });

        findViewById(R.id.buttonCancelMS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.buttonSubmitMS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra(MS_KEY, maritalStatus);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}