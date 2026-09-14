package com.chumme.fitbuddy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtMobile, edtAddress;
    private Button btnSubmit, btnEdit, btnDelete;

    private FirebaseFirestore db;
    private String userId;
    private DocumentReference profileRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile); // XML layout file for Profile

        edtName = findViewById(R.id.et_name);
        edtEmail = findViewById(R.id.et_email);
        edtMobile = findViewById(R.id.et_mobile);
        edtAddress = findViewById(R.id.et_address);
        btnSubmit = findViewById(R.id.btn_submit);
        btnEdit = findViewById(R.id.btn_edit);
        btnDelete = findViewById(R.id.btn_delete);

        db = FirebaseFirestore.getInstance();
        userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        profileRef = db.collection("users").document(userId).collection("profile").document("details");

        // Submit (Save) Profile
        btnSubmit.setOnClickListener(view -> {
            String name = edtName.getText().toString();
            String email = edtEmail.getText().toString();
            String mobile = edtMobile.getText().toString();
            String address = edtAddress.getText().toString();

            if (name.isEmpty() || email.isEmpty() || mobile.isEmpty() || address.isEmpty()) {
                Toast.makeText(ProfileActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            HashMap<String, Object> profileData = new HashMap<>();
            profileData.put("name", name);
            profileData.put("email", email);
            profileData.put("mobile", mobile);
            profileData.put("address", address);

            profileRef.set(profileData)
                    .addOnSuccessListener(aVoid -> Toast.makeText(ProfileActivity.this, "Profile saved!", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e -> Toast.makeText(ProfileActivity.this, "Error saving profile: " + e.getMessage(), Toast.LENGTH_SHORT).show());
        });

        // Edit Profile (load from Firebase)
        btnEdit.setOnClickListener(view -> {
            profileRef.get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            edtName.setText(documentSnapshot.getString("name"));
                            edtEmail.setText(documentSnapshot.getString("email"));
                            edtMobile.setText(documentSnapshot.getString("mobile"));
                            edtAddress.setText(documentSnapshot.getString("address"));
                            Toast.makeText(ProfileActivity.this, "Profile loaded", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ProfileActivity.this, "No profile found", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(e -> Toast.makeText(ProfileActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
        });

        // Delete Profile
        btnDelete.setOnClickListener(view -> {
            profileRef.delete()
                    .addOnSuccessListener(aVoid -> {
                        edtName.setText("");
                        edtEmail.setText("");
                        edtMobile.setText("");
                        edtAddress.setText("");
                        Toast.makeText(ProfileActivity.this, "Profile deleted!", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> Toast.makeText(ProfileActivity.this, "Delete failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
        });
    }
}
