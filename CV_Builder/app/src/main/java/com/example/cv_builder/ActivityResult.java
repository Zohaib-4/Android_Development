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
    ImageView ivProfilePicture;
    TextView tvFullName, tvEmail, tvPhone, tvArea, tvDob, tvGender, tvCountry, tvCity;
    TextView tvRefName, tvRefJob, tvRefCompany, tvRefEmail, tvRefPhone;
    TextView tvSkills, tvCertifications;
    TextView tvCompanyName, tvJobTitle, tvStartDate, tvEndDate;
    TextView tvDegreeTitle, tvInstitution, tvMajor, tvGradYear;

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

        setImage();
        setInfo();
        setSummary();
        setEducation();
        setExperience();
        setSkills();
        setReferences();

        initializer();

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String imageUriString = sharedPreferences.getString("profileImageUri", null);

        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            ivProfilePicture.setImageURI(imageUri);
        } else {
            Toast.makeText(this, "No profile image found", Toast.LENGTH_SHORT).show();
        }


    }

    private void initializer() {
        ivProfilePicture = findViewById(R.id.ivProfilePictureResult);


    }

    private void setReferences() {
        tvRefName = findViewById(R.id.tvRefName);
        tvRefJob = findViewById(R.id.tvRefJob);
        tvRefCompany = findViewById(R.id.tvRefCompany);
        tvRefEmail = findViewById(R.id.tvRefEmail);
        tvRefPhone = findViewById(R.id.tvRefPhone);

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        String refName = sharedPreferences.getString("refName", "N/A");
        String refJob = sharedPreferences.getString("refJob", "N/A");
        String refCompany = sharedPreferences.getString("refCompany", "N/A");
        String refEmail = sharedPreferences.getString("refEmail", "N/A");
        String refPhone = sharedPreferences.getString("refPhone", "N/A");

        tvRefName.setText(refName);
        tvRefJob.setText(refJob);
        tvRefCompany.setText(refCompany);
        tvRefEmail.setText(refEmail);
        tvRefPhone.setText(refPhone);
    }

    private void setSkills() {
        tvSkills = findViewById(R.id.tvSkills);
        tvCertifications = findViewById(R.id.tvCertifications);

        sharedPreferences = getSharedPreferences("SkillsData", MODE_PRIVATE);

        String skills = sharedPreferences.getString("skills", "No skills selected");
        String certifications = sharedPreferences.getString("certifications", "No certifications added");

        tvSkills.setText("Skills: " + skills.replace(",", ", "));
        tvCertifications.setText("Certifications: " + certifications.replace(",", ", "));
    }

    private void setExperience() {
        tvCompanyName = findViewById(R.id.tvCompanyName);
        tvJobTitle = findViewById(R.id.tvJobTitle);
        tvStartDate = findViewById(R.id.tvStartDate);
        tvEndDate = findViewById(R.id.tvEndDate);

        sharedPreferences = getSharedPreferences("ExperienceData", MODE_PRIVATE);

        String companyName = sharedPreferences.getString("companyName", "N/A");
        String jobTitle = sharedPreferences.getString("jobTitle", "N/A");
        String startDate = sharedPreferences.getString("startDate", "N/A");
        String endDate = sharedPreferences.getString("endDate", "N/A");

        tvCompanyName.setText("Company: " + companyName);
        tvJobTitle.setText("Job Title: " + jobTitle);
        tvStartDate.setText("Start Date: " + startDate);
        tvEndDate.setText("End Date: " + endDate);
    }

    private void setEducation() {
        tvDegreeTitle = findViewById(R.id.tvDegreeTitle);
        tvInstitution = findViewById(R.id.tvInstitution);
        tvMajor = findViewById(R.id.tvMajor);
        tvGradYear = findViewById(R.id.tvGradYear);

        sharedPreferences = getSharedPreferences("EducationData", MODE_PRIVATE);

        String degreeTitle = sharedPreferences.getString("degreeTitle", "N/A");
        String institution = sharedPreferences.getString("institution", "N/A");
        String major = sharedPreferences.getString("major", "N/A");
        String gradYear = sharedPreferences.getString("gradYear", "N/A");

        tvDegreeTitle.setText("Degree Title: " + degreeTitle);
        tvInstitution.setText("Institution: " + institution);
        tvMajor.setText("Major: " + major);
        tvGradYear.setText("Graduation Year: " + gradYear);
    }

    private void setSummary() {
        tvArea = findViewById(R.id.tvArea);
        tvDob = findViewById(R.id.tvDob);
        tvGender = findViewById(R.id.tvGender);
        tvCountry = findViewById(R.id.tvCountry);
        tvCity = findViewById(R.id.tvCity);

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        String area = sharedPreferences.getString("area", "N/A");
        String dob = sharedPreferences.getString("dob", "N/A");
        String gender = sharedPreferences.getString("gender", "N/A");
        String country = sharedPreferences.getString("country", "N/A");
        String city = sharedPreferences.getString("city", "N/A");

        tvArea.setText("Area: " + area);
        tvDob.setText("Date of Birth: " + dob);
        tvGender.setText("Gender: " + gender);
        tvCountry.setText("Country: " + country);
        tvCity.setText("City: " + city);
    }

    private void setInfo() {


        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String fullName = sharedPreferences.getString("fullName", "N/A");
        String email = sharedPreferences.getString("email", "N/A");
        String phone = sharedPreferences.getString("phone", "N/A");

        tvFullName.setText(fullName);
        tvEmail.setText(email);
        tvPhone.setText(phone);
    }
}
