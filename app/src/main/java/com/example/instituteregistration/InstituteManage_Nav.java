package com.example.instituteregistration;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import com.example.instituteregistration.Database.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;

public class InstituteManage_Nav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    String Insemail;
    DBHelper db = new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_manage__nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();


        String temp = intent.getStringExtra("email");

        this.Insemail = temp;

        Log.v("NavigationEmail", Insemail);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("Institute Dashboard");


        Bundle bundle = new Bundle();
        bundle.putString("email", Insemail);


        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        fragment = new InstituteDashboardFrag();
        fragment.setArguments(bundle);

        ft.replace((R.id.FragAreaIns), fragment);
        ft.commit();


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
        getMenuInflater().inflate(R.menu.institute_manage__nav, menu);
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

            AlertDialog.Builder a_builder = new AlertDialog.Builder(this);
            a_builder.setMessage("Do you want to Da Activate the Account ? All your data will be lost!")
                    .setCancelable(false)
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            int result = db.deleteInstitute(Insemail);
                            if(result == 1){
                                Toast.makeText(getApplicationContext(),"Account De Activated",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(), DirectPage.class));

                            }else{
                                Toast.makeText(getApplicationContext(),"Something Avoid the De Activation",Toast.LENGTH_LONG).show();

                            }
                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }) ;
            AlertDialog alert = a_builder.create();
            alert.setTitle("De Activate Account");
            alert.show();


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Bundle bundle = new Bundle();
        bundle.putString("email", Insemail);


        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_ClassesIns) {

            startActivity(new Intent(getApplicationContext(), InstituteStudentListViewer.class));

//            fragment= new InstituteDashboardFrag();
//            fragment.setArguments(bundle);
//
//            ft.replace((R.id.FragAreaIns),fragment);
//            ft.commit();


        } else if (id == R.id.nav_StaffManageIns) {

            startActivity(new Intent(getApplicationContext(), InstituteTeacherListViewer.class));

//            fragment= new InstituteDashboardFrag();
//            fragment.setArguments(bundle);
//
//            ft.replace((R.id.FragAreaIns),fragment);
//            ft.commit();

        } else if (id == R.id.nav_InsDash) {

            fragment = new InstituteDashboardFrag();
            fragment.setArguments(bundle);

            ft.replace((R.id.FragAreaIns), fragment);
            ft.commit();


        } else if (id == R.id.nav_InsProfile) {


            fragment = new InstituteProfile();
            fragment.setArguments(bundle);
            ft.replace((R.id.FragAreaIns), fragment);
            ft.commit();


        } else if (id == R.id.nav_LogOtIns) {


            Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, DirectPage.class);
            startActivity(i);

        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //    public void changeFrame(View view){


    public void btn_addClass(View view) {
//        startActivity(new Intent(getApplicationContext(), AddClass.class));
    }

    public void btn_viewClass(View view) {
        startActivity(new Intent(getApplicationContext(), ViewClass.class));
    }

//    public void changeFrame(View view){

//        Fragment fr;
//
//        if(view==findViewById(R.id.nav_InsProfile)){
//
//            fr = new InstituteProfile();
//
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction ft= fragmentManager.beginTransaction();
//            ft.replace((R.id.FragAreaIns),fragment);
//
//        }
//
//
//    }


}


