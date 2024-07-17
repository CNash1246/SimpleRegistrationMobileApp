package com.example.assignment03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    Response response;
    TextView profileName, profileEmail, profileRole, profileIncome, profileEducation, profileMS, profileLS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.textViewProfileName);
        profileEmail = findViewById(R.id.textViewProfileEmail);
        profileRole = findViewById(R.id.textViewProfileRole);
        profileEducation = findViewById(R.id.textViewProfileEducation);
        profileLS = findViewById(R.id.textViewProfileLivingStatus);
        profileIncome = findViewById(R.id.textViewProfileIncome);
        profileMS = findViewById(R.id.textViewProfileMaritalStatus);


        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(demographicInfo.userKey)){
            response = (Response) getIntent().getSerializableExtra(demographicInfo.userKey);
        }

        profileName.setText(response.getName());
        profileEmail.setText(response.getEmail());
        profileRole.setText(response.getRole());
        profileEducation.setText(response.getEducation());
        profileLS.setText(response.getLivingStatus());
        profileIncome.setText(response.getIncome());
        profileMS.setText(response.getMaritalStatus());
    }
}