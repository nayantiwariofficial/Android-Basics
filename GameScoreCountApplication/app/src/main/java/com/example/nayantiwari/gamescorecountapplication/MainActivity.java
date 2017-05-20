package com.example.nayantiwari.gamescorecountapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addOnePointTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayScoreTeamA(scoreTeamA);
    }

    public void addTwoPointTeamA(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayScoreTeamA(scoreTeamA);
    }

    public void addThreePointTeamA(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayScoreTeamA(scoreTeamA);
    }

    public void addOnePointTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayScoreTeamB(scoreTeamB);
    }

    public void addTwoPointTeamB(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayScoreTeamB(scoreTeamB);
    }

    public void addThreePointTeamB(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayScoreTeamB(scoreTeamB);
    }

    private void displayScoreTeamA(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score_team_a);
        quantityTextView.setText(String.valueOf(number));
    }

    private void displayScoreTeamB(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score_team_b);
        quantityTextView.setText(String.valueOf(number));
    }

    public void resetWholeScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreTeamA(scoreTeamA);
        displayScoreTeamB(scoreTeamB);
    }
}
