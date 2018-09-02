package com.saaifuuu.medipastapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.saaifuuu.medipastapp.POJO.Doctor;

import java.util.ArrayList;

public class DoctorDBSource {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public DoctorDBSource(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void open () {database = databaseHelper.getWritableDatabase();}

    public void close () {database.close();}

    public boolean insertDoctor(Doctor doctor){
        this.open();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.DOC_COL_NAME,doctor.getDoctorName());
        values.put(DatabaseHelper.DOC_COL_DETAILS,doctor.getDoctorDetails());
        values.put(DatabaseHelper.DOC_COL_APPOINMENT,doctor.getDoctorAppoinment());
        values.put(DatabaseHelper.DOC_COL_PHONE,doctor.getDoctorPhone());
        values.put(DatabaseHelper.DOC_COL_EMAIL,doctor.getDoctorEmail());
        long insertedRow =  database.insert(DatabaseHelper.TABLE_DOCTOR,null,values);
        this.close();
        if(insertedRow>0){
            return true;
        }else
        {
            return false;
        }
    }
    public ArrayList<Doctor> getAllDoctors(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        this.open();
        //db.rawQuery("select * from "+EmployeeDatabaseHelper.EMPLOYEE_TABLE,null);
        Cursor cursor = database.query(DatabaseHelper.TABLE_DOCTOR,null,null,null,null,null,null);

        cursor.moveToFirst();
        if(cursor != null || cursor.getCount() > 0){

            do {
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.DOC_COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_NAME));
                String details = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_DETAILS));
                String appt = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_APPOINMENT));
                String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_EMAIL));
                String phone = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_PHONE));
                doctors.add(new Doctor(id,name,details,appt,phone,email));
            }while (cursor.moveToNext());
        }
        this.close();
        cursor.close();
        return doctors;
    }
    public Doctor getDoctorById(int id){
        this.open();
        Doctor doctor = null;
        Cursor cursor = database.query(DatabaseHelper.TABLE_DOCTOR,
                null,DatabaseHelper.DOC_COL_ID+"="+id,null,null,null,null);
        if(cursor != null || cursor.getCount() > 0){
            cursor.moveToFirst();
            int eid = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.DOC_COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_NAME));
            String details = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_DETAILS));
            String appt = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_APPOINMENT));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_EMAIL));
            String phone = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DOC_COL_PHONE));
            doctor = new Doctor(eid,name,details,appt,email,phone);
        }
        this.close();
        return doctor;
    }
    public boolean updateDoctor(Doctor doctor){
        this.open();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.DOC_COL_NAME,doctor.getDoctorName());
        values.put(DatabaseHelper.DOC_COL_DETAILS,doctor.getDoctorDetails());
        values.put(DatabaseHelper.DOC_COL_APPOINMENT,doctor.getDoctorAppoinment());
        values.put(DatabaseHelper.DOC_COL_PHONE,doctor.getDoctorPhone());
        values.put(DatabaseHelper.DOC_COL_EMAIL,doctor.getDoctorEmail());
        int updatedValue = database.update(DatabaseHelper.TABLE_DOCTOR,values,DatabaseHelper.DOC_COL_ID+"="+doctor.getDoctorId(),null);
        this.close();
        if(updatedValue > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteDoctor(int eid){
        this.open();
        int deletedRow = database.delete(DatabaseHelper.TABLE_DOCTOR,DatabaseHelper.DOC_COL_ID+"="+eid,null);
        this.close();
        if(deletedRow > 0){
            return true;
        }else{
            return false;
        }

    }
}
