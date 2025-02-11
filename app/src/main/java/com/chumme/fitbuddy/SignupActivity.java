package com.chumme.fitbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup); // Ensure this matches your XML file

        // Find the "Sign In" TextView and "Sign Up" Button by their IDs
        TextView signInButton = findViewById(R.id.tvSignIn); // "Sign In" TextView
        Button signUpButton = findViewById(R.id.btnSignUp); // "Sign Up" Button

        // Set click listener for Sign Up button to navigate to LoginActivity
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // After user signs up (you can add actual signup logic here),
                // you can go to HomeActivity or any relevant activity
                Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();  // Close SignupActivity once sign up is complete
            }
        });

        // Set click listener to navigate to LoginActivity when the "Sign In" link is clicked
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
