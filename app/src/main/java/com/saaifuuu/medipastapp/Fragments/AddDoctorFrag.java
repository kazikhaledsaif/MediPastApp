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
import com.saaifuuu.medipastapp.DoctorAdapter;
import com.saaifuuu.medipastapp.POJO.Doctor;
import com.saaifuuu.medipastapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddDoctorFrag extends Fragment {

    private DoctorDBSource doctorDBSource ;
    private  EditText nameET,detailsET,apptET,phoneET,emailET;

    public AddDoctorFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_doctor, container, false);
        setHasOptionsMenu(true);
        doctorDBSource = new DoctorDBSource(getActivity());
        nameET = v.findViewById(R.id.doctorNameET);
        detailsET = v.findViewById(R.id.doctorDetailsET);
        apptET = v.findViewById(R.id.doctorAppET);
        phoneET = v.findViewById(R.id.doctorPhoneET);
        emailET = v.findViewById(R.id.doctorEmailET);
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
                Doctor doctor = new Doctor(name,details,appt,phone,email);
                boolean status = doctorDBSource.insertDoctor(doctor);
                if(status){
                    Toast.makeText(getActivity(), "Inserted", Toast.LENGTH_SHORT).show();
                    nameET.setText("");
                    detailsET.setText("");
                    apptET.setText("");
                    phoneET.setText("");
                    emailET.setText("");


                }
                else
                {
                    Toast.makeText(getActivity(), "not Inserted", Toast.LENGTH_SHORT).show();

                }
            }

            else{
                Toast.makeText(getActivity(), "Enter All info", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }


}
