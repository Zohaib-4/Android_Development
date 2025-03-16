package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class ActivitySkills extends AppCompatActivity {

    ChipGroup chipGroupSkills;
    EditText etCertification;
    Button btnAddCertification, btnSaveSkills;
    ArrayList<String> certifications = new ArrayList<>();
    ArrayList<String> selectedSkills = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_skills);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        chipGroupSkills = findViewById(R.id.chipGroupSkills);
        etCertification = findViewById(R.id.etCertification);
        btnAddCertification = findViewById(R.id.btnAddCertification);
        btnSaveSkills = findViewById(R.id.btnSaveSkills);

        btnAddCertification.setOnClickListener(v -> {
            String cert = etCertification.getText().toString().trim();
            if (!cert.isEmpty()) {
                certifications.add(cert);
                etCertification.setText(""); // Clear input field
                Toast.makeText(ActivitySkills.this, "Certification Added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ActivitySkills.this, "Enter a valid certification", Toast.LENGTH_SHORT).show();
            }
        });

        btnSaveSkills.setOnClickListener(v -> {
            selectedSkills.clear(); // Clear previous selections

            // Get selected skills from chip group
            for (int i = 0; i < chipGroupSkills.getChildCount(); i++) {
                Chip chip = (Chip) chipGroupSkills.getChildAt(i);
                if (chip.isChecked()) {
                    selectedSkills.add(chip.getText().toString());
                }
            }

            // Ensure at least one skill is selected
            if (selectedSkills.isEmpty()) {
                Toast.makeText(ActivitySkills.this, "Select at least one skill", Toast.LENGTH_SHORT).show();
                return;
            }

            // Prepare data to send to ActivityResult
            Intent resultIntent = new Intent(ActivitySkills.this, ActivityResult.class);
            resultIntent.putStringArrayListExtra("skills", selectedSkills);
            resultIntent.putStringArrayListExtra("certifications", certifications);
            startActivity(resultIntent); // Open ActivityResult

            // Open ActivityHome
            Intent homeIntent = new Intent(ActivitySkills.this, ActivityHome.class);
            startActivity(homeIntent);

            finish(); // Close current activity
        });
    }
}