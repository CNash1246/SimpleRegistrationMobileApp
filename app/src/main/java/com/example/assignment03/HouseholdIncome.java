package com.example.assignment03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class HouseholdIncome extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    String income = "$50k to <$100K";
    final static public String INCOME_KEY = "INCOME_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_household_income);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textViewSeekIncome);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress == 0){
                    textView.setText("<$25K");
                    income = "<$25K";
                } else if(progress == 1){
                    textView.setText("$25K to <$50K");
                    income = "$25K to <$50K";
                } else if(progress == 2){
                    textView.setText("$50K to <$100K");
                    income = "$50K to <$100K";
                } else if(progress == 3){
                    textView.setText("$100K to<$200K");
                    income = "$100K to<$200K";
                } else if(progress == 4){
                    textView.setText(">$200K");
                    income = ">$200K";
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.buttonISubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(INCOME_KEY, income);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.buttonICancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}