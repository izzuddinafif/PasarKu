package com.example.pasarku;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FruitsActivity extends AppCompatActivity {

    private Button buttonMinusApel;
    private Button buttonPlusApel;
    private TextView textViewQuantityApel;
    private Button buttonAddToCartApel;

    private Button buttonMinusJeruk;
    private Button buttonPlusJeruk;
    private TextView textViewQuantityJeruk;
    private Button buttonAddToCartJeruk;

    private Button buttonKeranjang;
    private int quantityApel = 0;
    private int quantityJeruk = 0;
    private int hargaApel = 5000;
    private int hargaJeruk = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        // Menghubungkan variabel dengan view yang ada di layout
        buttonMinusApel = findViewById(R.id.buttonMinusApel);
        buttonPlusApel = findViewById(R.id.buttonPlusApel);
        textViewQuantityApel = findViewById(R.id.textViewQuantityApel);
        buttonAddToCartApel = findViewById(R.id.buttonAddToCartApel);

        buttonMinusJeruk = findViewById(R.id.buttonMinusJeruk);
        buttonPlusJeruk = findViewById(R.id.buttonPlusJeruk);
        textViewQuantityJeruk = findViewById(R.id.textViewQuantityJeruk);
        buttonAddToCartJeruk = findViewById(R.id.buttonAddToCartJeruk);

        // Inisialisasi tombol keranjang
        View buttonKeranjang = findViewById(R.id.buttonKeranjang);

        // Tambahkan onClickListener untuk menangani klik tombol keranjang
        buttonKeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman keranjang (CheckoutActivity)
                Intent intent = new Intent(FruitsActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
        buttonMinusApel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantityApel > 0) {
                    quantityApel--;
                    textViewQuantityApel.setText(String.valueOf(quantityApel));
                }
            }
        });

        buttonPlusApel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityApel++;
                textViewQuantityApel.setText(String.valueOf(quantityApel));
            }
        });

        buttonMinusJeruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantityJeruk > 0) {
                    quantityJeruk--;
                    textViewQuantityJeruk.setText(String.valueOf(quantityJeruk));
                }
            }
        });

        buttonPlusJeruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityJeruk++;
                textViewQuantityJeruk.setText(String.valueOf(quantityJeruk));
            }
        });

        // Navigasi ke halaman VegetablesActivity
        TextView textViewSayuran = findViewById(R.id.textViewSayuran);
        textViewSayuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FruitsActivity.this, VegetablesActivity.class);
                startActivity(intent);
            }
        });
        buttonAddToCartApel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("quantityApel", quantityApel);
                editor.putInt("hargaApel", hargaApel * quantityApel);
                editor.apply();

                Toast.makeText(FruitsActivity.this, "Apel berhasil ditambahkan ke keranjang", Toast.LENGTH_SHORT).show();
            }
        });

        buttonAddToCartJeruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("quantityJeruk", quantityJeruk);
                editor.putInt("hargaJeruk", hargaJeruk * quantityJeruk);
                editor.apply();

                Toast.makeText(FruitsActivity.this, "Jeruk berhasil ditambahkan ke keranjang", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
