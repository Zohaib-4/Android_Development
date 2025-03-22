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

    EditText etRef1Name, etRef1JobTitle, etRef1Company, etRef1Email, etRef1Phone;
    EditText etRef2Name, etRef2JobTitle, etRef2Company, etRef2Email, etRef2Phone;
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

        // Initialize EditText fields for Reference 1
        etRef1Name = findViewById(R.id.etRef1Name);
        etRef1JobTitle = findViewById(R.id.etRef1JobTitle);
        etRef1Company = findViewById(R.id.etRef1Company);
        etRef1Email = findViewById(R.id.etRef1Email);
        etRef1Phone = findViewById(R.id.etRef1Phone);

        // Initialize EditText fields for Reference 2
        etRef2Name = findViewById(R.id.etRef2Name);
        etRef2JobTitle = findViewById(R.id.etRef2JobTitle);
        etRef2Company = findViewById(R.id.etRef2Company);
        etRef2Email = findViewById(R.id.etRef2Email);
        etRef2Phone = findViewById(R.id.etRef2Phone);

        btnSaveReferences = findViewById(R.id.btnSaveReferences);

        btnSaveReferences.setOnClickListener(v -> saveReferences());
    }

    private void saveReferences() {
        // Get user input values
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("ref1_name", etRef1Name.getText().toString().trim());
        editor.putString("ref1_job", etRef1JobTitle.getText().toString().trim());
        editor.putString("ref1_company", etRef1Company.getText().toString().trim());
        editor.putString("ref1_email", etRef1Email.getText().toString().trim());
        editor.putString("ref1_phone", etRef1Phone.getText().toString().trim());

        editor.putString("ref2_name", etRef2Name.getText().toString().trim());
        editor.putString("ref2_job", etRef2JobTitle.getText().toString().trim());
        editor.putString("ref2_company", etRef2Company.getText().toString().trim());
        editor.putString("ref2_email", etRef2Email.getText().toString().trim());
        editor.putString("ref2_phone", etRef2Phone.getText().toString().trim());

        editor.apply();

        Toast.makeText(ActivityRef.this, "References saved", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ActivityRef.this, ActivityHome.class);
        startActivity(intent);
        finish();
    }
}
