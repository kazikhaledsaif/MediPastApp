package com.saaifuuu.medipastapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.saaifuuu.medipastapp.Database.DoctorDBSource;
import com.saaifuuu.medipastapp.POJO.Doctor;
import com.saaifuuu.medipastapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateDoctorFrag extends Fragment {


    private DoctorDBSource doctorDBSource ;
    private EditText nameET,detailsET,apptET,phoneET,emailET;
    private int value;
    public UpdateDoctorFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_update_doctor, container, false);
        value = getArguments().getInt("id");
        setHasOptionsMenu(true);
        doctorDBSource = new DoctorDBSource(getActivity());
        Doctor doctor = doctorDBSource.getDoctorById(value);
        nameET = v.findViewById(R.id.updoctorNameET);
        detailsET = v.findViewById(R.id.updoctorDetailsET);
        apptET = v.findViewById(R.id.updoctorAppET);
        phoneET = v.findViewById(R.id.updoctorPhoneET);
        emailET = v.findViewById(R.id.updoctorEmailET);

        nameET.setText(doctor.getDoctorName());
        detailsET.setText(doctor.getDoctorDetails());
        apptET.setText(doctor.getDoctorAppoinment());
        phoneET.setText(doctor.getDoctorPhone());
        emailET.setText(doctor.getDoctorEmail());
        return v;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {

            String name= nameET.getText().toString();
            String details= detailsET.getText().toString();
            String appt= apptET.getText().toString();
            String phone= phoneET.getText().toString();
            String email= emailET.getText().toString();
            if (!name.isEmpty() &&!details.isEmpty() &&!appt.isEmpty() &&!phone.isEmpty() &&!email.isEmpty() ){
                Doctor doctor = new Doctor(value,name,details,appt,phone,email);
                boolean status = doctorDBSource.updateDoctor(doctor);
                if(status){
                    Toast.makeText(getActivity(), "Updated", Toast.LENGTH_SHORT).show();
                    nameET.setText("");
                    detailsET.setText("");
                    apptET.setText("");
                    phoneET.setText("");
                    emailET.setText("");

                }
                else
                {
                    Toast.makeText(getActivity(), "not Updated", Toast.LENGTH_SHORT).show();

                }
            }

            else{
                Toast.makeText(getActivity(), "Enter All info", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }



}
