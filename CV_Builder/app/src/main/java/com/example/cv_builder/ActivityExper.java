package com.example.cv_builder;

import android.app.DatePickerDialog;
import android.content.Intent;
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

public class ActivityExper extends AppCompatActivity {

    EditText etCompanyName, etJobTitle, etStartDate, etEndDate, etResponsibilities;
    ChipGroup chipGroupTechnologies;
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
        etResponsibilities = findViewById(R.id.etResponsibilities);
        chipGroupTechnologies = findViewById(R.id.chipGroupTechnologies);
        btnSubmitExperience = findViewById(R.id.btnSubmitExperience);

        // Start Date Picker
        etStartDate.setOnClickListener(v -> showDatePickerDialog(etStartDate));

        // End Date Picker
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
        String responsibilities = etResponsibilities.getText().toString().trim();
        ArrayList<String> selectedTechnologies = new ArrayList<>();

        // Get selected technologies
        for (int i = 0; i < chipGroupTechnologies.getChildCount(); i++) {
            Chip chip = (Chip) chipGroupTechnologies.getChildAt(i);
            if (chip.isChecked()) {
                selectedTechnologies.add(chip.getText().toString());
            }
        }

        if (companyName.isEmpty() || jobTitle.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || responsibilities.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Send data to ActivityResult
        Intent resultIntent = new Intent(ActivityExper.this, ActivityResult.class);
        resultIntent.putExtra("companyName", companyName);
        resultIntent.putExtra("jobTitle", jobTitle);
        resultIntent.putExtra("startDate", startDate);
        resultIntent.putExtra("endDate", endDate);
        resultIntent.putExtra("responsibilities", responsibilities);
        resultIntent.putExtra("technologies", selectedTechnologies.toArray(new String[0]));
        startActivity(resultIntent);

        // Open ActivityHome
        Intent homeIntent = new Intent(ActivityExper.this, ActivityHome.class);
        startActivity(homeIntent);

        // Finish current activity
        finish();
    }
}