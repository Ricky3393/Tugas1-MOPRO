package com.example.rickyahmadsaiful.tugasmopro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {
    Button menu, telepon, lokasi;

    String goolgeMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    String alihsan_cbr = "-6.937552, 107.722331";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        menu = findViewById(R.id.btn_menu);
        lokasi = findViewById(R.id.btn_Lokasi);
        telepon = findViewById(R.id.btn_telepon);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gmmIntentUri = Uri.parse("google.navigation:q=" + alihsan_cbr);
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage(goolgeMap);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(DashboardActivity.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        telepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "082217582860"));
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            Intent intent = new Intent(DashboardActivity.this, MenuActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.setting) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "082217582860"));
            startActivity(intent);
        } else if (item.getItemId() == R.id.help) {
            Toast.makeText(DashboardActivity.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                    Toast.LENGTH_LONG).show();
        }

        return true;
    }
}
