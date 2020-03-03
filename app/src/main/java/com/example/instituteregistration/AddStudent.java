package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        getSupportActionBar().setTitle("Select Class");
    }
    public void sendRequest(View view) {
        Toast.makeText(getApplicationContext(), "Request Send,Wait for the response!", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(),NewStudentNavigation.class));
    }
}
