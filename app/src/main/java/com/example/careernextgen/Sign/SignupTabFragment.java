package com.example.careernextgen.Sign;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.careernextgen.HelperClass.StudentsHelperClass;
import com.example.careernextgen.R;
import com.example.careernextgen.Walkthrough;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupTabFragment extends Fragment {
    float v = 0;
    EditText regName, regEmail, regNic, regMobile, regAge, regScl, regPassword, regConfirm;
    Button signupbtn;

FirebaseDatabase rootNode;
DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_signup_tab_fragment, container, false);
        regName = root.findViewById(R.id.reg_name);
        regEmail = root.findViewById(R.id.reg_email);
        regNic = root.findViewById(R.id.reg_nic);
        regMobile = root.findViewById(R.id.reg_mobile);
        regAge = root.findViewById(R.id.reg_age);
        regScl = root.findViewById(R.id.reg_scl);
        regPassword = root.findViewById(R.id.reg_password);
        regConfirm = root.findViewById(R.id.reg_confirm);

        signupbtn = root.findViewById(R.id.signupbtn);




        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("Students");
                if(!validateName() |!validatePassword() | !validateMobile() | !validateNIC() | !validateEmail() | !validateConfirm() | !passmatch())
                {
                    return;
                }
                String name = regName.getText().toString();
                String email = regEmail.getText().toString();
                String nic = regNic.getText().toString();
                String mobile = regMobile.getText().toString();
                String age = regAge.getText().toString();
                String scl = regScl.getText().toString();
                String password = regPassword.getText().toString();
                String confirm = regConfirm.getText().toString();

                StudentsHelperClass helperClass=new StudentsHelperClass(name,email,nic,mobile,password,age,scl);

                reference.child(mobile).setValue(helperClass);
                Toast.makeText(getContext(), "User Saved!!!", Toast.LENGTH_LONG).show();
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



        regName.setTranslationX(800);
        regEmail.setTranslationX(800);
        regNic.setTranslationX(800);
        regMobile.setTranslationX(800);
        regAge.setTranslationX(800);
        regScl.setTranslationX(800);
        regPassword.setTranslationX(800);
        regConfirm.setTranslationX(800);

        regName.setAlpha(v);
        regEmail.setAlpha(v);
        regNic.setAlpha(v);
        regMobile.setAlpha(v);
        regAge.setAlpha(v);
        regScl.setAlpha(v);
        regPassword.setAlpha(v);
        regConfirm.setAlpha(v);

        regName.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(100).start();
        regEmail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(100).start();
        regNic.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(100).start();
        regMobile.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(100).start();
        regAge.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(100).start();
        regScl.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(100).start();
        regPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        regConfirm.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();


        return root;
    }


    private boolean validateName(){
        String val = regName.getText().toString();
        if (val.isEmpty()) {
            regName.setError("Field should not be empty");
            return false;
        } else {
            regName.setError(null);

            return true;
        }
    }

    private boolean validateEmail() {
        String val = regEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            regEmail.setError("Field should not be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Invalid email address");
            return false;
        } else {
            regEmail.setError(null);
            return true;
        }
    }

    private boolean validateNIC() {
        String val = regNic.getText().toString();
        String nicPattern = "[0-9]{12}";
        String nicPattern2 = "[0-9]{9}^\\d+[v]?$";

        if (val.isEmpty()) {
            regNic.setError("Field should not be empty");
            return false;
        } else if (val.length() > 12) {
            regNic.setError("NIC too long");
            return false;
        } else if (val.length() < 10) {
            regNic.setError("NIC too short");
            return false;
        } else if (val.length() == 12) {
            if (!val.matches(nicPattern)) {
                regNic.setError("If your NIC has 12 characters, all should be numeric");
                return false;
            } else {
                regNic.setError(null);
                return true;
            }
        } else if (val.length() == 11) {
            regNic.setError("Entered NIC is invalid");
            return false;
        }
        else if(val.length()==10){
            if(!(regNic.getText().toString().trim().matches("^[0-9]{9}[vVxX]$"))){
                regNic.setError("If your NIC has 10 characters,it should include 10 digits and letter v at the end");
                return false;
            }else{
                regNic.setError(null);
                return true;
            }
        }

        else {
            regNic.setError(null);
            return true;
        }
    }



    private boolean validateMobile(){

        String val = regMobile.getText().toString();
        String MobilePattern = "[0-9]{10}";
        if (val.isEmpty()){
            regMobile.setError("Field should not be empty");
            return false;
        }

        else if (!val.matches(MobilePattern)) {
            regMobile.setError("Please enter valid 10 digit phone number");
            return false;
        }
        else {
            regMobile.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = regPassword.getText().toString();

        // 8 character
        if (val.length() < 6) {
            regPassword.setError("Password should have at least 6 characters");
            return false;

        }
        //number,capital letter,symbol
        else if (!val.matches("(.*[0-9].*)") | !val.matches("(.*[A-Z].*)") | !val.matches("^(?=.*[_.()$&@]).*$") ) {
            regPassword.setError("Password is too weak.It should contain at least 1 number,1 upper case letter and a special symbol");
            return false;
        }


        else if (val.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        } else {
            regPassword.setError(null);
            return true;
        }
    }


    private boolean validateConfirm(){
        String val=regConfirm.getText().toString();

        if(val.isEmpty()){
            regConfirm.setError("Field cannot be empty");
            return false;
        }

        else{
            regConfirm.setError(null);
            return true;
        }
    }

    private boolean passmatch(){

        if(!regPassword.getText().toString().equals(regConfirm.getText().toString())){

            regConfirm.setError("Passwords do not match.");
            return false;

        }
        else {
            regConfirm.setError(null);
            return true;
        }

    }

}

