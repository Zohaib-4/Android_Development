package com.example.cv_builder;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityResult extends AppCompatActivity {

    ImageView ivProfilePictureResult;
    TextView tvDegreeTitle, tvInstitution, tvMajor, tvGradYear, tvEducationLevel;

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
    }

    private void getSkills() {
    }

    private void getExperience() {
//
    }

    private void getEducation() {
//        tvDegreeTitle = findViewById(R.id.tvDegreeTitle);
//        tvInstitution = findViewById(R.id.tvInstitution);
//        tvMajor = findViewById(R.id.tvMajor);
//        tvGradYear = findViewById(R.id.tvGradYear);
//        tvEducationLevel = findViewById(R.id.tvEducationLevel);
//
//        SharedPreferences sharedPreferences = getSharedPreferences("EducationData", MODE_PRIVATE);
//
//        String degreeTitle = sharedPreferences.getString("degreeTitle", "N/A");
//        String institution = sharedPreferences.getString("institution", "N/A");
//        String major = sharedPreferences.getString("major", "N/A");
//        String gradYear = sharedPreferences.getString("gradYear", "N/A");
//        String educationLevel = sharedPreferences.getString("educationLevel", "N/A");
//
//        // Display retrieved data
//        tvDegreeTitle.setText("Degree Title: " + degreeTitle);
//        tvInstitution.setText("Institution: " + institution);
//        tvMajor.setText("Major: " + major);
//        tvGradYear.setText("Graduation Year: " + gradYear);
//        tvEducationLevel.setText("Education Level: " + educationLevel);
//
        }

    private void getDetails() {
//        tvDetails = findViewById(R.id.tvDetails);
//        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
//
//        String fullName = sharedPreferences.getString("fullName", "N/A");
//        String email = sharedPreferences.getString("email", "N/A");
//        String phone = sharedPreferences.getString("phone", "N/A");
//        String area = sharedPreferences.getString("area", "N/A");
//        String dob = sharedPreferences.getString("dob", "N/A");
//        String gender = sharedPreferences.getString("gender", "N/A");
//        String country = sharedPreferences.getString("country", "N/A");
//        String city = sharedPreferences.getString("city", "N/A");
//
//        // Display received data
//        String resultText = "Name: " + fullName + "\n" +
//                "Email: " + email + "\n" +
//                "Phone: " + phone + "\n" +
//                "Address: " + area + "\n" +
//                "Gender: " + gender + "\n" +
//                "Country: " + country + "\n" +
//                "City: " + city + "\n" +
//                "DOB: " + dob;
//
//        tvDetails.setText(resultText);
    }

    private void getImage() {

//        ivProfilePictureResult = findViewById(R.id.ivProfilePictureResult);
//
//        // Retrieve the image URI from SharedPreferences
//        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
//        String imageUriString = sharedPreferences.getString("profileImageUri", null);
//
//        if (imageUriString != null) {
//            Uri imageUri = Uri.parse(imageUriString);
//            ivProfilePictureResult.setImageURI(imageUri);
//        } else {
//            Toast.makeText(this, "No image received", Toast.LENGTH_SHORT).show();
//        }
      }
}