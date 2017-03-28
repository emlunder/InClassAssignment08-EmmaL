package com.example.cmltdstudent.inclassassignment08_emmal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference userRef = database.getReference("overview");
    private ArrayList<MathScore> scoreList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = (TextView) findViewById(R.id.display_text);

        //creating the object on the go
        //when something changes on Firebase we update the display

//        userRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                MathScore s = dataSnapshot.getValue(MathScore.class);
//                displayText.setText(s.toString());
//            }
//
//            @Override
//            //when something gets cancelled we display a toast message
//            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(MainActivity.this, "Error loading Firebase", Toast.LENGTH_SHORT).show();
//            }
//        });

        userRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                scoreList.add(dataSnapshot.getValue(MathScore.class));
                displayScore();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(MathScore.class) + " has changed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(MathScore.class) + " is removed", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    private void displayScore() {
        String text = "";
        for (MathScore s : scoreList)
            text += s + "\n";
        displayText.setText(text);
    }

    public void openFillerScreen (View view)
    {
        Intent i = new Intent(this, FillerScreen.class);
        startActivity(i);
    }
}
