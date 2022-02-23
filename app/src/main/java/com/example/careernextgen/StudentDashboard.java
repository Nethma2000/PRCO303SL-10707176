package com.example.careernextgen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentDashboard extends AppCompatActivity {
    Button probtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        probtn=findViewById(R.id.prof_button);
        probtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent passIntent = new Intent(StudentDashboard.this, UserProfile.class);
                startActivity(passIntent);
            }
        });
    }
    }
