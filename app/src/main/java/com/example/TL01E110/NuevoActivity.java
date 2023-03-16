package com.example.TL01E110;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.TL01E110.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtpais, txtnota;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtpais = findViewById(R.id.txtPais);
        txtnota = findViewById(R.id.txtNota);
        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!txtNombre.getText().toString().equals("") && !txtTelefono.getText().toString().equals("") && !txtpais.getText().toString().equals("") && !txtnota.getText().toString().equals("")) {

                    DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                    long id = dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtpais.getText().toString(),txtnota.getText().toString());

                    if (id > 0) {
                        Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else if (TextUtils.isEmpty(txtNombre.getText())) {
                    Toast.makeText(NuevoActivity.this, "DEBE ESCRIBIR UN NOMBRE", Toast.LENGTH_LONG).show();
                }  else if (TextUtils.isEmpty(txtTelefono.getText())) {
                Toast.makeText(NuevoActivity.this,"DEBE ESCRIBIR UN NUMERO DE TELEFONO", Toast.LENGTH_LONG).show();
                 } else if (TextUtils.isEmpty(txtpais.getText())) {
                    Toast.makeText(NuevoActivity.this, "DEBE ESCRIBIR UN PAIS", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(txtnota.getText())) {
                    Toast.makeText(NuevoActivity.this, "DEBE ESCRIBIR UNA NOTA", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(NuevoActivity.this, "DEBE LLENAR TODOS LOS CAMPOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtpais.setText("");
        txtnota.setText("");
    }
}