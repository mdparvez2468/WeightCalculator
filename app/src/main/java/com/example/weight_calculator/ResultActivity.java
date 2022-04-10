package com.example.weight_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView=findViewById(R.id.resultTextView);
        String name= getIntent().getStringExtra("name");
        String age= getIntent().getStringExtra("age");
        String gender= getIntent().getStringExtra("gender");
        String result= getIntent().getStringExtra("result");

        textView.setText("Name: "+name+"\nAge: "+age+"\nGender: "+gender+"\nYour BMI: "+result);
    }
}