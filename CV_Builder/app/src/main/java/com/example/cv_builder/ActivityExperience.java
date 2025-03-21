package com.example.cv_builder;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import java.util.Calendar;
public class ActivityExperience extends AppCompatActivity {

    EditText etCompanyName, etJobTitle, etStartDate, etEndDate;
    Button btnSubmitExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exper);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCompanyName = findViewById(R.id.etCompanyName);
        etJobTitle = findViewById(R.id.etJobTitle);
        etStartDate = findViewById(R.id.etStartDate);
        etEndDate = findViewById(R.id.etEndDate);
        btnSubmitExperience = findViewById(R.id.btnSubmitExperience);

        // Date Pickers
        etStartDate.setOnClickListener(v -> showDatePickerDialog(etStartDate));
        etEndDate.setOnClickListener(v -> showDatePickerDialog(etEndDate));

        // Submit Button Click Listener
        btnSubmitExperience.setOnClickListener(v -> submitExperience());
    }

    private void showDatePickerDialog(EditText editText) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
            String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
            editText.setText(date);
        }, year, month, day);

        datePicker.show();
    }

    private void submitExperience() {
        String companyName = etCompanyName.getText().toString().trim();
        String jobTitle = etJobTitle.getText().toString().trim();
        String startDate = etStartDate.getText().toString().trim();
        String endDate = etEndDate.getText().toString().trim();

        if (companyName.isEmpty() || jobTitle.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save experience details in SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("ExperienceData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("companyName", companyName);
        editor.putString("jobTitle", jobTitle);
        editor.putString("startDate", startDate);
        editor.putString("endDate", endDate);
        editor.apply();

        Toast.makeText(this, "Experience details saved successfully", Toast.LENGTH_SHORT).show();

        // Navigate to Home Activity
        Intent intent = new Intent(ActivityExperience.this, ActivityHome.class);
        startActivity(intent);
        finish();
    }
}