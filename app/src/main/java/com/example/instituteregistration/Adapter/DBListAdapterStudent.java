package com.example.instituteregistration.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.instituteregistration.Demo.Student;

import com.example.instituteregistration.R;

import java.util.ArrayList;

public class DBListAdapterStudent extends BaseAdapter {

    Context context;

    ArrayList<Student> arrayList;

    public DBListAdapterStudent(){}

    public DBListAdapterStudent(Context context,ArrayList<Student> arrayList){

        this.context=context;

        this.arrayList=arrayList;

    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.list_item_student,null);

        TextView tname = (TextView)convertView.findViewById(R.id.ListName);
        TextView ln = (TextView)convertView.findViewById(R.id.ListLname);
        TextView email = (TextView)convertView.findViewById(R.id.ListEmail);
        TextView Add = (TextView)convertView.findViewById(R.id.ListAddress);

        Student student = arrayList.get(position);

        tname.setText(student.getfName());
        ln.setText(student.getlName());
        email.setText(student.getEmail());
        Add.setText(student.getAddress());




        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }




}
