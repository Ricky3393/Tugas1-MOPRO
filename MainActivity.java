//Ricky Ahmad Saiful 1157050138

package com.adamnain.pertemuan1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    TextView tvHasil;
    Button btnToast, btnCount;
    int jumlah = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, tvHasil.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlah = jumlah+1;
                if (jumlah > 33 ){
                    Toast.makeText(MainActivity.this, "Batas Sampai 33", Toast.LENGTH_SHORT).show();
                }
                else{
                    tvHasil.setText(String.valueOf(jumlah));
                }
            }
        });

    }

    private void init(){
        tvHasil = findViewById(R.id.txt_hasil);
        btnToast = findViewById(R.id.btn_toast);
        btnCount = findViewById(R.id.btn_count);
    }
}
