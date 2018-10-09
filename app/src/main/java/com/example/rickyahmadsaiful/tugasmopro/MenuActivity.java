package com.example.rickyahmadsaiful.tugasmopro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    EditText ikanMasBakar, ikanNilaBakar, ikanMasgoreng, ikanNilaGoreng, esKelapa, esTeh, esDawet, esCincaw;
    Button pesan, cekHarga;
    CardView cvIkanMas,cvIkanNila, cvIkanMasGoreng, cvIkanNilaGoreng, cvEsKelapa, cvEsTehManis, cvEsDawet, cvEsCincau ;
    int masBakar = 50000, nilaBakar = 55000, masgoreng = 45000, nilaGoreng = 50000, kelapa = 5000, teh = 4000, dawet = 5000, cincaw = 5000;
    int qikanMasBakar, qikanNilaBakar, qikanMasgoreng, qikanNilaGoreng, qesKelapa, qesTeh, qesDawet, qesCincaw;
    TextView jml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ikanMasBakar = findViewById(R.id.txt_ikan_bakar_mas);
        ikanNilaBakar = findViewById(R.id.txt_ikan_bakar_nila);
        ikanMasgoreng = findViewById(R.id.txt_ikan_goreng_mas);
        ikanNilaGoreng = findViewById(R.id.txt_ikan_goreng_nila);
        esKelapa = findViewById(R.id.txt_es_kelapa);
        esTeh = findViewById(R.id.tex_es_teh);
        esDawet = findViewById(R.id.txt_es_dawet);
        esCincaw = findViewById(R.id.txt_es_cincau);
        cekHarga = findViewById(R.id.btn_cek_harga);
        pesan = findViewById(R.id.btn_pesan);
        jml = findViewById(R.id.tex_tampil_harga);

        cvIkanMas = findViewById(R.id.cv_ikanMas);
        cvIkanNila = findViewById(R.id.cv_ikanNila);
        cvIkanMasGoreng = findViewById(R.id.cv_ikanMasGoreng);
        cvIkanNilaGoreng = findViewById(R.id.cv_ikanNilaGoreng);
        cvEsKelapa = findViewById(R.id.cv_EsKelapa);
        cvEsTehManis = findViewById(R.id.cv_TehManis);
        cvEsDawet = findViewById(R.id.cv_EsDawet);
        cvEsCincau = findViewById(R.id.cv_EsCincau);

        registerForContextMenu(cvIkanMas);
        registerForContextMenu(cvIkanNila);
        registerForContextMenu(cvIkanMasGoreng);
        registerForContextMenu(cvIkanNilaGoreng);
        registerForContextMenu(cvEsTehManis);
        registerForContextMenu(cvEsKelapa);
        registerForContextMenu(cvEsCincau);
        registerForContextMenu(cvEsDawet);


        cekHarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qikanMasBakar = Integer.valueOf(ikanMasBakar.getText().toString());
                qikanMasgoreng = Integer.valueOf(ikanMasgoreng.getText().toString());
                qikanNilaBakar = Integer.valueOf(ikanNilaBakar.getText().toString());
                qikanNilaGoreng = Integer.valueOf(ikanNilaGoreng.getText().toString());
                qesCincaw = Integer.valueOf(esCincaw.getText().toString());
                qesTeh = Integer.valueOf(esTeh.getText().toString());
                qesDawet = Integer.valueOf(esDawet.getText().toString());
                qesKelapa = Integer.valueOf(esKelapa.getText().toString());
                int jumlah = 0;
                jumlah = (qikanMasBakar * masBakar) + (qikanNilaBakar * nilaBakar) + (qikanMasgoreng * masgoreng) + (qikanNilaGoreng * nilaGoreng) + (qesKelapa * kelapa) + (qesDawet * dawet) + (qesTeh * teh) + (qesCincaw * cincaw);
                jml.setText(String.valueOf(jumlah));
            }
        });

        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuActivity.this, "Terima kasih Sudah Memesan", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MenuActivity.this,DashboardActivity.class));
            }
        });

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "1");
        menu.add(0, v.getId(), 0, "2");
        menu.add(0, v.getId(), 0, "3");
        menu.add(0, v.getId(), 0, "4");
        menu.add(0, v.getId(), 0, "5");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int angkaContexMenu = Integer.valueOf(item.getTitle().toString());
        if (item.getItemId() == R.id.cv_ikanMas) {
            ikanMasBakar.setText(item.getTitle().toString());
        } else if ((item.getItemId() == R.id.cv_ikanNila)) {
            ikanNilaBakar.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cv_ikanMasGoreng)) {
            ikanMasgoreng.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cv_ikanNilaGoreng)) {
            ikanNilaGoreng.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cv_TehManis)) {
            esTeh.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cv_EsCincau)) {
            esCincaw.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cv_EsDawet)) {
            esDawet.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cv_EsCincau)) {
            esCincaw.setText(item.getTitle().toString());

        }
        return true;
    }
}
