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

    ImageView ivReceivedImage;
    TextView tvResult;


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


      }

    private void getData() {
//        tvResult = findViewById(R.id.tvResult);
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
//        tvResult.setText(resultText);
    }

    private void getImage() {

//        ivReceivedImage = findViewById(R.id.ivReceivedImage);

//
//        // Get the image URI from intent
//        String imageUriString = getIntent().getStringExtra("imageUri");
//        if (imageUriString != null) {
//            Uri imageUri = Uri.parse(imageUriString);
//            ivReceivedImage.setImageURI(imageUri);
//        } else {
//            Toast.makeText(this, "No image received", Toast.LENGTH_SHORT).show();
//        }
      }
}