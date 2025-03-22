package com.example.cv_builder;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityResult extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    ImageView ivProfilePictureResult;
    TextView tvFullName, tvEmail, tvPhone, tvArea, tvDob, tvGender, tvCountry, tvCity;
    TextView tvDegreeTitle, tvInstitution, tvMajor, tvGradYear, tvEducationLevel;
    TextView tvCompanyName, tvJobTitle, tvStartDate, tvEndDate, tvResponsibilities, tvTechnologies;
    TextView tvSkills, tvCertifications;
    TextView tvRef1, tvRef2;

    Button downloadCV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getImage();
        getDetails();
        getEducation();
        getExperience();
        getSkills();
        getReferences();


    }

    private void getReferences() {
        tvRef1 = findViewById(R.id.tvRef1);
        tvRef2 = findViewById(R.id.tvRef2);
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        String ref1Name = sharedPreferences.getString("ref1_name", "N/A");
        String ref1Job = sharedPreferences.getString("ref1_job", "N/A");
        String ref1Company = sharedPreferences.getString("ref1_company", "N/A");
        String ref1Email = sharedPreferences.getString("ref1_email", "N/A");
        String ref1Phone = sharedPreferences.getString("ref1_phone", "N/A");

        String ref2Name = sharedPreferences.getString("ref2_name", "N/A");
        String ref2Job = sharedPreferences.getString("ref2_job", "N/A");
        String ref2Company = sharedPreferences.getString("ref2_company", "N/A");
        String ref2Email = sharedPreferences.getString("ref2_email", "N/A");
        String ref2Phone = sharedPreferences.getString("ref2_phone", "N/A");

        tvRef1.setText("Reference 1:\n" + ref1Name + " - " + ref1Job + " at " + ref1Company + "\nEmail: " + ref1Email + "\nPhone: " + ref1Phone);
        tvRef2.setText("Reference 2:\n" + ref2Name + " - " + ref2Job + " at " + ref2Company + "\nEmail: " + ref2Email + "\nPhone: " + ref2Phone);
    }

    private void getSkills() {
        tvSkills = findViewById(R.id.tvSkills);
        tvCertifications = findViewById(R.id.tvCertifications);

        sharedPreferences = getSharedPreferences("SkillsData", MODE_PRIVATE);

        String skills = sharedPreferences.getString("skills", "No skills selected");
        String certifications = sharedPreferences.getString("certifications", "No certifications added");

        tvSkills.setText("Skills: " + skills.replace(",", ", "));
        tvCertifications.setText("Certifications: " + certifications.replace(",", ", "));
    }

    private void getExperience() {
        tvCompanyName = findViewById(R.id.tvCompanyName);
        tvJobTitle = findViewById(R.id.tvJobTitle);
        tvStartDate = findViewById(R.id.tvStartDate);
        tvEndDate = findViewById(R.id.tvEndDate);
        tvResponsibilities = findViewById(R.id.tvResponsibilities);
        tvTechnologies = findViewById(R.id.tvTechnologies);

        sharedPreferences = getSharedPreferences("ExperienceData", MODE_PRIVATE);

        String companyName = sharedPreferences.getString("companyName", "N/A");
        String jobTitle = sharedPreferences.getString("jobTitle", "N/A");
        String startDate = sharedPreferences.getString("startDate", "N/A");
        String endDate = sharedPreferences.getString("endDate", "N/A");
        String responsibilities = sharedPreferences.getString("responsibilities", "N/A");
        String technologies = sharedPreferences.getString("technologies", "N/A");

        tvCompanyName.setText("Company: " + companyName);
        tvJobTitle.setText("Job Title: " + jobTitle);
        tvStartDate.setText("Start Date: " + startDate);
        tvEndDate.setText("End Date: " + endDate);
        tvResponsibilities.setText("Responsibilities: " + responsibilities);
        tvTechnologies.setText("Technologies: " + technologies.replace(",", ", "));

    }

    private void getEducation() {
        tvDegreeTitle = findViewById(R.id.tvDegreeTitle);
        tvInstitution = findViewById(R.id.tvInstitution);
        tvMajor = findViewById(R.id.tvMajor);
        tvGradYear = findViewById(R.id.tvGradYear);
        tvEducationLevel = findViewById(R.id.tvEducationLevel);

        SharedPreferences sharedPreferences = getSharedPreferences("EducationData", MODE_PRIVATE);

        String degreeTitle = sharedPreferences.getString("degreeTitle", "N/A");
        String institution = sharedPreferences.getString("institution", "N/A");
        String major = sharedPreferences.getString("major", "N/A");
        String gradYear = sharedPreferences.getString("gradYear", "N/A");
        String educationLevel = sharedPreferences.getString("educationLevel", "N/A");

        // Display retrieved data
        tvDegreeTitle.setText("Degree Title: " + degreeTitle);
        tvInstitution.setText("Institution: " + institution);
        tvMajor.setText("Major: " + major);
        tvGradYear.setText("Graduation Year: " + gradYear);
        tvEducationLevel.setText("Education Level: " + educationLevel);

    }

    private void getDetails() {
        tvFullName = findViewById(R.id.tvFullName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvArea = findViewById(R.id.tvArea);
        tvDob = findViewById(R.id.tvDob);
        tvGender = findViewById(R.id.tvGender);
        tvCountry = findViewById(R.id.tvCountry);
        tvCity = findViewById(R.id.tvCity);

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        String fullName = sharedPreferences.getString("fullName", "N/A");
        String email = sharedPreferences.getString("email", "N/A");
        String phone = sharedPreferences.getString("phone", "N/A");
        String area = sharedPreferences.getString("area", "N/A");
        String dob = sharedPreferences.getString("dob", "N/A");
        String gender = sharedPreferences.getString("gender", "N/A");
        String country = sharedPreferences.getString("country", "N/A");
        String city = sharedPreferences.getString("city", "N/A");

        // Set retrieved data to TextViews
        tvFullName.setText("Full Name: " + fullName);
        tvEmail.setText("Email: " + email);
        tvPhone.setText("Phone: " + phone);
        tvArea.setText("Area: " + area);
        tvDob.setText("Date of Birth: " + dob);
        tvGender.setText("Gender: " + gender);
        tvCountry.setText("Country: " + country);
        tvCity.setText("City: " + city);
    }

    private void getImage() {

        ivProfilePictureResult = findViewById(R.id.ivProfilePictureResult);

        // Retrieve the image URI from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String imageUriString = sharedPreferences.getString("profileImageUri", null);

        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            ivProfilePictureResult.setImageURI(imageUri);
        } else {
            Toast.makeText(this, "No image received", Toast.LENGTH_SHORT).show();
        }
    }
}