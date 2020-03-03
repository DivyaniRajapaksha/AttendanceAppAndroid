package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Institute;
import com.example.instituteregistration.Demo.Teacher;
import com.google.android.material.textfield.TextInputEditText;

public class RegTeacher extends AppCompatActivity {

    EditText txt_fullName, txt_subject, txt_email, txt_password, txt_address, txt_phoneNo,txt_cpassword;
    String stxt_fullName, stxt_subject, stxt_email, stxt_password, stxt_address, stxt_phoneNo,stxt_cpassword;

    String p,conp,e;
    DBHelper db;
    boolean status=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_teacher);

        txt_fullName =(TextInputEditText) findViewById(R.id.TFullName);
        txt_subject =(TextInputEditText) findViewById(R.id.TSubject);
        txt_email =(TextInputEditText) findViewById(R.id.TEmail);
        txt_password =(TextInputEditText) findViewById(R.id.TPassword);
        txt_cpassword =(TextInputEditText) findViewById(R.id.TConPassword);
        txt_address =(TextInputEditText) findViewById(R.id.TAddress);
        txt_phoneNo =(TextInputEditText) findViewById(R.id.TMobile);


        db = new DBHelper(this);


    }


    public void addTeacherInfo(View view){






        p = txt_password.getText().toString();
        conp=txt_cpassword.getText().toString();

        e =txt_email.getText().toString();
        Teacher ins = new Teacher();

        if(p.equals(conp)) {

            if(isValidEmail(e)){



                stxt_fullName = txt_fullName.getText().toString();
                ins.setFullName(stxt_fullName);

                stxt_subject = txt_subject.getText().toString();
                ins.setSubject(stxt_subject);

                stxt_email = txt_email.getText().toString();
                ins.setEmail(stxt_email);

                stxt_address = txt_address.getText().toString();
                ins.setAddress(stxt_address);

                stxt_password = txt_password.getText().toString();
                ins.setPassword(stxt_password);



                stxt_phoneNo = txt_phoneNo.getText().toString();
                ins.setMobileNo(stxt_phoneNo);


                status = db.addTeacherInfo(ins);}

            else{

                Toast.makeText(getApplicationContext(),"Email Invalid",Toast.LENGTH_SHORT).show();
            }

        }else{

            Toast.makeText(getApplicationContext(),"Password MisMatch",Toast.LENGTH_SHORT).show();




        }

        if(status == true){

            Toast.makeText(getApplicationContext(),"Teacher Registered Success",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), TeacherLogin.class));

        }else{

            Toast.makeText(getApplicationContext(),"Registration failed",Toast.LENGTH_LONG).show();

        }
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

}
