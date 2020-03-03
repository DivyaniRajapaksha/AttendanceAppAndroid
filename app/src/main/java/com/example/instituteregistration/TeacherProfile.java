package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Institute;
import com.example.instituteregistration.Demo.Student;
import com.example.instituteregistration.Demo.Teacher;

public class TeacherProfile extends AppCompatActivity {

    TextView txt_Name, txt_password, txt_Sub, txt_address, txt_email, txt_Hotline, txt_website, txt_Desc;
    EditText etxt_Name, etxt_password, etxt_Manager, etxt_address, etxt_email, etxt_Hotline, etxt_website, etxt_Desc;
    String stxt_Name, stxt_password, stxt_Sub, stxt_address, stxt_email, stxt_Hotline, stxt_website, stxt_Desc;
    String n, p, m, a, e, h, w, d;
    DBHelper db;
    String Teachermail;


    Institute ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);


        Intent intent = getIntent();

        Teachermail= intent.getExtras().getString("email");





        txt_Name = findViewById(R.id.txt_fName);
        txt_Sub = findViewById(R.id.txt_Subject);
        txt_address = findViewById(R.id.txt_address);
        txt_password = findViewById(R.id.txt_password);
        txt_email = findViewById(R.id.txt_email);
        txt_Hotline = findViewById(R.id.txt_mobileNo);

        db = new DBHelper(this);

        Log.v("InsEmailBLAAAAAAAAA", Teachermail);

        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHhhh");
        Teacher teacher = db.showTeacherDetails(Teachermail);

        txt_Name.setText(teacher.getFullName());
        txt_Sub.setText(teacher.getSubject());
        txt_address.setText(teacher.getAddress());
        txt_email.setText(teacher.getEmail());
        txt_password.setText(teacher.getPassword());
        txt_Hotline.setText(teacher.getMobileNo());
    }

    public void updateTeacher(View view){

        txt_Name = findViewById(R.id.txt_fName);
        txt_Sub = findViewById(R.id.txt_Subject);
        txt_address = findViewById(R.id.txt_address);
        txt_password = findViewById(R.id.txt_password);

        txt_Hotline = findViewById(R.id.txt_mobileNo);
        db = new DBHelper(this);

        Teacher T1=new Teacher();
        stxt_Name = txt_Name.getText().toString();
        T1.setFullName(stxt_Name);

        stxt_Sub = txt_Sub.getText().toString();
        T1.setSubject(stxt_Sub);

        stxt_address = txt_address.getText().toString();
        T1.setAddress(stxt_address);

        stxt_password = txt_password.getText().toString();
        T1.setPassword(stxt_password);

        stxt_Hotline = txt_Hotline.getText().toString();
        T1.setMobileNo(stxt_Hotline);




        //stdPhoneNoUI = txt_phoneNo.getText().toString();
        //std.setMobileNo(Integer.parseInt(stdPhoneNoUI));



        System.out.println(Teachermail);
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHhhh");
        boolean status=db.updatesTeacher(Teachermail,T1);

        if(status == true){

            Toast.makeText(getApplicationContext(),"Updating Success",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), TeacherLogin.class));



        }else{

            Toast.makeText(getApplicationContext(),"Updating failed",Toast.LENGTH_LONG).show();

        }

    }

    public void deleteTeacher(View view){
        int result = db.deleteTeacher(Teachermail);
        if(result == 1){
            Toast.makeText(getApplicationContext(),"Deleting Success",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), DirectPage.class));

        }else{
            Toast.makeText(getApplicationContext(),"Deleting  failed",Toast.LENGTH_LONG).show();

        }

    }
}
