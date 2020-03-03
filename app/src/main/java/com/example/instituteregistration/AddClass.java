package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Class;

public class AddClass extends AppCompatActivity {

    EditText txt_className,txt_startTime,txt_endTime,txt_subject,txt_grade,txt_date;
    String classNameUI,classStartTUI, classEndTUI, cName, cStrt, cEnd,classSubjectTUI,classdateUI,classGradeTUI;
    Boolean emptyTxtHolder;
    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        getSupportActionBar().setTitle("Add New Class");

        txt_className= findViewById(R.id.txtClassN);
        txt_startTime = findViewById(R.id.txtStartT);
        txt_endTime = findViewById(R.id.txtEndT);

        myDb = new DBHelper(this);
    }

    public boolean checkEmptyStatus(){

        cName = txt_className.getText().toString() ;
        cStrt = txt_startTime.getText().toString();
        cEnd = txt_endTime.getText().toString();
        if(TextUtils.isEmpty(cName) || TextUtils.isEmpty(cStrt) || TextUtils.isEmpty(cEnd)){

            emptyTxtHolder = false ;
            return emptyTxtHolder;

        }
        else {

            emptyTxtHolder = true ;
            return emptyTxtHolder;
        }
    }

    public void addClassInfo(View view) {
        if(checkEmptyStatus() == true) {

            txt_className = findViewById(R.id.txtClassN);
            txt_startTime = findViewById(R.id.txtStartT);
            txt_endTime = findViewById(R.id.txtEndT);
            txt_subject = findViewById(R.id.txt_subject);
            txt_grade = findViewById(R.id.txt_grade);
            txt_date = findViewById(R.id.txt_date);

            myDb = new DBHelper(this);

            Class cls = new Class();
            classNameUI = txt_className.getText().toString();
            cls.setClassName(classNameUI);

            classStartTUI = txt_startTime.getText().toString();
            cls.setStartTime(classStartTUI);

            classEndTUI = txt_endTime.getText().toString();
            cls.setEndTime(classEndTUI);

            classSubjectTUI = txt_subject.getText().toString();
            cls.setSubject(classSubjectTUI);

            classGradeTUI = txt_grade.getText().toString();
            cls.setGrade(classGradeTUI);

            classdateUI = txt_date.getText().toString();
            cls.setDate(classdateUI);

            boolean status = myDb.addClassInfo(cls);

            if (status == true) {

                Toast.makeText(getApplicationContext(), "Class added successfully!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), ViewClass.class));

            } else {

                Toast.makeText(getApplicationContext(), "Class adding failed!", Toast.LENGTH_LONG).show();

            }
        }
        else{
            Toast.makeText(AddClass.this, "Please fill all fields!", Toast.LENGTH_LONG).show();
        }

        /*public void emptyTxtField(){

            txt_className.getText().clear();

            txt_startTime.getText().clear();

            txt_endTime.getText().clear();

        }*/
    }


}
