package com.example.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHendler extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_kampus";
    private static final String tb_mahasiswa = "tb_mahasiswa";

    private static final String tb_mahasiswa_id = "id";
    private static final String tb_mahasiswa_nama = "nama";
    private static final String tb_mahasiswa_kelas = "kelas";

    private static final String CREATE_TABLE_MAHASISWA = "CREATE TABLE " + tb_mahasiswa + "("
             + tb_mahasiswa_id + "INTEGER PRIMARY KEY ,"
             + tb_mahasiswa_nama + "TEXT,"
             + tb_mahasiswa_kelas + "TEXT" + ")";

    public DatabaseHendler (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAHASISWA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void CreateMahasiswa (ModalMahasiswa mdNotif){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mahasiswa_id, mdNotif.get_id());
        values.put(tb_mahasiswa_nama, mdNotif.get_nama());
        values.put(tb_mahasiswa_kelas, mdNotif.get_nama());
        db.insert(tb_mahasiswa, null, values);
        db.close();
    }
}
