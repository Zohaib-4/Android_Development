package com.example.cv_builder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityDP extends AppCompatActivity {

    ImageView ivProfilePicture;
    Button btnSubmitImage;
    FloatingActionButton setProfilePic;
    ActivityResultLauncher<Intent> getImageLauncher;
    Uri selectedImageUri; // Store the selected image URI

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        setProfilePic.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            getImageLauncher.launch(i);
        });

        btnSubmitImage.setOnClickListener(v -> {
            if (selectedImageUri != null) {
                // Save the selected image URI in SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("profileImageUri", selectedImageUri.toString());
                editor.apply();

                Toast.makeText(this, "Image saved successfully", Toast.LENGTH_SHORT).show();

                // Start ActivityHome instead of ActivityResult
                Intent intent = new Intent(ActivityDP.this, ActivityHome.class);
                startActivity(intent);
                finish(); // Close this activity
            } else {
                Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        ivProfilePicture = findViewById(R.id.ivProfilePicture);
        btnSubmitImage = findViewById(R.id.btnSubmitImage);
        setProfilePic = findViewById(R.id.setProfilePic);

        getImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        selectedImageUri = result.getData().getData();
                        ivProfilePicture.setImageURI(selectedImageUri);
                    } else {
                        Toast.makeText(this, "Select the image", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
