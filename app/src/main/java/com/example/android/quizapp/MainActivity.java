package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.quizapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int score;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void onSubmit(View view) {
        calculateScores();
        displayResults();
    }

    private void calculateScores() {
        score = 0;

        if (binding.quiz1.getCheckedRadioButtonId() == R.id.quiz_1_russia) {
            score++;
        }

        if (binding.quiz2.getCheckedRadioButtonId() == R.id.quiz_2_china) {
            score++;
        }

        if (binding.quiz3Sf.isChecked() && !binding.quiz3Ny.isChecked()
                && binding.quiz3La.isChecked() && !binding.quiz3Miami.isChecked()) {
            score++;
        }

        if (binding.quiz4Input.getText().toString().trim().equalsIgnoreCase("Beijing")) {
            score++;
        }
    }

    private void displayResults() {
        String answer = "The answers should be Russia, China, San Francisco and Los Angeles, Beijing. \n";

        if (score >= 2) {
            Toast.makeText(getApplicationContext(), answer + " You passed the Quiz with score " + score, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), answer + " You failed with score " + score, Toast.LENGTH_SHORT).show();
        }
    }
}