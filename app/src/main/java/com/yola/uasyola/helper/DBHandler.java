package com.yola.uasyola.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.yola.uasyola.model.Jurusan;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_jurusan"; // NAMA DATABASE
    private static final String TABLE_JURUSAN = "table_jurusan"; // NAMA TABEL
    private static final String COLUMN_ID = "id"; // NAMA KOLOM ID
    private static final String COLUMN_JURUSAN = "jurusan"; // NAMA KOLOM NAMA
    private static final String COLUMN_JENJANG = "jenjang";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // FUNGSI UNTUK MEMBUAT DATABASENYA
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_JURUSAN + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_JURUSAN + " TEXT,"
                + COLUMN_JENJANG + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    // FUNGSI UNTUK MENGECEK DATABASE ADA ATAU TIDAK.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JURUSAN);
        onCreate(db);
    }

    // FUNGSI UNTUK TAMBAH DATA jurusan
    public void tambahJurusan(Jurusan jurusan){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_JURUSAN, jurusan.getJurusan());
        values.put(COLUMN_JENJANG, jurusan.getJenjang());

        db.insert(TABLE_JURUSAN, null, values);
        db.close();
    }

    // FUNGSI UNTUK AMBIL 1 DATA jurusan
    public Jurusan getJurusan(int id_jurusan){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_JURUSAN, new String[]{COLUMN_ID, COLUMN_JURUSAN, COLUMN_JENJANG},
                COLUMN_ID + "=?", new String[]{String.valueOf(id_jurusan)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Jurusan jurusan = new Jurusan(cursor.getString(1), cursor.getString(2));
        return jurusan;
    }

    // FUNGSI UNTUK AMBIL SEMUA DATA jurusan
    public List<Jurusan> getSemuaJurusan(){
        List<Jurusan> jurusanList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_JURUSAN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Jurusan jurusan = new Jurusan(cursor.getString(1), cursor.getString(2));
                jurusanList.add(jurusan);
            } while (cursor.moveToNext());
        }
        return jurusanList;
    }

    // FUNGSI MENGHITUNG ADA BEBERAPA DATA
    public int getJurusanCount(){
        String countQuery = "SELECT * FROM " + TABLE_JURUSAN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // FUNGSI UPDATE DATA jurusan
    public int updateDataJurusan(Jurusan jurusan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_JURUSAN, jurusan.getJurusan());
        values.put(COLUMN_JENJANG, jurusan.getJenjang());
        return db.update(TABLE_JURUSAN, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(jurusan.getId())});
    }

    // FUNGSI HAPUS DATA 1 jurusan
    public void hapusDataJurusan(Jurusan jurusan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_JURUSAN, COLUMN_ID + " = ?",
                new String[]{String.valueOf(jurusan.getId())});
        db.close();
    }

    // FUNGSI UNTUK MENGHAPUS SEMUA DATA jurusan
    public void hapusSemuaDataJurusan(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_JURUSAN);
    }
}
