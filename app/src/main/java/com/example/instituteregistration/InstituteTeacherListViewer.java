package com.example.instituteregistration;

import android.os.Bundle;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.instituteregistration.Adapter.DBListAdapter;
import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Teacher;

import java.util.ArrayList;

public class InstituteTeacherListViewer extends AppCompatActivity {


    DBHelper db;
    ListView listView;
    ArrayList<Teacher> arrayList;
    DBListAdapter dbListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.institute_list_viewer);
        getSupportActionBar().setTitle(R.string.staff_managerNav);


        listView = (ListView) findViewById(R.id.list);

        db= new DBHelper(this);

        arrayList = new ArrayList<>();

        loadDataInListView();





    }

    private void loadDataInListView(){

        arrayList=db.getAllTeacherData();

        dbListAdapter = new DBListAdapter(this,arrayList);
        listView.setAdapter(dbListAdapter);
        dbListAdapter.notifyDataSetChanged();


    }



}

