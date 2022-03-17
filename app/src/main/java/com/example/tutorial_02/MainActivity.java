package com.example.tutorial_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //create references ,give id names
    EditText Input;
    RadioButton radioButton5;
    RadioButton radio_fahr;
    Button CALCULATE;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assigned value for references
        Input = findViewById(R.id.Input);
        radioButton5 = findViewById(R.id.radioButton5);
        radio_fahr = findViewById(R.id.radio_fahr);
        CALCULATE = findViewById(R.id.CALCULATE);
        textView = findViewById(R.id.textView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CALCULATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateanswer();
            }
        });
    }

    public void calculateanswer() {
        Calculations cal = new Calculations();
        String value = Input.getText().toString();

        if (TextUtils.isEmpty(value)) {
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_SHORT).show();
        } else {
            Float Input = Float.parseFloat(value);
            if (radioButton5.isChecked()) {
                Input = cal.convertCelciusToFahrenheit(Input);
            } else if (radio_fahr.isChecked()) {
                Input = cal.convertFahrenheitToCelcius(Input);
            } else {
                Toast.makeText(this, "select the radio button", Toast.LENGTH_SHORT).show();
                Input = 0.0f;
            }

            // show this answer in text view
            textView.setText(new Float(Input).toString());
        }
    }
}




