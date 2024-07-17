package com.example.assignment03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class identificationInfo extends AppCompatActivity {

    EditText editTextName, editTextEmail;
    RadioGroup radioGroup;
    String role = "";

    final public static String userKey = "USER_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification_info);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonStudent){
                    role = "Student";
                }else if(checkedId == R.id.radioButtonEmployee){
                    role = "Employee";
                } else if(checkedId == R.id.radioButtonOther){
                    role = "Other";
                }
            }
        });

        findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(editTextEmail.getText().toString().isEmpty()){
                        Toast.makeText(identificationInfo.this, "Please enter a email", Toast.LENGTH_SHORT).show();
                    } else if(editTextName.getText().toString().isEmpty()){
                        Toast.makeText(identificationInfo.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                    } else if(role.isEmpty()){
                        Toast.makeText(identificationInfo.this, "Please enter a role", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(identificationInfo.this, demographicInfo.class);
                        Response response = new Response(editTextName.getText().toString(), editTextEmail.getText().toString(), role);
                        intent.putExtra(userKey, response);
                        startActivity(intent);
                    }
                } catch(Exception e){
                    Toast.makeText(identificationInfo.this, "Please enter a valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}