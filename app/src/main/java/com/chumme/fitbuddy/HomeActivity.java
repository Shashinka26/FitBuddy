package com.chumme.fitbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    private Button bmibtn, profileBtn; // Declare profile button
    private EditText edtHeight, edtWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); // Ensure this matches your XML layout

        edtHeight = findViewById(R.id.editHeight);  // Height EditText
        edtWeight = findViewById(R.id.editWeight);  // Weight EditText
        bmibtn = findViewById(R.id.btnCalculate);   // Calculate BMI button
        profileBtn = findViewById(R.id.button2);    // Profile button

        // Set OnClickListener for Profile button
        profileBtn.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        bmibtn.setOnClickListener(view -> {
            String heightStr = edtHeight.getText().toString();
            String weightStr = edtWeight.getText().toString();

            if (heightStr.isEmpty() || weightStr.isEmpty()) {
                Toast.makeText(HomeActivity.this, "Please enter both height and weight", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double heightCm = Double.parseDouble(heightStr);
                double weightKg = Double.parseDouble(weightStr);
                double heightM = heightCm / 100;

                if (heightM <= 0 || weightKg <= 0) {
                    Toast.makeText(HomeActivity.this, "Height and weight must be positive values", Toast.LENGTH_SHORT).show();
                    return;
                }

                double bmi = weightKg / (heightM * heightM);
                String bmiResult = getBmiResult(bmi);

                // Save BMI to Firebase Firestore
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                HashMap<String, Object> bmiData = new HashMap<>();
                bmiData.put("bmi", bmi);
                bmiData.put("result", bmiResult);
                bmiData.put("height", heightCm);
                bmiData.put("weight", weightKg);
                bmiData.put("timestamp", new Date());

                db.collection("users").document(userId)
                        .collection("bmi_records")
                        .add(bmiData)
                        .addOnSuccessListener(documentReference ->
                                Toast.makeText(HomeActivity.this, "BMI saved successfully!", Toast.LENGTH_SHORT).show())
                        .addOnFailureListener(e ->
                                Toast.makeText(HomeActivity.this, "Failed to save BMI: " + e.getMessage(), Toast.LENGTH_SHORT).show());

                // Navigate to Result Screen
                Intent intent = new Intent(HomeActivity.this, BmiResultActivity.class);
                intent.putExtra("BMI_VALUE", bmi);
                intent.putExtra("RESULT", bmiResult);
                startActivity(intent);

            } catch (NumberFormatException e) {
                Toast.makeText(HomeActivity.this, "Please enter valid numeric values for height and weight", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getBmiResult(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Healthy Weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
