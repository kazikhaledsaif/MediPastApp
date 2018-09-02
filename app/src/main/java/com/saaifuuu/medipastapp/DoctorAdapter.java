package com.saaifuuu.medipastapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.saaifuuu.medipastapp.POJO.Doctor;

import java.util.ArrayList;

/**
 * Created by BITM Trainer 601 on 12/10/2017.
 */

public class DoctorAdapter extends ArrayAdapter<Doctor> {

    private Context context;
    private ArrayList<Doctor> doctors;
    public DoctorAdapter(@NonNull Context context, ArrayList<Doctor> doctors) {
        super(context, R.layout.doctors_row, doctors);
        this.context = context;
        this.doctors = doctors;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.doctors_row,parent,false);
        TextView nameTV = convertView.findViewById(R.id.rowDoctorNameTV);
        nameTV.setText(doctors.get(position).getDoctorName());
        TextView detailsTV = convertView.findViewById(R.id.rowDoctorDetailsTV);
        detailsTV.setText(doctors.get(position).getDoctorDetails());
        TextView apptTV = convertView.findViewById(R.id.rowDoctorApptTV);
        apptTV.setText(doctors.get(position).getDoctorAppoinment());
        TextView phoneTV = convertView.findViewById(R.id.rowDoctoPhoneTV);
        phoneTV.setText(doctors.get(position).getDoctorPhone());
        TextView emailTV = convertView.findViewById(R.id.rowDoctoEmailTV);
        emailTV.setText(doctors.get(position).getDoctorName());
        return convertView;
    }

    public  void addDoctor (){
        notifyDataSetChanged();
    }
}
