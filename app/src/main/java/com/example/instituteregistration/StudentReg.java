package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Student;

public class StudentReg extends AppCompatActivity {

    EditText txt_fName,txt_password,txt_lName,txt_address,txt_email,txt_phoneNo,txt_Conpassword ;
    String stdfNameUI,stdPasswordUI,stdlNameUI,stdEmailUI,stdAddressUI,stdConpasswordUI;
    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);
        getSupportActionBar().setTitle("Student SignUp Form");

        txt_fName= findViewById(R.id.txt_fName);
        txt_lName = findViewById(R.id.txt_lName);
        txt_email = findViewById(R.id.txt_email);
        txt_address = findViewById(R.id.txt_address);
        txt_password = findViewById(R.id.txt_password);
        //txt_phoneNo = findViewById(R.id.txt_phoneNo);
        txt_Conpassword = findViewById(R.id.txt_Conpassword);
        myDb = new DBHelper(this);


    }

    public void addStudentInfo(View view){
        boolean valid=false;
        valid=validate();
        if(valid==true) {

            txt_fName = findViewById(R.id.txt_fName);
            txt_lName = findViewById(R.id.txt_lName);
            txt_email = findViewById(R.id.txt_email);
            txt_address = findViewById(R.id.txt_address);
            txt_password = findViewById(R.id.txt_password);
            //txt_phoneNo = findViewById(R.id.txt_phoneNo);
            txt_Conpassword = findViewById(R.id.txt_Conpassword);
            myDb = new DBHelper(this);


            Student std = new Student();
            stdfNameUI = txt_fName.getText().toString();
            std.setfName(stdfNameUI);

            stdlNameUI = txt_lName.getText().toString();
            std.setlName(stdlNameUI);

            stdEmailUI = txt_email.getText().toString();
            std.setEmail(stdEmailUI);

            stdAddressUI = txt_address.getText().toString();
            std.setAddress(stdAddressUI);

            //stdPhoneNoUI = txt_phoneNo.getText().toString();
            //std.setMobileNo(Integer.parseInt(stdPhoneNoUI));

            stdPasswordUI = txt_password.getText().toString();
            std.setPassword(stdPasswordUI);


            boolean status = myDb.addStudentInfo(std);

            if (status == true) {

                Toast.makeText(getApplicationContext(), "Adding Success", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), NewStudentNavigation.class));

            } else {

                Toast.makeText(getApplicationContext(), "Adding false", Toast.LENGTH_LONG).show();

            }
        }
    }

    public boolean validate() {
        boolean valid = false;


        txt_fName = findViewById(R.id.txt_fName);
        txt_lName = findViewById(R.id.txt_lName);
        txt_email = findViewById(R.id.txt_email);
        txt_address = findViewById(R.id.txt_address);
        txt_password = findViewById(R.id.txt_password);
        //txt_phoneNo = findViewById(R.id.txt_phoneNo);
        txt_Conpassword = findViewById(R.id.txt_Conpassword);

        stdEmailUI = txt_email.getText().toString();
        stdPasswordUI = txt_password.getText().toString();
        stdfNameUI = txt_fName.getText().toString();
        stdlNameUI = txt_lName.getText().toString();
        stdAddressUI = txt_address.getText().toString();
        stdConpasswordUI=txt_Conpassword.getText().toString();

        if(!stdConpasswordUI.equals(stdPasswordUI)){

            valid=true;
        }
        else{
            valid=false;
            txt_Conpassword.setError("Password does not match!");
        }


        if(TextUtils.isEmpty(stdfNameUI)){
            valid=false;
            txt_fName.setError("Please enter First Name!");
        }
        else if(TextUtils.isEmpty(stdlNameUI)){
            valid=false;
            txt_lName.setError("Please enter Last Name!");
        }
        else if(TextUtils.isEmpty(stdAddressUI)){
            valid=false;
            txt_address.setError("Please enter Address!");
        }
        else if(TextUtils.isEmpty(stdEmailUI)){
            valid=false;
            txt_email.setError("Please enter Email!");
        }
        else if(TextUtils.isEmpty(stdPasswordUI)){
            valid=false;
            txt_password.setError("Please enter Password!");
        }
        else if(TextUtils.isEmpty(stdConpasswordUI)){
            valid=false;
            txt_Conpassword.setError("Please enter Confirm Password!");
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

        if (stdPasswordUI.isEmpty()) {
            valid = false;
            txt_password.setError("Please enter valid password!");
        } else {
            if (stdPasswordUI.length() > 5) {
                valid = true;
                txt_password.setError(null);
            } else {
                valid = false;
                txt_password.setError("Password is to short!");
            }
        }



            return valid;
    }





}
