package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Teacher;

public class TeacherLogin extends AppCompatActivity {

    EditText txt_Name,txt_password,txt_Manager,txt_address,txt_email,txt_Hotline,txt_website,txt_Desc ;
    String stxt_Name,stxt_password,stxt_Manager,stxt_address,stxt_email,stxt_Hotline,stxt_website,stxt_Desc;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        getSupportActionBar().setTitle("Teacher Login");

        Button clickreg = (Button) findViewById(R.id.InsLoginRegB);
        Button clicklog = (Button) findViewById(R.id.btnlogin);

        clickreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TeacherLogin.this, RegTeacher.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Register Your Self", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void login(View view){
        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);
        db = new DBHelper(this);

        stxt_email = txt_email.getText().toString();
        stxt_password= txt_password.getText().toString();
        boolean status=db.AuthenticateTeacher(stxt_email,stxt_password);

        if(status == true){



            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, TeacherProfile.class);
            i.putExtra("email",stxt_email);

            Log.v("loginExtra",stxt_email);

            startActivity(i);



            System.out.println(stxt_email);


        }else{

            Toast.makeText(getApplicationContext(),"Login failed",Toast.LENGTH_LONG).show();

        }

    }
}
