package com.example.cv_builder;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;


public class ActivityEducation extends AppCompatActivity {

    EditText etDegreeTitle, etInstitution, etMajor, etGradYear;
    Spinner spEducationLevel;
    Button btnSubmit;
    String selectedEducationLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        // Initialize UI components
        etDegreeTitle = findViewById(R.id.etDegreeTitle);
        etInstitution = findViewById(R.id.etInstitution);
        etMajor = findViewById(R.id.etMajor);
        etGradYear = findViewById(R.id.etGradYear);
        spEducationLevel = findViewById(R.id.spEducationLevel);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Populate the Education Level Spinner
        String[] educationLevels = {"Select Level", "High School", "Associate's", "Bachelor's", "Master's", "PhD"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, educationLevels);
        spEducationLevel.setAdapter(adapter);

        spEducationLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedEducationLevel = educationLevels[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedEducationLevel = "Select Level";
            }
        });

        // Graduation Year Picker
        etGradYear.setOnClickListener(v -> showYearPicker());

        // Submit Button Click Listener
        btnSubmit.setOnClickListener(v -> submitEducationInfo());
    }

    private void showYearPicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePicker = new DatePickerDialog(this, (view, selectedYear, month, dayOfMonth) -> {
            etGradYear.setText(String.valueOf(selectedYear));
        }, year, 0, 1);

        datePicker.getDatePicker().setCalendarViewShown(false);
        datePicker.getDatePicker().setSpinnersShown(true);
        datePicker.show();
    }

    private void submitEducationInfo() {
        String degreeTitle = etDegreeTitle.getText().toString().trim();
        String institution = etInstitution.getText().toString().trim();
        String major = etMajor.getText().toString().trim();
        String gradYear = etGradYear.getText().toString().trim();

        if (degreeTitle.isEmpty() || institution.isEmpty() || major.isEmpty() || gradYear.isEmpty() || "Select Level".equals(selectedEducationLevel)) {
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show();
            return;
        }

        // Sending data to ActivityResult
        Intent resultIntent = new Intent(ActivityEducation.this, ActivityResult.class);
        resultIntent.putExtra("degreeTitle", degreeTitle);
        resultIntent.putExtra("institution", institution);
        resultIntent.putExtra("major", major);
        resultIntent.putExtra("gradYear", gradYear);
        resultIntent.putExtra("educationLevel", selectedEducationLevel);
        startActivity(resultIntent);

        // Open ActivityHome after submission
        Intent homeIntent = new Intent(ActivityEducation.this, ActivityHome.class);
        startActivity(homeIntent);

        // Finish current activity
        finish();
    }
}