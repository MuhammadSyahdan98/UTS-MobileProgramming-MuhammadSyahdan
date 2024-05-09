package com.muhammad_syahdan;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    String keynama, keypass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.tombollogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = findViewById(R.id.editekuser);
                password = findViewById(R.id.editekpassword);
                btnlogin = findViewById(R.id.tombollogin);

                keynama = username.getText().toString();
                keypass = password.getText().toString();

                if(keynama.equals("")&& keypass.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                    builder.setMessage
                            ("Username atau password harus diisi").setNegativeButton
                            ("ulangi", null).create().show();

                    username.setText("");
                    password.setText("");
                }else if (keynama.equals("syahdan") && keypass.equals("syahdan")) {
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(),
                            "LOGIN BERHASIL", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(login.this, home.class);
                    intent.putExtra("username",keynama);
                    login.this.startActivity(intent);
                    finish();
                }
                else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                    builder.setMessage
                            ("Username atau password salah").setNegativeButton
                            ("ulangi", null).create().show();

                    username.setText("");
                    password.setText("");
                }

            }
   });
}
}