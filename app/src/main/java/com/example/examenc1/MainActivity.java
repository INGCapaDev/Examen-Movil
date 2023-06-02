package com.example.examenc1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnEntrar;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        btnEntrar.setOnClickListener(v -> entrar());
        btnSalir.setOnClickListener(v -> cerrar());
    }

    private void iniciarComponentes(){
        txtNombre = findViewById(R.id.txtNombre);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSalir = findViewById(R.id.btnSalir);
    }

    private void entrar(){
        if (txtNombre.getText().toString().isEmpty()){
            Toast.makeText(this.getApplicationContext(), "Nombre Requerido", Toast.LENGTH_SHORT).show();
            return;
        }
        String strNombre = txtNombre.getText().toString();
        Intent intent = new Intent(MainActivity.this, RectanguloActivity.class);
        intent.putExtra("strNombre", strNombre);
        startActivity(intent);
    }

    private void cerrar() {
        new AlertDialog.Builder(this)
                .setTitle("Rectangulo")
                .setMessage("Te gustaria salir?")
                .setPositiveButton("Confirmar", (dialog, which) -> finish())
                .setNegativeButton("Cancelar", null)
                .show();
    }
}