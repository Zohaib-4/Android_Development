package com.example.cv_builder;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class ActivityDetails extends AppCompatActivity {

    EditText etFullName, etEmail, etPhone, etArea, etDob;
    RadioGroup rgGender;
    Spinner spCountry, spCity;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etArea = findViewById(R.id.etArea);
        etDob = findViewById(R.id.etDob);
        rgGender = findViewById(R.id.rgGender);
        spCountry = findViewById(R.id.spCountry);
        spCity = findViewById(R.id.spCity);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Setup Country Spinner
        String[] countries = {"Select Country", "Pakistan", "United States", "Brazil",
                "Japan", "Germany", "Australia", "India", "South Africa"};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(countryAdapter);

        // Setup City Spinner (Pakistani cities)
        String[] cities = {"Select City", "Karachi", "Lahore", "Islamabad",
                "Rawalpindi", "Faisalabad", "Multan", "Peshawar", "Quetta"};
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cities);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCity.setAdapter(cityAdapter);

        // Date Picker for Date of Birth
        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        ActivityDetails.this,
                        (view, selectedYear, selectedMonth, selectedDay) -> {
                            String date = String.format("%02d/%02d/%d", selectedDay, selectedMonth + 1, selectedYear);
                            etDob.setText(date);
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        // Submit Button Click Listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect data
                String fullName = etFullName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String area = etArea.getText().toString().trim();
                String dob = etDob.getText().toString().trim();
                String country = spCountry.getSelectedItem().toString();
                String city = spCity.getSelectedItem().toString();

                // Get selected gender
                int selectedGenderId = rgGender.getCheckedRadioButtonId();
                String gender = "";
                if (selectedGenderId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedGenderId);
                    gender = selectedRadioButton.getText().toString();
                }

                // Basic validation
                if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || area.isEmpty() ||
                        dob.isEmpty() || gender.isEmpty() ||
                        country.equals("Select Country") || city.equals("Select City")) {
                    Toast.makeText(ActivityDetails.this,
                            "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Store data in SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("fullName", fullName);
                    editor.putString("email", email);
                    editor.putString("phone", phone);
                    editor.putString("area", area);
                    editor.putString("dob", dob);
                    editor.putString("gender", gender);
                    editor.putString("country", country);
                    editor.putString("city", city);
                    editor.apply();

                    Toast.makeText(ActivityDetails.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}