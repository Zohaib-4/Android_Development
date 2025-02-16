package com.example.quiz_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

        btnPrevResult.setOnClickListener(v -> {
            onPrevPressed();
        });

        btnShareScore.setOnClickListener(v -> {
            shareToEmail();
        });


    }

    private void onPrevPressed() {
        Intent intent = new Intent(Result.this, quiz1.class);
        startActivity(intent);
        finish();
    }
    private void shareToEmail() {
        String person_name = getIntent().getStringExtra("person_name");
        int score = getIntent().getIntExtra("SCORE", 0);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:sameer.zohaib363@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz App Result");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi " + person_name + ",\n\nYour score is: " + score + "/10");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}