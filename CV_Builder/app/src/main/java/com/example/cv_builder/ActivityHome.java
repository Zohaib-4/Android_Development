package com.example.cv_builder;

import android.content.Intent;
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

        Button btnProfilePic, btnPersonalDetails, btnSummary, btnEducation, btnExperience, btnSkills, btnReferences, btnSubmit;

        btnProfilePic = findViewById(R.id.btnProfilePic);
        btnPersonalDetails = findViewById(R.id.btnPersonalDetails);
        btnSummary = findViewById(R.id.btnSummary);
        btnEducation = findViewById(R.id.btnEducation);
        btnExperience = findViewById(R.id.btnExperience);
        btnSkills = findViewById(R.id.btnSkills);
        btnReferences = findViewById(R.id.btnReferences);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnProfilePic.setOnClickListener(view -> {
            Intent i = new Intent(ActivityHome.this, ActivityDP.class);
            startActivity(i);

        });

        btnPersonalDetails.setOnClickListener(view -> {
            Intent i = new Intent(ActivityHome.this, ActivityDetails.class);
            startActivity(i);
            // Handle button click
        });

        btnSummary.setOnClickListener(view -> {
            Intent i = new Intent(ActivityHome.this, ActivitySummary.class);
            startActivity(i);
        });

        btnEducation.setOnClickListener(view -> {
            Intent i = new Intent(ActivityHome.this, ActivityEducation.class);
            startActivity(i);
        });

        btnExperience.setOnClickListener(view -> {
            Intent i = new Intent(ActivityHome.this, ActivityExper.class);
            startActivity(i);
        });

        btnSkills.setOnClickListener(view -> {
            Intent i = new Intent(ActivityHome.this, ActivitySkills.class);
            startActivity(i);
        });

        btnReferences.setOnClickListener(view -> {
            Intent i = new Intent(ActivityHome.this, ActivityRef.class);
            startActivity(i);
        });

        btnSubmit.setOnClickListener(view -> {
            Intent i = new Intent(ActivityHome.this, ActivityResult.class);
            startActivity(i);
        });





    }
}