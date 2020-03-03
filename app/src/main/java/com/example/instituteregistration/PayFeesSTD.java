package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Payement;

public class PayFeesSTD extends AppCompatActivity {
    EditText txt_classCode,txt_month ;
    String stdClassCodeUI,stdMonthUI;
    DBHelper db;
    String stdemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_fees_std);
        getSupportActionBar().setTitle("Pay Fees");

        Intent intent = getIntent();
        stdemail=intent.getExtras().getString("email");
    }

    public void addPayments(View view){
        txt_classCode= findViewById(R.id.txt_classCode);
        txt_month = findViewById(R.id.txt_month);
        db = new DBHelper(this);

        Payement payement=new Payement();
        stdClassCodeUI = txt_classCode.getText().toString();
        payement.setClassCode(stdClassCodeUI);

        stdMonthUI = txt_month.getText().toString();
        payement.setMonth(stdMonthUI);

        payement.setStdMail(stdemail);
        System.out.println(stdemail);
        boolean status = db.addPayDetails(payement);

        if(status == true){

            Toast.makeText(getApplicationContext(),"Fees Adding Success",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),NewStudentNavigation.class));

        }else{

            Toast.makeText(getApplicationContext(),"Fees Adding false",Toast.LENGTH_LONG).show();

        }
    }
}
