package com.example.instituteregistration;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instituteregistration.Database.DBHelper;
import com.example.instituteregistration.Demo.Institute;
import com.example.instituteregistration.Demo.Student;


public class InstituteProfile extends Fragment {


    TextView txt_Name, txt_password, txt_Manager, txt_address, txt_email, txt_Hotline, txt_website, txt_Desc;
    EditText etxt_Name, etxt_password, etxt_Manager, etxt_address, etxt_email, etxt_Hotline, etxt_website, etxt_Desc;
    String stxt_Name, stxt_password, stxt_Manager, stxt_address, stxt_email, stxt_Hotline, stxt_website, stxt_Desc;
    String n, p, m, a, e, h, w, d;
    DBHelper db;
    String Insemail;

    Institute ins;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Insemail = getArguments().getString("email");
        ((InstituteManage_Nav) getActivity()).getSupportActionBar().setTitle(R.string.institute_profileInsNAv);

        View view = inflater.inflate(R.layout.fragment_institute_profile, container, false);
        final Button Edit = (Button) view.findViewById(R.id.InsProfEdit);
        final Button Save = (Button) view.findViewById(R.id.InsProfSave);


        ins = new Institute();


        txt_Name = view.findViewById(R.id.InsName);
        txt_Manager = view.findViewById(R.id.InsMag);
        txt_address = view.findViewById(R.id.InsAddr);
        txt_password = view.findViewById(R.id.InsPassword);
        txt_website = view.findViewById(R.id.InsWeb);
        txt_Desc = view.findViewById(R.id.InsDesc);
        txt_Hotline = view.findViewById(R.id.InsHotL);
        txt_email = view.findViewById(R.id.InsEmail);


        db = new DBHelper(getActivity());

        Log.v("InsEmailBLAAAAAAAAA", Insemail);

        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHhhh");
        Institute institute = db.showInsDetails(Insemail);

        txt_Name.setText(institute.getName());
        txt_Manager.setText(institute.getManager());
        txt_address.setText(institute.getAddress());
        txt_email.setText(institute.getEmail());
        txt_password.setText(institute.getPassword());
        txt_website.setText(institute.getWebsite());
        txt_Desc.setText(institute.getDescription());
        txt_Hotline.setText(institute.getHotline());


        etxt_Name = view.findViewById(R.id.editInsName);
        etxt_Manager = view.findViewById(R.id.editInsMng);
        etxt_address = view.findViewById(R.id.editAddr);
        etxt_password = view.findViewById(R.id.editPassword);
        etxt_website = view.findViewById(R.id.editWeb);
        etxt_Desc = view.findViewById(R.id.editDesc);
        etxt_Hotline = view.findViewById(R.id.editHotL);

        etxt_Name.setText(institute.getName());
        etxt_Manager.setText(institute.getManager());
        etxt_address.setText(institute.getAddress());

        etxt_password.setText(institute.getPassword());
        etxt_website.setText(institute.getWebsite());
        etxt_Desc.setText(institute.getDescription());
        etxt_Hotline.setText(institute.getHotline());

        n = txt_Name.getText().toString();
        m = txt_Manager.getText().toString();
        a = txt_address.getText().toString();
        p = txt_password.getText().toString();
        w = txt_website.getText().toString();
        h = txt_Hotline.getText().toString();

        System.out.println("Ins Name is:" + n);
        System.out.println(h);


        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Save.setVisibility(View.VISIBLE);
                Edit.setVisibility(View.GONE);

                etxt_Name.setVisibility(View.VISIBLE);
                etxt_Manager.setVisibility(View.VISIBLE);
                etxt_address.setVisibility(View.VISIBLE);
                etxt_password.setVisibility(View.VISIBLE);
                etxt_website.setVisibility(View.VISIBLE);
                etxt_Desc.setVisibility(View.VISIBLE);
                etxt_Hotline.setVisibility(View.VISIBLE);


                txt_Name.setVisibility(View.GONE);
                txt_Manager.setVisibility(View.GONE);
                txt_address.setVisibility(View.GONE);
                txt_password.setVisibility(View.GONE);
                txt_website.setVisibility(View.GONE);
                txt_Desc.setVisibility(View.GONE);
                txt_Hotline.setVisibility(View.GONE);


            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Edit.setVisibility(View.VISIBLE);
                Save.setVisibility(View.GONE);

                etxt_Name.setVisibility(View.GONE);
                etxt_Manager.setVisibility(View.GONE);
                etxt_address.setVisibility(View.GONE);
                etxt_password.setVisibility(View.GONE);
                etxt_website.setVisibility(View.GONE);
                etxt_Desc.setVisibility(View.GONE);
                etxt_Hotline.setVisibility(View.GONE);


                txt_Name.setVisibility(View.VISIBLE);
                txt_Manager.setVisibility(View.VISIBLE);
                txt_address.setVisibility(View.VISIBLE);
                txt_password.setVisibility(View.VISIBLE);
                txt_website.setVisibility(View.VISIBLE);
                txt_Desc.setVisibility(View.VISIBLE);
                txt_Hotline.setVisibility(View.VISIBLE);

                db = new DBHelper(getActivity());





                stxt_Name = etxt_Name.getText().toString();


                ins.setName(stxt_Name);


                stxt_Manager = etxt_Manager.getText().toString();


                ins.setManager(stxt_Manager);




                ins.setEmail(Insemail);

                stxt_address = etxt_address.getText().toString();


                ins.setAddress(stxt_address);


                stxt_password = etxt_password.getText().toString();


                ins.setPassword(stxt_password);


                stxt_website = etxt_website.getText().toString();


                ins.setWebsite(stxt_website);


                stxt_Desc = etxt_Desc.getText().toString();


                ins.setDescription(stxt_Desc);


                stxt_Hotline = etxt_Hotline.getText().toString();


                ins.setHotline(stxt_Hotline);


                boolean status = db.updatesInstitute(Insemail, ins);

                if (status == true) {

                    Toast.makeText(getActivity(), "Institute Updated Successfully", Toast.LENGTH_LONG).show();

                    Institute institute = db.showInsDetails(Insemail);
                    
                    txt_Name.setText(institute.getName());
                    txt_Manager.setText(institute.getManager());
                    txt_address.setText(institute.getAddress());
                    txt_email.setText(institute.getEmail());
                    txt_password.setText(institute.getPassword());
                    txt_website.setText(institute.getWebsite());
                    txt_Desc.setText(institute.getDescription());
                    txt_Hotline.setText(institute.getHotline());


                } else {

                    Toast.makeText(getActivity(), "Update failed", Toast.LENGTH_LONG).show();

                }


            }
        });

        return view;

    }

//    public void UpdateInstitute(View view) {
//
//        etxt_Name = view.findViewById(R.id.editInsName);
//        etxt_Manager = view.findViewById(R.id.editInsMng);
//        etxt_address = view.findViewById(R.id.editAddr);
//        etxt_password = view.findViewById(R.id.editPassword);
//        etxt_website = view.findViewById(R.id.editWeb);
//        etxt_Desc = view.findViewById(R.id.editDesc);
//        etxt_Hotline = view.findViewById(R.id.editHotL);
//
//
//    }
//}
}