package com.example.android.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MY_NAME = "com.example.android.scorekeeper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //this function stores the entered text in a variable and makes it ready to pass to the next page
    public void enterTeamNames(View vw) {
        EditText txtTextAName = (EditText) this.findViewById(R.id.Team_AName);
        EditText txtTextBName = (EditText) this.findViewById(R.id.Team_BName);
        String nameA = txtTextAName.getText().toString();
        String nameB = txtTextBName.getText().toString();
        String bothNames = nameA + "-" + nameB;

        Intent intent = new Intent(this, ScorePage.class);
        intent.putExtra(MY_NAME, bothNames);
        this.startActivity(intent);

    }

    //this function exits the app
    public void exitApp(View vw) {
        System.exit(0);
    }
}
