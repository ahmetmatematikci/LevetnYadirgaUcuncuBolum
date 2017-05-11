package com.example.a.levetnyadirgaucuncubolum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 11.05.2017.
 */

public class VeriTabani extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "ogrenci_veritabani";
    static final String TABLE_NAME = "ogrenci_tablosu";
    static final int DATABASE_VERSION= 1;

    private static final String AD="adSoyad";
    private static final String MAIL="mail";
    private static final String ADRES="adres";
    private static final String ID= "_id";


    public VeriTabani(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabloOlustur="CREATE TABLE " + TABLE_NAME +
                " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AD + " TEXT, " +
                MAIL + " TEXT, " +
                ADRES + " TEXT); ";
        db.execSQL(tabloOlustur);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public long KayitEkle(Ogrenci ogrenci) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AD,ogrenci.getAdSoyad());
        cv.put(MAIL,ogrenci.geteMail());
        cv.put(ADRES,ogrenci.getAdres());

      long id =  db.insert(TABLE_NAME, null,cv);

        db.close();
        return id;
    }

    public List<Ogrenci> TumKayitlariGetir() {
        SQLiteDatabase db =this. getReadableDatabase();
        String [] sutunlar = new String[]{AD, MAIL,ADRES};

        Cursor c = db.query(TABLE_NAME, sutunlar, null,null,null,null,null );
    /*    Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);*/

        int adSiraNo = c.getColumnIndex(AD);
        int mailSıraNo= c.getColumnIndex(MAIL);
        int adresSiraNo = c.getColumnIndex(ADRES);

        List<Ogrenci> ogrenciList = new ArrayList<Ogrenci>();


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Ogrenci ogrenci = new Ogrenci();

            ogrenci.setAdSoyad(c.getString(adSiraNo));

            ogrenci.seteMail(c.getString(mailSıraNo));

            ogrenci.setAdres(c.getString(adresSiraNo));

            ogrenciList.add(ogrenci);




        }
        db.close();

        return ogrenciList;

    }
}
