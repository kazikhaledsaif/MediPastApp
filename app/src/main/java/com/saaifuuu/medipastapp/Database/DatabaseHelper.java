package com.saaifuuu.medipastapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME   = "medipast";
    public static final int DATABASE_VERSION   = 1;
    // Doctors Table
    public static final String TABLE_DOCTOR   = "tb_doctor";
    public static final String DOC_COL_ID   = "doc_id";
    public static final String DOC_COL_NAME   = "doc_name";
    public static final String DOC_COL_DETAILS   = "doc_details";
    public static final String DOC_COL_APPOINMENT  = "doc_appt";
    public static final String DOC_COL_PHONE   = "doc_phone";
    public static final String DOC_COL_EMAIL   = "doc_email";

    public static final String CREATE_TABLE_DOCTOR   =

            "CREATE TABLE "+TABLE_DOCTOR+"("+
            DOC_COL_ID+" INTEGER PRIMARY KEY, "+
            DOC_COL_NAME+ " TEXT, "+
            DOC_COL_DETAILS+ " TEXT, "+
            DOC_COL_APPOINMENT+ " TEXT, "+
            DOC_COL_PHONE+ " TEXT, "+
            DOC_COL_EMAIL+ " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       // sqLiteDatabase.execSQL("CREATE TABLE tbl_doctor ( doc_id INTEGER PRIMARY KEY, doc_name TEXT, doc_details TEXT, doc_appt TEXT, doc_phone TEXT, doc_email TEXT);");
        sqLiteDatabase.execSQL(CREATE_TABLE_DOCTOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
