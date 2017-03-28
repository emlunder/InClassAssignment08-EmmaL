package com.example.cmltdstudent.inclassassignment08_emmal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FillerScreen extends AppCompatActivity {

    private EditText userName;
    private EditText userScore;
    private CheckBox passThis;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference userRef = database.getReference("overview");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filler_screen);

        userName = (EditText) findViewById(R.id.user_name);
        userScore = (EditText) findViewById(R.id.user_score);
        passThis = (CheckBox) findViewById(R.id.user_level);

    }


    public void openActivityMain (View view)
    {
        String user = userName.getText().toString();
        int score = Integer.parseInt(userScore.getText().toString());
        boolean pass = passThis.isChecked();


        MathScore wahoo = new MathScore(user, score, pass);
        userRef.push().setValue(wahoo);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
