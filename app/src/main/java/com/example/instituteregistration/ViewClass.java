package com.example.instituteregistration;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Database.UserMaster;
import com.example.instituteregistration.Demo.ListAdpter;


public class ViewClass extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    ListAdapter listAdapter ;
    ListView LISTVIEW;

    ArrayList<String> ID_Array;
    ArrayList<String> Name_Array;
    ArrayList<String> StrtTime_Array;
    ArrayList<String> EndTime_Array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class);
        getSupportActionBar().setTitle("View Class");

        LISTVIEW = (ListView) findViewById(R.id.listClass);

        ID_Array = new ArrayList<String>();

        Name_Array = new ArrayList<String>();

        StrtTime_Array = new ArrayList<String>();

        EndTime_Array = new ArrayList<String>();

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        DBHelper mydb = new DBHelper(this);

        ID_Array.clear();
        Name_Array.clear();
        StrtTime_Array.clear();
        EndTime_Array.clear();

        /*if (cursor.moveToFirst()) {
            do {

                ID_Array.add(cursor.getString(cursor.getColumnIndex(UserMaster.class.COLUMN_NAME_CLASSID)));

                Name_Array.add(cursor.getString(cursor.getColumnIndex(UserMaster.Class.COLUMN_NAME_CNAME)));

                StrtTime_Array.add(cursor.getString(cursor.getColumnIndex(UserMaster.Class.COLUMN_NAME_STARTTIME)));

                EndTime_Array.add(cursor.getString(cursor.getColumnIndex(UserMaster.Class.COLUMN_NAME_ENDTIME)));

            } while (cursor.moveToNext());
        }*/

        listAdapter = new ListAdpter(ViewClass.this,

                ID_Array,
                Name_Array,
                StrtTime_Array,
                EndTime_Array
        );

        LISTVIEW.setAdapter(listAdapter);

        cursor.close();
    }
}
    /*public void viewNxtClass(View view){

        TextView classN = (TextView) findViewById(R.id.classN);
        TextView classSt = (TextView)findViewById(R.id.classSt);
        TextView classEt = (TextView)findViewById(R.id.classEt);



        if(results.moveToNext()){
            classN.setText(results.getString(1));
            classSt.setText(results.getString(2));
            classEt.setText(results.getString(3));
        }*/




