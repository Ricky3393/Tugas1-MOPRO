package com.example.rickyahmadsaiful.tugasmopro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    EditText ikanMasBakar, ikanNilaBakar, ikanMasgoreng, ikanNilaGoreng, esKelapa, esTeh, esDawet, esCincaw;
    Button pesan, cekHarga;
    int masBakar = 50000, nilaBakar = 55000, masgoreng = 45000, nilaGoreng = 50000, kelapa = 5000, teh = 4000, dawet = 5000, cincaw = 5000;
    int qikanMasBakar, qikanNilaBakar, qikanMasgoreng, qikanNilaGoreng, qesKelapa, qesTeh, qesDawet, qesCincaw;
    TextView jml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ikanMasBakar = findViewById(R.id.txt_ikan_bakar_mas);
        ikanMasgoreng = findViewById(R.id.txt_ikan_goreng_mas);
        ikanNilaBakar = findViewById(R.id.txt_ikan_bakar_nila);
        ikanNilaGoreng = findViewById(R.id.txt_ikan_goreng_nila);
        esCincaw = findViewById(R.id.txt_es_cincau);
        esDawet = findViewById(R.id.txt_es_dawet);
        esKelapa = findViewById(R.id.txt_es_kelapa);
        esTeh = findViewById(R.id.tex_es_teh);
        cekHarga = findViewById(R.id.btn_cek_harga);
        pesan = findViewById(R.id.btn_pesan);
        jml = findViewById(R.id.tex_tampil_harga);

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
}
