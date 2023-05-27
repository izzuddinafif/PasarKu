package com.example.pasarku;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class CheckoutActivity extends AppCompatActivity {

    private TextView textViewTotal;
    private TextView textViewQuantityApel;
    private TextView textViewHargaApel;
    private TextView textViewQuantityJeruk;
    private TextView textViewHargaJeruk;
    private TextView textViewQuantityWortel;
    private TextView textViewHargaWortel;
    private TextView textViewQuantityBrokoli;
    private TextView textViewHargaBrokoli;
    private Button buttonBayar;
    private TextView textViewSayuran;
    private TextView textViewBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        textViewTotal = findViewById(R.id.textViewTotal);
        buttonBayar = findViewById(R.id.buttonBayar);

        textViewQuantityApel = findViewById(R.id.textViewQuantityApel);
        textViewHargaApel = findViewById(R.id.textViewHargaApel);
        textViewQuantityJeruk = findViewById(R.id.textViewQuantityJeruk);
        textViewHargaJeruk = findViewById(R.id.textViewHargaJeruk);
        textViewQuantityWortel = findViewById(R.id.textViewQuantityWortel);
        textViewHargaWortel = findViewById(R.id.textViewHargaWortel);
        textViewQuantityBrokoli = findViewById(R.id.textViewQuantityBrokoli);
        textViewHargaBrokoli = findViewById(R.id.textViewHargaBrokoli);

        SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

        int quantityApel = sharedPref.getInt("quantityApel", 0);
        int hargaApel = sharedPref.getInt("hargaApel", 0);
        textViewQuantityApel.setText("Quantity: " + quantityApel);
        textViewHargaApel.setText("Harga: " + formatRupiah.format(hargaApel));

        int quantityJeruk = sharedPref.getInt("quantityJeruk", 0);
        int hargaJeruk = sharedPref.getInt("hargaJeruk", 0);
        textViewQuantityJeruk.setText("Quantity: " + quantityJeruk);
        textViewHargaJeruk.setText("Harga: " + formatRupiah.format(hargaJeruk));

        int quantityWortel = sharedPref.getInt("quantityWortel", 0);
        int hargaWortel = sharedPref.getInt("hargaWortel", 0);
        textViewQuantityWortel.setText("Quantity: " + quantityWortel);
        textViewHargaWortel.setText("Harga: " + formatRupiah.format(hargaWortel));

        int quantityBrokoli = sharedPref.getInt("quantityBrokoli", 0);
        int hargaBrokoli = sharedPref.getInt("hargaBrokoli", 0);
        textViewQuantityBrokoli.setText("Quantity: " + quantityBrokoli);
        textViewHargaBrokoli.setText("Harga: " + formatRupiah.format(hargaBrokoli));

        int totalHarga = hargaApel + hargaJeruk + hargaWortel + hargaBrokoli;
        textViewTotal.setText("Total: " + formatRupiah.format(totalHarga));
        textViewSayuran = findViewById(R.id.textViewSayuran);
        textViewBuah = findViewById(R.id.textViewBuah);
        textViewSayuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengganti nama "SayuranActivity" dengan nama Activity Sayuran Anda
                Intent intent = new Intent(CheckoutActivity.this, VegetablesActivity.class);
                startActivity(intent);
            }
        });

        textViewBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengganti nama "BuahActivity" dengan nama Activity Buah Anda
                Intent intent = new Intent(CheckoutActivity.this, FruitsActivity.class);
                startActivity(intent);
            }
        });
        buttonBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("quantityApel", 0);
                editor.putInt("hargaApel", 0);
                editor.putInt("quantityJeruk", 0);
                editor.putInt("hargaJeruk", 0);
                editor.putInt("quantityWortel", 0);
                editor.putInt("hargaWortel", 0);
                editor.putInt("quantityBrokoli", 0);
                editor.putInt("hargaBrokoli", 0);
                editor.apply();

                Toast.makeText(CheckoutActivity.this, "Pembayaran berhasil, terima kasih!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
