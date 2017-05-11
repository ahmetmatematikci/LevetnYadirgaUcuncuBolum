package com.example.a.levetnyadirgaucuncubolum;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteCalismasi extends AppCompatActivity {
    EditText et_adsoyad, et_email, et_adres;
    Button bt_kaydet, bt_listele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_calismasi);

        et_adsoyad = (EditText)findViewById(R.id.et_adsoyad);
        et_email = (EditText)findViewById(R.id.et_email);
        et_adres = (EditText)findViewById(R.id.et_adres);

        bt_kaydet = (Button)findViewById(R.id.btn_kaydet);
        bt_listele = (Button)findViewById(R.id.btn_listele);
    }

    public void butonnaDokunuldu(View view) {

        switch (view.getId()) {

            case R.id.btn_kaydet:
                String adSoyad=et_adsoyad.getText().toString();
                String eMail=et_email.getText().toString();
                String adres=et_adres.getText().toString();

                Ogrenci ogrenci = new Ogrenci(adSoyad, eMail, adres);
                try {
                    VeriTabani db = new VeriTabani(getApplicationContext());
                    long id = db.KayitEkle(ogrenci);

                    if (id ==-1) {
                        Toast.makeText(this, "Kayıt işleminde hata oluştu", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Kayıt işlemi başarılı", Toast.LENGTH_SHORT).show();
                    }

                }catch (SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "SQL Hatası" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
                et_adsoyad.setText("");
                et_email.setText("");
                et_adres.setText("");




                break;

            case R.id.btn_listele:
                Intent i = new Intent(getApplicationContext(), lsitele.class);
                startActivity(i);

                break;
        }
    }
}
