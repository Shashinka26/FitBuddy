package com.chumme.fitbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BmiResultActivity extends AppCompatActivity {

    private TextView tvBmiValue, tvResult, tvPlanContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);  // Ensure this matches your XML layout

        // Initializing UI components
        tvBmiValue = findViewById(R.id.tvBmiValue);
        tvResult = findViewById(R.id.tvResult);
        tvPlanContent = findViewById(R.id.tvPlanContent);

        // Getting data from the Intent
        Intent intent = getIntent();
        if (intent != null) {
            double bmi = intent.getDoubleExtra("BMI_VALUE", 0.0);
            String result = intent.getStringExtra("RESULT");

            // Check if the result is valid
            if (result == null || result.isEmpty()) {
                result = "Unknown";  // Default value if result is not passed
            }

            // Display BMI value
            tvBmiValue.setText(String.format("%.2f", bmi));
            tvResult.setText(result);

            // Set diet and workout plan based on BMI
            tvPlanContent.setText(getWorkoutPlan(bmi));
        }
    }

    // Method to determine BMI result category and give a workout plan
    private String getWorkoutPlan(double bmi) {
        if (bmi < 18.5) {
            return "Underweight:\n- High-calorie foods\n- Strength training\n- Protein-rich diet";
        } else if (bmi < 24.9) {
            return "Healthy Weight:\n- Balanced diet\n- Regular exercise\n- Stay active";
        } else if (bmi < 29.9) {
            return "Overweight:\n- Calorie deficit diet\n- Cardio + Strength training\n- Reduce sugar intake";
        } else {
            return "Obese:\n- Structured diet plan\n- Daily cardio exercises\n- Consult a healthcare provider";
        }
    }
}
