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
import com.example.instituteregistration.Demo.Student;

public class MainActivity extends AppCompatActivity {


    EditText txt_Name,txt_password,txt_Manager,txt_address,txt_email,txt_Hotline,txt_website,txt_Desc,txt_Conp ;
    String stxt_Name,stxt_password,stxt_Manager,stxt_address,stxt_email,stxt_Hotline,stxt_website,stxt_Desc,e;
    DBHelper db;
    boolean status=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Register Institute");



        txt_Name= findViewById(R.id.reginsName);
        txt_Manager = findViewById(R.id.reginsManager);
        txt_email = findViewById(R.id.reginsEmail);
        txt_address = findViewById(R.id.reginsAddress);
        txt_password = findViewById(R.id.reginsPassword);
        txt_website = findViewById(R.id.reginsWebsite);
        txt_Desc = findViewById(R.id.reginsDescription);
        txt_Hotline = findViewById(R.id.reginsHotline);
        txt_Conp = findViewById(R.id.ConPassword);

        db = new DBHelper(this);


    }

    public void addInstituteInfo(View view){

        txt_Name= findViewById(R.id.reginsName);
        txt_Manager = findViewById(R.id.reginsManager);
        txt_email = findViewById(R.id.reginsEmail);
        txt_address = findViewById(R.id.reginsAddress);
        txt_password = findViewById(R.id.reginsPassword);
        txt_website = findViewById(R.id.reginsWebsite);
        txt_Desc = findViewById(R.id.reginsDescription);
        txt_Hotline = findViewById(R.id.reginsHotline);
        db = new DBHelper(this);


        String p,conp;

        p = txt_password.getText().toString();
        conp=txt_Conp.getText().toString();

        e =txt_email.getText().toString();
        Institute ins = new Institute();

        if(p.equals(conp)) {

            if(isValidEmail(e)){



            stxt_Name = txt_Name.getText().toString();
            ins.setName(stxt_Name);

            stxt_Manager = txt_Manager.getText().toString();
            ins.setManager(stxt_Manager);

            stxt_email = txt_email.getText().toString();
            ins.setEmail(stxt_email);

            stxt_address = txt_address.getText().toString();
            ins.setAddress(stxt_address);

            stxt_password = txt_password.getText().toString();
            ins.setPassword(stxt_password);

            stxt_website = txt_website.getText().toString();
            ins.setWebsite(stxt_website);

            stxt_Desc = txt_Desc.getText().toString();
            ins.setDescription(stxt_Desc);

            stxt_Hotline = txt_Hotline.getText().toString();
            ins.setHotline(stxt_Hotline);


            status = db.addInstituteInfo(ins);}

            else{

                Toast.makeText(getApplicationContext(),"Email Invalid",Toast.LENGTH_SHORT).show();
            }

        }else{

            Toast.makeText(getApplicationContext(),"Password MisMatch",Toast.LENGTH_SHORT).show();
            txt_Conp.setLinkTextColor(getResources().getColor(R.color.errorText));
            txt_password.setLinkTextColor(getResources().getColor(R.color.errorText));
            txt_password.setTextColor(getResources().getColor(R.color.errorText));
            txt_Conp.setTextColor(getResources().getColor(R.color.errorText));



        }

        if(status == true){

            Toast.makeText(getApplicationContext(),"Institute Registered Success",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), InstituteLogin.class));

        }else{

            Toast.makeText(getApplicationContext(),"Registration failed",Toast.LENGTH_LONG).show();

        }
    }

    public void btn_InsDashboard(View view) {
        startActivity(new Intent(getApplicationContext(), InstituteManage_Nav.class));
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }


}
