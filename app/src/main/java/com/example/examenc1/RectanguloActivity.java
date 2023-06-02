package com.example.examenc1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RectanguloActivity extends AppCompatActivity {
    private TextView lblBase;
    private TextView lblAltura;
    private TextView lblArea;
    private TextView lblPerimetro;
    private TextView lblNombre;
    private EditText txtAltura;
    private EditText txtBase;
    private Button btnCalcular;
    private Button btnRegresar;
    private Button btnLimpiar;

    private final Rectangulo rectangulo = new Rectangulo(0,0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        inicializarComponentes();

        btnCalcular.setOnClickListener(v -> calcular());
        btnRegresar.setOnClickListener(v -> btnRegresar());
        btnLimpiar.setOnClickListener(v -> limpiar());
    }

    private void inicializarComponentes(){
        lblBase = findViewById(R.id.lblBase);
        lblAltura = findViewById(R.id.lblAltura);
        lblArea = findViewById(R.id.lblArea);
        lblPerimetro = findViewById(R.id.lblPerimetro);
        lblNombre = findViewById(R.id.lblNombre);
        txtAltura = findViewById(R.id.txtAltura);
        txtBase = findViewById(R.id.txtBase);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        String strNombre = getIntent().getStringExtra("strNombre");
        lblNombre.setText("Mi nombre es: " + strNombre);
    }

    private void btnRegresar(){
        new AlertDialog.Builder(this)
                .setTitle("Rectangulo")
                .setMessage("Te gustaria regresar?")
                .setPositiveButton("Confirmar", (dialog, which) -> finish())
                .setNegativeButton("Cancelar", null)
                .show();
    }

    private boolean validarCampos(){
        if (this.txtBase.getText().toString().matches("") || this.txtAltura.getText().toString().matches("")){
            Toast.makeText(RectanguloActivity.this, "Campos Requeridos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void actualizarCampos(){
        rectangulo.setBase(Integer.parseInt(txtBase.getText().toString()));
        rectangulo.setAltura(Integer.parseInt(txtAltura.getText().toString()));
    }

    private void calcular(){
        if (validarCampos()){
            actualizarCampos();
            String strArea = "Area: " + rectangulo.calcularArea();
            String strPerimetro = "Perimetro: " + rectangulo.calcularPerimetro();
            lblArea.setText(strArea);
            lblPerimetro.setText(strPerimetro);
        }
    }

    private void limpiar() {
        this.txtAltura.setText("");
        this.txtBase.setText("");
        this.lblPerimetro.setText("Perimetro");
        this.lblArea.setText("Area");
    }
}
