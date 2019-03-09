package com.example.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowRating extends AppCompatActivity {


    RatingBar rb;
    TextView value;
    Button buttonSubmit;

    DatabaseReference databaseRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rating);

        databaseRating= FirebaseDatabase.getInstance().getReference("Rating");

        rb=(RatingBar)findViewById(R.id.ratingBar);
        buttonSubmit=(Button)findViewById(R.id.btnSubmit);
        value=(TextView)findViewById(R.id.lblResult);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText("Value is "+ rating );
            }
        });
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    addRating();
            }
        });

    }
    private void addRating(){
        float rate=rb.getRating();

       String id= databaseRating.push().getKey();
       Rating ratei=new Rating();
       databaseRating.child(id).setValue(ratei);
        Toast.makeText(this,"Vote added",Toast.LENGTH_LONG).show();
    }

}
