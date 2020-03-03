package com.example.instituteregistration;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class InstituteDashboardFrag extends Fragment {


    String Insemail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((InstituteManage_Nav) getActivity()).getSupportActionBar().setTitle(R.string.dashboard);

        View view = inflater.inflate(R.layout.fragment_institute_dashboard, container, false);

        Insemail = getArguments().getString("email");

        Button cclass= (Button) view.findViewById(R.id.Cclass);
        Button regStd= (Button) view.findViewById(R.id.RegStd);
        Button redTeacher= (Button) view.findViewById(R.id.AddTeacher);

        cclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddClass.class);


                i.putExtra("InsEmail",Insemail);
             startActivity(i);


            }
        });

        regStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), StudentReg.class);


                i.putExtra("InsEmail",Insemail);
                startActivity(i);


            }
        });
        redTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), RegTeacher.class);


                i.putExtra("InsEmail",Insemail);
                startActivity(i);


            }
        });




        return view;





    }


}
