package com.example.weight_calculator;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText name, age, weight, height;
    double result = 0;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button bmitest;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.hight);

        radioGroup = findViewById(R.id.group);


    }

    public void BmiCalculate(View view) {


        String nameT = name.getText().toString();
        String ageT = age.getText().toString();
        String weightT = weight.getText().toString();
        String heightT = height.getText().toString();
        if (nameT.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter your Name", Toast.LENGTH_SHORT).show();
        } else if (ageT.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter your Age", Toast.LENGTH_SHORT).show();
        } else if (weightT.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter your Weight", Toast.LENGTH_SHORT).show();
        } else if (heightT.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter your Height", Toast.LENGTH_SHORT).show();
        } else {

            double weight_Value = Double.parseDouble(weight.getText().toString());
            double height_Value = Double.parseDouble(height.getText().toString());
            double meter_convert = 0.3048 * height_Value;
            double meter_sqare = meter_convert * meter_convert;
            int selectRB = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(selectRB);
            String gender = radioButton.getText().toString();
            result = weight_Value / meter_sqare;

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("name", nameT);
            intent.putExtra("age", ageT);
            intent.putExtra("gender", gender);
            intent.putExtra("result", df.format(result) + "");
            startActivity(intent);

        }

    }
}