package com.example.assignment03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class LivingStatus extends AppCompatActivity {

    final static public String LS_KEY = "LS_KEY";
    String livingStatus;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_status);

        radioGroup = findViewById(R.id.radioGroupLS);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonHO){
                    livingStatus = "HomeOwner";
                } else if (checkedId == R.id.radioButtonR){
                    livingStatus = "Renter";
                } else if (checkedId == R.id.radioButtonL){
                    livingStatus = "Lessee";
                } else if(checkedId == R.id.radioButtonO){
                    livingStatus = "Other";
                } else if (checkedId == R.id.radioButtonPerfer){
                    livingStatus = "Prefer not to say";
                }
            }
        });

        findViewById(R.id.buttonLSCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.buttonLSSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(LS_KEY, livingStatus);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}