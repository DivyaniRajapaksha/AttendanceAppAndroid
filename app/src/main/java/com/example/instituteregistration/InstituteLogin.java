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

public class InstituteLogin extends AppCompatActivity {


    EditText txt_Name,txt_password,txt_Manager,txt_address,txt_email,txt_Hotline,txt_website,txt_Desc ;
    String stxt_Name,stxt_password,stxt_Manager,stxt_address,stxt_email,stxt_Hotline,stxt_website,stxt_Desc;
    DBHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_login);
        getSupportActionBar().setTitle("Institute Login");

        Button clickreg = (Button) findViewById(R.id.InsLoginRegB);
        Button clicklog = (Button) findViewById(R.id.btnlogin);

        txt_Name= findViewById(R.id.reginsName);
        txt_Manager = findViewById(R.id.reginsManager);
        txt_email = findViewById(R.id.reginsEmail);
        txt_address = findViewById(R.id.reginsAddress);
        txt_password = findViewById(R.id.reginsPassword);
        txt_website = findViewById(R.id.reginsWebsite);
        txt_Desc = findViewById(R.id.reginsDescription);
        txt_Hotline = findViewById(R.id.reginsHotline);
        db = new DBHelper(this);


        clickreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InstituteLogin.this, MainActivity.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Register Your Institute", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void login(View view){
        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);
        db = new DBHelper(this);

        stxt_email = txt_email.getText().toString();
        stxt_password= txt_password.getText().toString();
        boolean status=db.AuthenticateInstitute(stxt_email,stxt_password);

        if(status == true){



            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, InstituteManage_Nav.class);
            i.putExtra("email",stxt_email);

            Log.v("loginExtra",stxt_email);

            startActivity(i);



            System.out.println(stxt_email);


        }else{

            Toast.makeText(getApplicationContext(),"Login failed",Toast.LENGTH_LONG).show();

        }

    }
}
