package com.example.cv_builder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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

    LinearLayout skillsContainer, certificationsContainer;
    Button btnAddSkill, btnAddCertification, btnSaveSkills;
    ArrayList<String> certifications = new ArrayList<>();
    ArrayList<String> skills = new ArrayList<>();
    SharedPreferences sharedPreferences;

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

        skillsContainer = findViewById(R.id.skillsContainer);
        certificationsContainer = findViewById(R.id.certificationsContainer);
        btnAddSkill = findViewById(R.id.btnAddSkill);
        btnAddCertification = findViewById(R.id.btnAddCertification);
        btnSaveSkills = findViewById(R.id.btnSaveSkills);
        sharedPreferences = getSharedPreferences("SkillsData", MODE_PRIVATE);

        btnAddSkill.setOnClickListener(v -> addNewSkillField());
        btnAddCertification.setOnClickListener(v -> addNewCertificationField());
        btnSaveSkills.setOnClickListener(v -> saveSkillsAndCertifications());
    }

    private void addNewSkillField() {
        EditText skillInput = new EditText(this);
        skillInput.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        skillInput.setHint("Enter Skill");
        skillInput.setTextColor(Color.WHITE);
        skillsContainer.addView(skillInput);
    }

    private void addNewCertificationField() {
        EditText certificationInput = new EditText(this);
        certificationInput.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        certificationInput.setHint("Enter Certification");
        certificationInput.setTextColor(Color.WHITE);
        certificationsContainer.addView(certificationInput);
    }

    private void saveSkillsAndCertifications() {
        skills.clear();
        certifications.clear();

        // Retrieve all entered skills
        for (int i = 0; i < skillsContainer.getChildCount(); i++) {
            View view = skillsContainer.getChildAt(i);
            if (view instanceof EditText) {
                String skill = ((EditText) view).getText().toString().trim();
                if (!skill.isEmpty()) {
                    skills.add(skill);
                }
            }
        }

        // Retrieve all entered certifications
        for (int i = 0; i < certificationsContainer.getChildCount(); i++) {
            View view = certificationsContainer.getChildAt(i);
            if (view instanceof EditText) {
                String certification = ((EditText) view).getText().toString().trim();
                if (!certification.isEmpty()) {
                    certifications.add(certification);
                }
            }
        }

        if (skills.isEmpty()) {
            Toast.makeText(this, "Enter at least one skill", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("skills", TextUtils.join(",", skills));
        editor.putString("certifications", TextUtils.join(",", certifications));
        editor.apply();

        Toast.makeText(this, "Skills and Certifications saved", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ActivitySkills.this, ActivityHome.class);
        startActivity(intent);
        finish();
    }
}
