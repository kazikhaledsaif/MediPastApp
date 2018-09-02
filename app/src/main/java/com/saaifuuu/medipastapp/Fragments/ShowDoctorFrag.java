package com.saaifuuu.medipastapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.saaifuuu.medipastapp.Database.DoctorDBSource;
import com.saaifuuu.medipastapp.DoctorAdapter;
import com.saaifuuu.medipastapp.POJO.Doctor;
import com.saaifuuu.medipastapp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowDoctorFrag extends Fragment {

   private ListView doctorLV;

   private int id=0;
    private DoctorDBSource databaseSource;
    private DoctorAdapter doctorAdapter;
    private ArrayList<Doctor> doctors;
    public ShowDoctorFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_show_doctor, container, false);
        databaseSource = new DoctorDBSource(getActivity());
        doctors = new ArrayList<>();
        doctors= databaseSource.getAllDoctors();

        try {
            doctorLV = v.findViewById(R.id.doctorList);
            doctorAdapter = new DoctorAdapter(getActivity(),doctors);
            doctorLV.setAdapter(doctorAdapter);
            doctorLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                    UpdateDoctorFrag updateDoctorFrag = new UpdateDoctorFrag();
                    Bundle args = new Bundle();
                    args.putInt("id", pos+1);
                    updateDoctorFrag.setArguments(args);
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.screen_area,updateDoctorFrag);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });


        }
        catch (Exception e){
            Toast.makeText(getActivity(),   e.toString(), Toast.LENGTH_SHORT).show();
        }

        return v;
    }

}
