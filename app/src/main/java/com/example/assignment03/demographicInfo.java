package com.example.assignment03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class demographicInfo extends AppCompatActivity {

    TextView textViewEducation, textViewMS, textViewLS, textViewIncome;
    Response response;
    final static public String userKey = "USER_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demographic_info);

        textViewEducation = findViewById(R.id.textViewEducation);
        textViewMS = findViewById(R.id.textViewMS);
        textViewLS = findViewById(R.id.textViewLS);
        textViewIncome = findViewById(R.id.textViewIncome);

        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(identificationInfo.userKey)){
            response = (Response) getIntent().getSerializableExtra(identificationInfo.userKey);
        }

        ActivityResultLauncher<Intent> startEducationForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result != null && result.getResultCode() == RESULT_OK){
                    if(result.getData() != null && result.getData().getStringExtra(selectEducation.Education_Key) != null){
                        textViewEducation.setText(result.getData().getStringExtra(selectEducation.Education_Key));
                    }
                }
            }
        });

        findViewById(R.id.buttonEducation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(demographicInfo.this, selectEducation.class);
                startEducationForResult.launch(intent);
            }
        });

        ActivityResultLauncher<Intent> startMaritalStatusForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result != null && result.getResultCode() == RESULT_OK){
                    if(result.getData() != null && result.getData().getStringExtra(maritalStatus.MS_KEY) != null){
                        textViewMS.setText(result.getData().getStringExtra(maritalStatus.MS_KEY));
                    }
                }
            }
        });

        findViewById(R.id.buttonMS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(demographicInfo.this, maritalStatus.class);
                startMaritalStatusForResult.launch(intent);
            }
        });

        ActivityResultLauncher<Intent> startLivingStatusForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result != null && result.getResultCode() == RESULT_OK){
                    if(result.getData() != null && result.getData().getStringExtra(LivingStatus.LS_KEY) != null){
                        textViewLS.setText(result.getData().getStringExtra(LivingStatus.LS_KEY));
                    }
                }
            }
        });

        findViewById(R.id.buttonLS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(demographicInfo.this, LivingStatus.class);
                startLivingStatusForResult.launch(intent);
            }
        });

        ActivityResultLauncher<Intent> startIncomeForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result != null && result.getResultCode() == RESULT_OK){
                    if(result.getData() != null && result.getData().getStringExtra(HouseholdIncome.INCOME_KEY) != null){
                        textViewIncome.setText(result.getData().getStringExtra(HouseholdIncome.INCOME_KEY));
                    }
                }
            }
        });

        findViewById(R.id.buttonIncome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(demographicInfo.this, HouseholdIncome.class);
                startIncomeForResult.launch(intent);
            }
        });

        findViewById(R.id.buttonDemoNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.setEducation(textViewEducation.getText().toString());
                response.setIncome(textViewIncome.getText().toString());
                response.setLivingStatus(textViewLS.getText().toString());
                response.setMaritalStatus(textViewMS.getText().toString());

                Intent intent = new Intent(demographicInfo.this, Profile.class);
                intent.putExtra(userKey, response);
                startActivity(intent);
            }
        });
    }
}