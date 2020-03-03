package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;


import com.example.instituteregistration.Adapter.DBListAdapterStudent;
import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Student;


import java.util.ArrayList;

public class InstituteStudentListViewer extends AppCompatActivity {


    ListAdapter adapter;
    DBHelper db;
    ListView listView;
    ArrayList<Student> arrayList;
    DBListAdapterStudent dbListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_student_list_viewer);
        getSupportActionBar().setTitle(R.string.student_Manager);

        listView = (ListView) findViewById(R.id.list);

        db= new DBHelper(this);

        arrayList = new ArrayList<>();

        loadDataInListView();
    }

    private void loadDataInListView(){

        arrayList=db.getAllStudentData();

        dbListAdapter = new DBListAdapterStudent(this,arrayList);
        listView.setAdapter(dbListAdapter);
        dbListAdapter.notifyDataSetChanged();


    }

}
