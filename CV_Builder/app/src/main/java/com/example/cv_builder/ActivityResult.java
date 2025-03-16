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
    TextView tvDetails;
    TextView tvEducation;


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
        getData();
        getEducation();



      }

    private void getEducation() {
//        tvEducation = findViewById(R.id.tvEducation);
//
//        String degreeTitle = getIntent().getStringExtra("degreeTitle");
//        String institution = getIntent().getStringExtra("institution");
//        String major = getIntent().getStringExtra("major");
//        String gradYear = getIntent().getStringExtra("gradYear");
//        String educationLevel = getIntent().getStringExtra("educationLevel");
//
//        // Display received data
//        String resultText = "Degree: " + degreeTitle + "\nInstitution: " + institution +
//                "\nMajor: " + major + "\nGraduation Year: " + gradYear + "\nLevel: " + educationLevel;
//        tvEducation.setText(resultText);
        }

    private void getData() {
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