package com.example.cv_builder;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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

        // Save data using SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("EducationData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("degreeTitle", degreeTitle);
        editor.putString("institution", institution);
        editor.putString("major", major);
        editor.putString("gradYear", gradYear);
        editor.putString("educationLevel", selectedEducationLevel);
        editor.apply();

        Toast.makeText(this, "Education data saved successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ActivityEducation.this, ActivityHome.class);
        startActivity(intent);
        finish();
    }
}
