package com.example.cv_builder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class ActivityRef extends AppCompatActivity {


    EditText etRefName, etRefJobTitle, etRefCompany, etRefEmail, etRefPhone;
    Button btnSaveReferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ref);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etRefName = findViewById(R.id.etRefName);
        etRefJobTitle = findViewById(R.id.etRefJobTitle);
        etRefCompany = findViewById(R.id.etRefCompany);
        etRefEmail = findViewById(R.id.etRefEmail);
        etRefPhone = findViewById(R.id.etRefPhone);

        btnSaveReferences = findViewById(R.id.btnSaveReferences);

        btnSaveReferences.setOnClickListener(v -> saveReferences());
    }

    private void saveReferences() {
        // Get user input values and save to SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("ref_name", etRefName.getText().toString().trim());
        editor.putString("ref_job", etRefJobTitle.getText().toString().trim());
        editor.putString("ref_company", etRefCompany.getText().toString().trim());
        editor.putString("ref_email", etRefEmail.getText().toString().trim());
        editor.putString("ref_phone", etRefPhone.getText().toString().trim());

        editor.apply();

        Toast.makeText(ActivityRef.this, "Reference saved", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ActivityRef.this, ActivityHome.class);
        startActivity(intent);
        finish();
    }
}
