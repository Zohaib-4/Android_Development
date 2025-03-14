package com.example.cv_builder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RelativeLayout splashLayout = findViewById(R.id.splash_layout);

        // Load and apply fade-in animation
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        splashLayout.startAnimation(fadeIn);

        // Delay and transition to main activity with fade-out
        new Handler().postDelayed(() -> {
            Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
            splashLayout.startAnimation(fadeOut);

            fadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    // Start main activity
                    Intent intent = new Intent(MainActivity.this, ActivityHome.class);
                    startActivity(intent);
                    finish(); // Close splash activity
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
        }, 3000); // Delay of 3 seconds
    }
}