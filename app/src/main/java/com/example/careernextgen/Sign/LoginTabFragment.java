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

import com.example.careernextgen.AdminDashboard;
import com.example.careernextgen.CareerAdvisorDashboard;
import com.example.careernextgen.R;
import com.example.careernextgen.StudentDashboard;
import com.example.careernextgen.UserProfile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginTabFragment extends Fragment {
    float v=0;
    EditText email,password;
    TextView forgotpassword;
    Button loginbtn;
    FloatingActionButton fb,google,twitter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.activity_login_tab_fragment,container,false);

        loginbtn = root.findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                logtoapp();
            }

            private void logtoapp() {

                String userenteredemail = email.getText().toString();
                String userenteredpassword = password.getText().toString();

//                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Students");
//
//                Query checkUser=reference.orderByChild("email").equalTo(userenteredpassword);
//                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//
//                            email.setError(null);
//                          password.setError(null);
//
//                            String passwordfromdb=snapshot.child(userenteredemail).child("password").getValue(String.class);
//
//                            if(passwordfromdb.equals(userenteredpassword)){
//
//                                String agefromdb=snapshot.child(userenteredemail).child("age").getValue(String.class);
//                                String emailfromdb=snapshot.child(userenteredemail).child("email").getValue(String.class);
//                                String mobilefromdb=snapshot.child(userenteredemail).child("mobile").getValue(String.class);
//                                String namefromdb=snapshot.child(userenteredemail).child("name").getValue(String.class);
//                                String nicfromdb=snapshot.child(userenteredemail).child("nic").getValue(String.class);
//                                String passwfromdb=snapshot.child(userenteredemail).child("password").getValue(String.class);
//                                String sclfromdb=snapshot.child(userenteredemail).child("scl").getValue(String.class);
//
//
//
//                                Intent inten = new Intent(getContext(), UserProfile.class);
//
//                                inten.putExtra("name",namefromdb);
//                                inten.putExtra("email",emailfromdb);
//                                inten.putExtra("nic",nicfromdb);
//                                inten.putExtra("mobile",mobilefromdb);
//                                inten.putExtra("age",agefromdb);
//                                inten.putExtra("scl",sclfromdb);
//                                inten.putExtra("password",passwfromdb);
//
//                                startActivity(inten);
//                                 inten.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//
//                            }
//                            else{
//                               password.setError("wrong password");
//                               password.requestFocus();
//                            }
//                        }
//
//                        else{
//                            email.setError("use not exist");
//                            email.requestFocus();
//                        }
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
    if(userenteredemail.equals("admin@gmail.com") && userenteredpassword.equals("Admin@123")){

        Intent inten = new Intent(getContext(), AdminDashboard.class);
        inten.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(inten);
    }

    else if(userenteredemail.equals("student@gmail.com") && userenteredpassword.equals("Stu@123")){
        Intent inten = new Intent(getContext(),StudentDashboard.class);
        inten.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(inten);
    }
    else if(userenteredemail.equals("advisor@gmail.com") && userenteredpassword.equals("Adv@123")){
        Intent inten = new Intent(getContext(), CareerAdvisorDashboard.class);
        inten.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(inten);
    }

    else{
        Toast.makeText(getContext(), "Error!!!", Toast.LENGTH_LONG).show();
    }


            }
        });







        email=root.findViewById(R.id.email);
        password=root.findViewById(R.id.password);
        loginbtn = root.findViewById(R.id.loginbtn);
        forgotpassword=(TextView) root.findViewById(R.id.forgotpassword);

        email.setTranslationX(800);
        password.setTranslationX(800);
        forgotpassword.setTranslationX(800);
        loginbtn.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        forgotpassword.setAlpha(v);
        loginbtn.setAlpha(v);

        fb=root.findViewById(R.id.fab_facebook);
        google=root.findViewById(R.id.fab_google);
        twitter=root.findViewById(R.id.fab_twitter);

        fb.setTranslationY(300);
        google.setTranslationY(300);
        twitter.setTranslationY(300);
        fb.setAlpha(v);
        google.setAlpha(v);
        twitter.setAlpha(v);
        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        forgotpassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        loginbtn.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        return root;
    }



    private boolean validateEmail(){
        String val = email.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()){
            email.setError("Field should not be empty");
            return false;
        }
        else if (!val.matches(emailPattern)) {
            email.setError("Invalid email address");
            return false;
        }
        else {
            email.setError(null);
            return true;
        }
    }


    private Boolean validatePassword() {
        String val = password.getText().toString();
        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        }
        else if (val.length() < 6 | !val.matches("(.*[0-9].*)") | !val.matches("(.*[A-Z].*)") | !val.matches("^(?=.*[_.()$&@]).*$") ) {
            password.setError("Invalid Password");
            return false;
        }


        else {
            password.setError(null);
            return true;
        }


    }



    }





