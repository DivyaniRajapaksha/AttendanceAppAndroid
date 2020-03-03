package com.example.instituteregistration;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListItemClass> {






    public ListAdapter(Activity context, ArrayList<ListItemClass> listItemClasses){

        super(context,0, listItemClasses);


    }

    public ListAdapter(Activity context, ArrayList<ListItemClass> listItemClasses, int color){

        super(context,0, listItemClasses);


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_class, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        ListItemClass currentListItemClass = getItem(position);

        // Find the TextView in the list_item_class.xmlss.xml layout with the ID version_name
        TextView className = (TextView) listItemView.findViewById(R.id.ListClassName);
        TextView classEmail = (TextView) listItemView.findViewById(R.id.ListEmail);
        TextView classTel = (TextView) listItemView.findViewById(R.id.ListSTel);
        TextView classSTime = (TextView) listItemView.findViewById(R.id.ListSTime);
        TextView classTTime = (TextView) listItemView.findViewById(R.id.ListTTime);
        TextView classSub = (TextView) listItemView.findViewById(R.id.ListSub);
        TextView classTeacher = (TextView) listItemView.findViewById(R.id.ListTeacher);



        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView


//        // Find the TextView in the list_item_class.xmlss.xml layout with the ID version_number
//        TextView TransTextView = (TextView) listItemView.findViewById(R.id.normalText);
//        // Get the version number from the current AndroidFlavor object and
//        // set this text on the number TextView
//        TransTextView.setText(currentListItemClass.getDef());
//
//
//        ImageView ImageRes =(ImageView) listItemView.findViewById(R.id.image1);
//
//        final Button showB =(Button) listItemView.findViewById(R.id.show);
//        final Button hideB =(Button) listItemView.findViewById(R.id.hide);
//        final EditText details = (EditText) listItemView.findViewById(R.id.editText) ;
//
//        showB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                hideB.setVisibility(View.VISIBLE);
//                showB.setVisibility(View.GONE);
//                details.setVisibility(View.VISIBLE);
//
//            }
//        });
//
//        hideB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                showB.setVisibility(View.VISIBLE);
//                hideB.setVisibility(View.GONE);
//                details.setVisibility(View.GONE);
//
//
//
//            }
//        });
//
//
//        if(currentListItemClass.hasImage()){
//            ImageRes.setImageResource(currentListItemClass.getResId());
//
//
//            ImageRes.setVisibility(View.VISIBLE);
//
//        }
//        else{
//
//            ImageRes.setVisibility(View.GONE);
//        }
//        int col = ContextCompat.getColor(getContext(), ColorResId);
//
//        View lay = listItemView.findViewById(R.id.Rel);
//        lay.setBackgroundColor(col);
//
//
//
//
//        // Return the whole list item layout (containing 2 TextViews and an ImageView)
//        // so that it can be shown in the ListView
        return listItemView;
    }}

