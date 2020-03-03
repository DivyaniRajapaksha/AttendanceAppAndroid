package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DirectPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_page);
        getSupportActionBar().setTitle("Welcome");

        Button click = (Button) findViewById(R.id.instituteDirect);



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DirectPage.this, InstituteLogin.class);
                startActivity(i);

                
            }
        });

    }

    public void btn_mainPage(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void btn_teacher(View view) {

        startActivity(new Intent(getApplicationContext(), TeacherLogin.class));
    }
    public void btn_Studentr(View view) {

        startActivity(new Intent(getApplicationContext(), Login_Frm2.class));
    }

}
