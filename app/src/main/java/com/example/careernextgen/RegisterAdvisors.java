package com.example.careernextgen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.careernextgen.HelperClass.AdvisorsHelperClass;
import com.example.careernextgen.HelperClass.StudentsHelperClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterAdvisors extends AppCompatActivity {
    float v = 0;
    EditText regName, regEmail, regNic, regMobile, regQualification, regLinkedinprofile, regPassword, regDescription;
    Button addbtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_advisors);


        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        regName = findViewById(R.id.reg_name);
        regEmail = findViewById(R.id.reg_email);
        regNic = findViewById(R.id.reg_nic);
        regMobile = findViewById(R.id.reg_mobile);
        regQualification = findViewById(R.id.reg_age);
        regLinkedinprofile = findViewById(R.id.reg_scl);
        regPassword = findViewById(R.id.reg_password);
        regDescription = findViewById(R.id.reg_confirm);

        addbtn =findViewById(R.id.addbtn);


        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("Advisors");

                String name = regName.getText().toString();
                String email = regEmail.getText().toString();
                String nic = regNic.getText().toString();
                String mobile = regMobile.getText().toString();
                String qualification = regQualification.getText().toString();
                String linkedinprofile = regLinkedinprofile.getText().toString();
                String password = regPassword.getText().toString();
                String description = regDescription.getText().toString();

                AdvisorsHelperClass helperClass=new AdvisorsHelperClass(name,email,nic,mobile,password,qualification,linkedinprofile,description);

                reference.child(mobile).setValue(helperClass);
                Toast.makeText(RegisterAdvisors.this,"Added successfully",Toast.LENGTH_LONG).show();
                regName.setText(null);
                regEmail.setText(null);
                regNic.setText(null);
                regMobile.setText(null);
                regQualification.setText(null);
                regLinkedinprofile.setText(null);
                regPassword.setText(null);
                regDescription.setText(null);

            }
        });




    }
}