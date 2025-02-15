package com.example.quiz_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class quiz1 extends AppCompatActivity {

    TextView quizQuestion;
    Button btnPrevious, btnNext;
    RadioGroup optQuiz1;
    RadioButton opt1, opt2, opt3, opt4;

    String[] questions = {
            "What is the national flower of Pakistan?",
            "Who was the first Prime Minister of Pakistan?",
            "Which river is the longest in Pakistan?",
            "What is the capital of Balochistan province?",
            "When did Pakistan become a nuclear power?",
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
            {"1996", "1998", "2000", "1995"},
            {"Nanga Parbat", "Broad Peak", "Rakaposhi", "K2"},
            {"Lahore", "Karachi", "Islamabad", "Peshawar"},
            {"Fakhar Zaman", "Babar Azam", "Shahid Afridi", "Imam-ul-Haq"},
            {"Snow Leopard", "Markhor", "Bengal Tiger", "Black Panther"},
            {"Liaquat Ali Khan", "Amiruddin Kidwai", "Chaudhry Rehmat Ali", "Allama Iqbal"}
    };

    int[] correctAnswers = {3, 0, 2, 1, 1, 3, 1, 0, 1, 1};

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
        optQuiz1 = findViewById(R.id.optQuiz1);

    }
}