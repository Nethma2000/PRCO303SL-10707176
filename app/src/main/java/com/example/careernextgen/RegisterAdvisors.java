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
    EditText regName, regEmail, regNic, regMobile, regAge, regScl, regPassword, regConfirm;
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
        regAge = findViewById(R.id.reg_age);
        regScl = findViewById(R.id.reg_scl);
        regPassword = findViewById(R.id.reg_password);
        regConfirm = findViewById(R.id.reg_confirm);

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
                String age = regAge.getText().toString();
                String scl = regScl.getText().toString();
                String password = regPassword.getText().toString();
                String confirm = regConfirm.getText().toString();

                AdvisorsHelperClass helperClass=new AdvisorsHelperClass(name,email,nic,mobile,password,age,scl);

                reference.child(mobile).setValue(helperClass);
                Toast.makeText(RegisterAdvisors.this,"Added successfully",Toast.LENGTH_LONG).show();
                regName.setText(null);
                regEmail.setText(null);
                regNic.setText(null);
                regMobile.setText(null);
                regAge.setText(null);
                regScl.setText(null);
                regPassword.setText(null);
                regConfirm.setText(null);

            }
        });




    }
}