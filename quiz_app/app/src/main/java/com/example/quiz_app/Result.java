package com.example.quiz_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {

    TextView PersonName, ScoreResult;
    Button btnPrevResult, btnShareScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        PersonName = findViewById(R.id.PersonName);
        ScoreResult = findViewById(R.id.ScoreResult);
        btnPrevResult = findViewById(R.id.btnPrevResult);
        btnShareScore = findViewById(R.id.btnShareScore);

        int score = getIntent().getIntExtra("SCORE", 0);
        String person_name = getIntent().getStringExtra("person_name");

        PersonName.setText(person_name);
        ScoreResult.setText((score) + "/10");

//        btnPrevResult.setOnClickListener(v -> {
//            onPrevPressed();
//        });

//        btnShareScore.setOnClickListener(v -> {
//            onSharePressed();
//        });


    }
}