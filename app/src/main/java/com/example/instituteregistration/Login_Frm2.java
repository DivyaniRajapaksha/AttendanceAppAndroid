package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.instituteregistration.Database.DBHelper;

public class Login_Frm2 extends AppCompatActivity {
    EditText txt_fName,txt_password,txt_lName,txt_address,txt_email,txt_phoneNo,txt_Conpassword ;
    String stdfNameUI,stdPasswordUI,stdlNameUI,stdEmailUI,stdAddressUI,stdPhoneNoUI;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__frm2);
        getSupportActionBar().setTitle("Login Form");
        txt_fName= findViewById(R.id.txt_fName);
        txt_lName = findViewById(R.id.txt_lName);
        txt_email = findViewById(R.id.txt_email);
        txt_address = findViewById(R.id.txt_address);
        txt_password = findViewById(R.id.txt_password);
        //txt_phoneNo = findViewById(R.id.txt_phoneNo);
        txt_Conpassword = findViewById(R.id.txt_Conpassword);
        db = new DBHelper(this);

        Button click = (Button) findViewById(R.id.studentRebB);



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login_Frm2.this, StudentReg.class);
                startActivity(i);


            }
        });

    }

    public void btn_directPage(View view) {
        startActivity(new Intent(getApplicationContext(),StudentReg.class));
    }

    public void btn_Go_to_Navigation(View view) {
        startActivity(new Intent(getApplicationContext(),NewStudentNavigation.class));
    }


    public void login(View view){
       if(validate()) {
           txt_email = findViewById(R.id.txt_email);
           txt_password = findViewById(R.id.txt_password);
           db = new DBHelper(this);

           stdEmailUI = txt_email.getText().toString();
           stdPasswordUI = txt_password.getText().toString();
           boolean status = db.Authenticate(stdEmailUI, stdPasswordUI);

           if (status == true) {

               Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
               Intent i = new Intent(this, NewStudentNavigation.class);
               i.putExtra("email", stdEmailUI);
               startActivity(i);


               System.out.println(stdEmailUI);


           } else {

               Toast.makeText(getApplicationContext(), "Login false", Toast.LENGTH_LONG).show();

           }
       }
    }

    public boolean validate() {
        boolean valid = false;

        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);

        stdEmailUI = txt_email.getText().toString();
        stdPasswordUI = txt_password.getText().toString();

         if(TextUtils.isEmpty(stdEmailUI)){
            valid=false;
            txt_email.setError("Please enter Email!");
        }
         else if(TextUtils.isEmpty(stdPasswordUI)){
             valid=false;
             txt_password.setError("Please enter Password!");
         }
         else{
             valid=true;
         }



        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(stdEmailUI).matches()) {
            valid = false;
            txt_email.setError("Please enter valid email!");
        } else {
            valid = true;
            txt_email.setError(null);
        }
         return valid;


    }
}
