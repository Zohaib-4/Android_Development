package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
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
            // Handle Submit Image button click
        });

    }

    private void init() {
        ivProfilePicture = findViewById(R.id.ivProfilePicture);
        btnSubmitImage = findViewById(R.id.btnSubmitImage);
        setProfilePic = findViewById(R.id.setProfilePic);

        getImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                        if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                            {
                                ivProfilePicture.setImageURI(result.getData().getData());
                            }
                        else if(result.getResultCode() == RESULT_CANCELED)
                            {
                                Toast.makeText(this, "Select the image", Toast.LENGTH_SHORT).show();
                            }
                });


    }
}