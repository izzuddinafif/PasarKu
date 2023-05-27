package com.example.pasarku;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView textViewSayuran;
    private TextView textViewBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan variabel dengan view yang ada di layout
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mendapatkan text dari EditText
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check jika username dan password benar
                if (username.equals("admin") && password.equals("1234")) {
                    // Jika benar, tampilkan pesan sukses
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                    // Navigasi ke halaman SayuranActivity
                    Intent intent = new Intent(MainActivity.this, VegetablesActivity.class);
                    startActivity(intent);
                } else {
                    // Jika salah, tampilkan pesan error
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
