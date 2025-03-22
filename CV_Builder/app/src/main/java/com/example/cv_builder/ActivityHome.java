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

        Button btnProfilePic, btnPersonalDetails, btnEducation, btnExperience, btnSkills, btnReferences, btnSubmit;

        btnProfilePic = findViewById(R.id.btnProfilePic);
        btnPersonalDetails = findViewById(R.id.btnPersonalDetails);
        btnEducation = findViewById(R.id.btnEducation);
        btnExperience = findViewById(R.id.btnExperience);
        btnSkills = findViewById(R.id.btnSkills);
        btnReferences = findViewById(R.id.btnReferences);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnProfilePic.setOnClickListener(view -> {
            Intent i1 = new Intent(ActivityHome.this, ActivityDP.class);
            startActivity(i1);

        });

        btnPersonalDetails.setOnClickListener(view -> {
            Intent i2 = new Intent(ActivityHome.this, ActivityDetails.class);
            startActivity(i2);
            // Handle button click
        });

        btnEducation.setOnClickListener(view -> {
            Intent i3 = new Intent(ActivityHome.this, ActivityEducation.class);
            startActivity(i3);
        });

        btnExperience.setOnClickListener(view -> {
            Intent i4 = new Intent(ActivityHome.this, ActivityExper.class);
            startActivity(i4);
        });

        btnSkills.setOnClickListener(view -> {
            Intent i5 = new Intent(ActivityHome.this, ActivitySkills.class);
            startActivity(i5);
        });

        btnReferences.setOnClickListener(view -> {
            Intent i6 = new Intent(ActivityHome.this, ActivityRef.class);
            startActivity(i6);
        });

        btnSubmit.setOnClickListener(view -> {
            Intent i7 = new Intent(ActivityHome.this, ActivityResult.class);
            startActivity(i7);
            finish();
        });





    }
}