package com.example.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class quiz1 extends AppCompatActivity {

    TextView quizQuestion, quesNumber;
    Button btnPrevious, btnNext;
    RadioGroup optQuiz;
    RadioButton opt1, opt2, opt3, opt4;

    String[] questions = {
            "What is the national flower of Pakistan?",
            "Who was the first Prime Minister of Pakistan?",
            "Which river is the longest in Pakistan?",
            "What is the capital of Balochistan province?",
            "Which city is known as the 'Heart of Pakistan'?",
            "Which of these is the highest peak in Pakistan?",
            "Which of these cities is known as the 'City of Lights'?",
            "Which Pakistani cricketer scored the fastest century in ODI cricket (as of 2025)?",
            "What is the national animal of Pakistan?",
            "Who designed the national flag of Pakistan?"
    };

    String[][] options = {
            {"Rose", "Tulip", "Sunflower", "Jasmine"},
            {"Liaquat Ali Khan", "Zulfikar Ali Bhutto", "Muhammad Ali Jinnah", "Ayub Khan"},
            {"Ravi", "Sutlej", "Indus", "Jhelum"},
            {"Gwadar", "Quetta", "Khuzdar", "Turbat"},
            {"Karachi", "Islamabad", "Lahore", "Peshawar"},
            {"Nanga Parbat", "Broad Peak", "Rakaposhi", "K2"},
            {"Lahore", "Karachi", "Islamabad", "Peshawar"},
            {"Fakhar Zaman", "Babar Azam", "Shahid Afridi", "Imam-ul-Haq"},
            {"Snow Leopard", "Markhor", "Bengal Tiger", "Black Panther"},
            {"Liaquat Ali Khan", "Amiruddin Kidwai", "Chaudhry Rehmat Ali", "Allama Iqbal"}
    };

    int[] correctAnswers = {3, 0, 2, 1, 2, 3, 1, 0, 1, 1};

    int currIndex = 0;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        quizQuestion = findViewById(R.id.quizQuestion);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        quesNumber = findViewById(R.id.quesNumber);

        optQuiz = findViewById(R.id.optQuiz);
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);

        loadQuestion();

        btnNext.setOnClickListener(v -> {
            checkAnswer();
            currIndex++;
            if (currIndex < questions.length) {
                loadQuestion();
            } else {
                showResult();
            }
        });

        btnPrevious.setOnClickListener(v -> {
            checkAnswer();
            currIndex--;
            if (currIndex >= 0) {
                loadQuestion();
            }
        });
    }
    private void loadQuestion() {
        quizQuestion.setText(questions[currIndex]);
        opt1.setText(options[currIndex][0]);
        opt2.setText(options[currIndex][1]);
        opt3.setText(options[currIndex][2]);
        opt4.setText(options[currIndex][3]);
        optQuiz.clearCheck();

        btnPrevious.setEnabled(currIndex > 0);
        btnNext.setText(currIndex == questions.length - 1 ? "Finish" : "Next");
        quesNumber.setText((currIndex + 1) + "/10");
    }

    private void checkAnswer() {
        int selectedId = optQuiz.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        int selectedIndex = optQuiz.indexOfChild(selectedRadioButton);
        if (selectedIndex == correctAnswers[currIndex]) {
            score++;
        }
    }

    private void showResult() {
        Toast.makeText(this, "Quiz Over! Your Score: " + score, Toast.LENGTH_LONG).show();
        finish(); // Close the quiz
//        Intent intent = new Intent(quiz1.this, Result.class);
//        intent.putExtra("SCORE", score);
//        intent.putExtra("TOTAL_QUESTIONS", questions.length);
//        startActivity(intent);
//        finish();
    }

}