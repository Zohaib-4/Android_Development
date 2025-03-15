package com.example.cv_builder;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnProfilePic, btnPersonalDetails, btnSummary, btnEducation, btnExperience, btnSkills, btnReferences;

        btnProfilePic = findViewById(R.id.btnProfilePic);
        btnPersonalDetails = findViewById(R.id.btnPersonalDetails);
        btnSummary = findViewById(R.id.btnSummary);
        btnEducation = findViewById(R.id.btnEducation);
        btnExperience = findViewById(R.id.btnExperience);
        btnSkills = findViewById(R.id.btnSkills);
        btnReferences = findViewById(R.id.btnReferences);

        btnProfilePic.setOnClickListener(view -> {
            // Handle button click
        });

        btnPersonalDetails.setOnClickListener(view -> {
            // Handle button click
        });

        btnSummary.setOnClickListener(view -> {
            // Handle button click
        });

        btnEducation.setOnClickListener(view -> {
            // Handle button click
        });

        btnExperience.setOnClickListener(view -> {
            // Handle button click
        });

        btnSkills.setOnClickListener(view -> {
            // Handle button click
        });

        btnReferences.setOnClickListener(view -> {
            // Handle button click
        });





    }
}