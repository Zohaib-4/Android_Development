package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        // Initialize Save button
        btnSaveReferences = findViewById(R.id.btnSaveReferences);

        btnSaveReferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveReferences();
            }
        });
    }

    private void saveReferences() {
        // Get user input values
        String ref1Name = etRef1Name.getText().toString().trim();
        String ref1JobTitle = etRef1JobTitle.getText().toString().trim();
        String ref1Company = etRef1Company.getText().toString().trim();
        String ref1Email = etRef1Email.getText().toString().trim();
        String ref1Phone = etRef1Phone.getText().toString().trim();

        String ref2Name = etRef2Name.getText().toString().trim();
        String ref2JobTitle = etRef2JobTitle.getText().toString().trim();
        String ref2Company = etRef2Company.getText().toString().trim();
        String ref2Email = etRef2Email.getText().toString().trim();
        String ref2Phone = etRef2Phone.getText().toString().trim();

        // Create intent to send data to ActivityResult
        Intent intent = new Intent(ActivityRef.this, ActivityResult.class);
        intent.putExtra("ref1_name", ref1Name);
        intent.putExtra("ref1_job", ref1JobTitle);
        intent.putExtra("ref1_company", ref1Company);
        intent.putExtra("ref1_email", ref1Email);
        intent.putExtra("ref1_phone", ref1Phone);

        intent.putExtra("ref2_name", ref2Name);
        intent.putExtra("ref2_job", ref2JobTitle);
        intent.putExtra("ref2_company", ref2Company);
        intent.putExtra("ref2_email", ref2Email);
        intent.putExtra("ref2_phone", ref2Phone);

        startActivity(intent);

        // Navigate to ActivityHome
        Intent homeIntent = new Intent(ActivityRef.this, ActivityHome.class);
        startActivity(homeIntent);
        finish(); // Close the current activity
    }
}