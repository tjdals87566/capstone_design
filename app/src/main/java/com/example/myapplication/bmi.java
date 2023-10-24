package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmi extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        weightEditText = findViewById(R.id.weight_edittext);
        heightEditText = findViewById(R.id.height_edittext);
        calculateButton = findViewById(R.id.calculate_button);
        resultTextView = findViewById(R.id.result_textview);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }
    private void calculateBMI() {
        String weightString = weightEditText.getText().toString();
        String heightString = heightEditText.getText().toString();

        if (!weightString.isEmpty() && !heightString.isEmpty()) {
            float weight = Float.parseFloat(weightString);
            float height = Float.parseFloat(heightString) / 100; // cm to m

            float bmiValue = weight / (height * height);

            String bmiResult;

            if (bmiValue < 18.5) {
                bmiResult = "Underweight";
            } else if (bmiValue < 25) {
                bmiResult = "Normal Weight";
            } else if (bmiValue < 30) {
                bmiResult = "Overweight";
            } else {
                bmiResult = "Obese";
            }

            resultTextView.setText("BMI: " + String.format("%.2f", bmiValue)
                    + "\nCategory: " + bmiResult);

            // BMI 값을 저장하거나 다른 용도로 활용할 수도 있습니다.
            // 여기서는 결과만 텍스트뷰에 표시합니다.

        }
    }
}