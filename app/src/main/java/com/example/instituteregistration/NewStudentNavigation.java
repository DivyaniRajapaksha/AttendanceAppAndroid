package com.example.instituteregistration;

import android.content.Intent;
import android.os.Bundle;

import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class NewStudentNavigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText txt_fName,txt_password,txt_lName,txt_address,txt_email,txt_phoneNo,txt_Conpassword ;
    String stdfNameUI,stdPasswordUI,stdlNameUI,stdEmailUI,stdAddressUI,stdPhoneNoUI;
    DBHelper db;
    String stdemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("Student Profile");

        Intent intent = getIntent();
        stdemail=intent.getExtras().getString("email");


        txt_fName= findViewById(R.id.txt_fName);
        txt_lName = findViewById(R.id.txt_lName);
        txt_email = findViewById(R.id.txt_email);
        txt_address = findViewById(R.id.txt_address);
        txt_password = findViewById(R.id.txt_password);
        db = new DBHelper(this);
        System.out.println(stdemail);
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHhhh");
        Student std=db.showDetails(stdemail);

        txt_fName.setText(std.getfName());
        txt_lName.setText(std.getlName());
        txt_address.setText(std.getAddress());
        txt_email.setText(std.getEmail());
        txt_password.setText(std.getPassword());

        System.out.println(std.getfName());
        System.out.println(std.getlName());
        System.out.println(std.getAddress());
        System.out.println(std.getEmail());
        System.out.println(std.getPassword());


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_student_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(getApplicationContext(),Login_Frm2.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_MyClassesSTD) {
            startActivity(new Intent(getApplicationContext(),ViewClass.class));


        } else if (id == R.id.nav_MarkAttendSTDNav) {
            startActivity(new Intent(getApplicationContext(),Map_Std.class));

        } else if (id == R.id.nav_FeesSTDNav) {
            Intent j = new Intent(this, PayFeesSTD.class);
            j.putExtra("email",stdemail);
            //startActivity(new Intent(getApplicationContext(),PayFeesSTD.class));
            startActivity(j);



        } else if (id == R.id.nav_NewClassTDNav) {
        startActivity(new Intent(getApplicationContext(),AddStudent.class));
        }else if (id == R.id.nav_profileSTDNav) {
            startActivity(new Intent(getApplicationContext(),NewStudentNavigation.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void updateStudent(View view){

        txt_fName= findViewById(R.id.txt_fName);
        txt_lName = findViewById(R.id.txt_lName);
        txt_email = findViewById(R.id.txt_email);
        txt_address = findViewById(R.id.txt_address);
        txt_password = findViewById(R.id.txt_password);
        db = new DBHelper(this);

        Student std=new Student();
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

        stdPasswordUI= txt_password.getText().toString();
        std.setPassword(stdPasswordUI);

        System.out.println(stdemail);
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHhhh");
        boolean status=db.updatestudent(stdemail,std);

        if(status == true){

            Toast.makeText(getApplicationContext(),"Updating Success",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), Login_Frm2.class));



        }else{

            Toast.makeText(getApplicationContext(),"Updating false",Toast.LENGTH_LONG).show();

        }

    }

    public void deleteStudent(View view){
        int result = db.deleteStudent(stdemail);
        if(result == 1){
            Toast.makeText(getApplicationContext(),"Deleting Success",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), DirectPage.class));

        }else{
            Toast.makeText(getApplicationContext(),"Deleting  false",Toast.LENGTH_LONG).show();

        }

    }
}
