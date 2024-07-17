package com.example.assignment03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class selectEducation extends AppCompatActivity {
    RadioGroup radioGroup;
    String education = "";
    final static public String Education_Key = "EDUCATION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_education);

        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonBHS) {
                    education = "Below High School";
                } else if (checkedId == R.id.radioButtonHS) {
                    education = "High School";
                } else if (checkedId == R.id.radioButtonBD) {
                    education = "Bachelor's Degree";
                } else if (checkedId == R.id.radioButtonMD) {
                    education = "Master's Degree";
                } else if (checkedId == R.id.radioButtonPH) {
                    education = "Ph.D. or higher";
                } else if (checkedId == R.id.radioButtonPNTS) {
                    education = "Prefer not to say";
                } else if (checkedId == R.id.radioButtonTS){
                    education = "Trade School";
                }
            }
        });

        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra(Education_Key,education);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}