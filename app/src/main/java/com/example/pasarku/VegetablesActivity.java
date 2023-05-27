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

public class VegetablesActivity extends AppCompatActivity {

    private Button buttonMinusWortel;
    private Button buttonPlusWortel;
    private TextView textViewQuantityWortel;
    private Button buttonAddToCartWortel;

    private Button buttonMinusBrokoli;
    private Button buttonPlusBrokoli;
    private TextView textViewQuantityBrokoli;
    private Button buttonAddToCartBrokoli;
    private int quantityWortel = 0;
    private int quantityBrokoli = 0;
    private int hargaWortel = 4000;
    private int hargaBrokoli = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

        // Menghubungkan variabel dengan view yang ada di layout
        buttonMinusWortel = findViewById(R.id.buttonMinusWortel);
        buttonPlusWortel = findViewById(R.id.buttonPlusWortel);
        textViewQuantityWortel = findViewById(R.id.textViewQuantityWortel);
        buttonAddToCartWortel = findViewById(R.id.buttonAddToCartWortel);

        buttonMinusBrokoli = findViewById(R.id.buttonMinusBrokoli);
        buttonPlusBrokoli = findViewById(R.id.buttonPlusBrokoli);
        textViewQuantityBrokoli = findViewById(R.id.textViewQuantityBrokoli);
        buttonAddToCartBrokoli = findViewById(R.id.buttonAddToCartBrokoli);

        // Inisialisasi tombol keranjang
        View buttonKeranjang = findViewById(R.id.buttonKeranjang);

        // Tambahkan onClickListener untuk menangani klik tombol keranjang
        buttonKeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman keranjang (CheckoutActivity)
                Intent intent = new Intent(VegetablesActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });

        buttonMinusWortel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantityWortel > 0) {
                    quantityWortel--;
                    textViewQuantityWortel.setText(String.valueOf(quantityWortel));
                }
            }
        });

        buttonPlusWortel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityWortel++;
                textViewQuantityWortel.setText(String.valueOf(quantityWortel));
            }
        });

        buttonMinusBrokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantityBrokoli > 0) {
                    quantityBrokoli--;
                    textViewQuantityBrokoli.setText(String.valueOf(quantityBrokoli));
                }
            }
        });

        buttonPlusBrokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityBrokoli++;
                textViewQuantityBrokoli.setText(String.valueOf(quantityBrokoli));
            }
        });

        // Navigasi ke halaman FruitsActivity
        TextView textViewBuah = findViewById(R.id.textViewBuah);
        textViewBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VegetablesActivity.this, FruitsActivity.class);
                startActivity(intent);
            }
        });
        buttonAddToCartWortel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("quantityWortel", quantityWortel);
                editor.putInt("hargaWortel", hargaWortel * quantityWortel);
                editor.apply();

                Toast.makeText(VegetablesActivity.this, "Wortel berhasil ditambahkan ke keranjang", Toast.LENGTH_SHORT).show();
            }
        });

        buttonAddToCartBrokoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("quantityBrokoli", quantityBrokoli);
                editor.putInt("hargaBrokoli", hargaBrokoli * quantityBrokoli);
                editor.apply();

                Toast.makeText(VegetablesActivity.this, "Brokoli berhasil ditambahkan ke keranjang", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
