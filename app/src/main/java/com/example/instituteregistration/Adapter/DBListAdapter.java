package com.example.instituteregistration.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.instituteregistration.Demo.Teacher;
import com.example.instituteregistration.R;

import java.util.ArrayList;

public class DBListAdapter extends BaseAdapter {

    Context context;

    ArrayList<Teacher> arrayList;

    public DBListAdapter(){}

    public DBListAdapter(Context context,ArrayList<Teacher> arrayList){

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

            convertView = inflater.inflate(R.layout.list_item_teacher,null);
            TextView tname = (TextView)convertView.findViewById(R.id.ListTName);
            TextView sub = (TextView)convertView.findViewById(R.id.ListSub);
            TextView email = (TextView)convertView.findViewById(R.id.ListEmail);
            TextView Tel = (TextView)convertView.findViewById(R.id.ListSTel);
            TextView Add = (TextView)convertView.findViewById(R.id.ListAddress);

            Teacher teacher = arrayList.get(position);

            tname.setText(teacher.getFullName());
            sub.setText(teacher.getSubject());
            email.setText(teacher.getEmail());

            Tel.setText(teacher.getMobileNo());

            Add.setText(teacher.getAddress());




        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }




}
