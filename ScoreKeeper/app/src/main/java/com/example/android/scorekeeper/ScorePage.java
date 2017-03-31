package com.example.android.scorekeeper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScorePage extends AppCompatActivity {

    //team names
    private String teamAName;
    private String teamBName;

    // variables for team A
    private int totalScoreA = 0;
    private int totalOverA = 0;
    private int totalOutTeamA = 0;

    // variables for team B
    private int totalScoreB = 0;
    private int totalOverB = 0;
    private int totalOutTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        String name = this.getIntent().getStringExtra(MainActivity.MY_NAME);
        String[] bothName = name.split("-");
        teamAName = bothName[0];
        teamBName = bothName[1];

        //tvmMessage is the id of the text box where the text should be appear
        TextView teamAnameId = (TextView) this.findViewById(R.id.team_a_name);
        TextView teamBnameId = (TextView) this.findViewById(R.id.team_b_name);

        //String message = this.getResources().getString(R.string.app_name) + " " + teamAName + " <-> " + teamBName;

        teamAnameId.setText("Team " + teamAName);
        teamBnameId.setText("Team " + teamBName);
    }

    //======================================================> Team A methods
    //next 4 methods are for scores of team A
    public void addOneToTeamA(View view) {
        displayScoreTeamA(1);
    }

    public void addFourToTeamA(View view) {
        displayScoreTeamA(4);
    }

    public void addSixToTeamA(View view) {
        displayScoreTeamA(6);
    }

    public void displayScoreTeamA(int score) {
        totalScoreA += score;
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(totalScoreA));
    }

    //next 2 methods are for over of team A
    public void addOneBalltoTeamAOver(View view){
        calculateTotalOvers(1);
    }

    public void calculateTotalOvers(int ball) {
        totalOverA += ball;
        TextView scoreView = (TextView) findViewById(R.id.team_a_over);
        scoreView.setText(String.valueOf(totalOverA));
    }

    public void countOneOutTeamA(View view) {
        minusOneFromTotalOutTeamA(1);
    }

    public void minusOneFromTotalOutTeamA(int out) {
        totalOutTeamA += out;

        if(totalOutTeamA >= 12) {
            new AlertDialog.Builder(this)
                    .setTitle("No more batsman")
                    .setMessage("There are no batsmen left for team '" + teamAName + "'.")
                    .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) { }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else {
            TextView scoreView = (TextView) findViewById(R.id.team_a_outs);
            scoreView.setText(String.valueOf(totalOutTeamA));
        }
    }

    //======================================================> Team B methods
    //next 4 methods are for scores of team A
    public void addOneToTeamB(View view) {
        displayScoreTeamB(1);
    }

    public void addFourToTeamB(View view) {
        displayScoreTeamB(4);
    }

    public void addSixToTeamB(View view) {
        displayScoreTeamB(6);
    }

    public void displayScoreTeamB(int score) {
        totalScoreB += score;
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(totalScoreB));
    }

    //next 2 methods are for over of team A
    public void addOneBalltoTeamBOver(View view){
        calculateTotalOversB(1);
    }

    public void calculateTotalOversB(int ball) {
        totalOverB += ball;
        TextView scoreView = (TextView) findViewById(R.id.team_b_over);
        scoreView.setText(String.valueOf(totalOverB));
    }

    public void countOneOutTeamB(View view) {
        minusOneFromTotalOutTeamB(1);
    }

    public void minusOneFromTotalOutTeamB(int out) {
        totalOutTeamB += out;

        if(totalOutTeamB >= 12) {
            new AlertDialog.Builder(this)
                    .setTitle("No more batsman")
                    .setMessage("There are no batsmen left for team '" + teamBName + "'.")
                    .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) { }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        } else {
            TextView scoreView = (TextView) findViewById(R.id.team_b_outs);
            scoreView.setText(String.valueOf(totalOutTeamB));
        }
    }

    public void resetAllVariables(View view) {

        totalScoreA = 0;
        totalOverA = 0;
        totalOutTeamA = 0;

        displayScoreTeamA(0);
        calculateTotalOvers(0);
        minusOneFromTotalOutTeamA(0);

        totalScoreB = 0;
        totalOverB = 0;
        totalOutTeamB = 0;

        displayScoreTeamB(0);
        calculateTotalOversB(0);
        minusOneFromTotalOutTeamB(0);

    }

    //this back button does not work properly, it creates another intent of the page
    //that means it creates more intents while keeps the existing one
    public void back(View vw) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    //this function exits the app
    public void exitApp(View vw) {
        System.exit(0);
    }
}








