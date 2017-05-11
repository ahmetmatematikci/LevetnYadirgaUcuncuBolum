package com.example.a.levetnyadirgaucuncubolum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class lsitele extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsitele);
        tv = (TextView)findViewById(R.id.textView);

        try {
            VeriTabani db = new VeriTabani(getApplicationContext());

            List<Ogrenci> ogrenciList = new ArrayList<Ogrenci>();
            ogrenciList = db.TumKayitlariGetir();

            StringBuilder stringBuilder = new StringBuilder();

            for (Ogrenci ogrenci:ogrenciList) {

                stringBuilder.append(
                        ogrenci.getAdSoyad() + "\n " +
                                ogrenci.geteMail()+"\n " +
                                ogrenci.getAdres() +"\n\n "
                );
            }

            tv.setText(stringBuilder);

        } catch (Exception e) {
            e.printStackTrace();
        }





    }
}
