package com.example.careernextgen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboard extends AppCompatActivity {

Button adbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        adbtn=findViewById(R.id.addbutton);
        adbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent passIntent = new Intent(AdminDashboard.this, RegisterAdvisors.class);
                startActivity(passIntent);
            }
        });
    }
}