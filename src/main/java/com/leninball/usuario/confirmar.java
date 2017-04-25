package com.leninball.usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class confirmar extends AppCompatActivity {
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvFecha;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.key_nombre));
        String telefono = parametros.getString(getResources().getString(R.string.key_telefono));
        String email = parametros.getString(getResources().getString(R.string.key_email));
        String fecha = parametros.getString(getResources().getString(R.string.key_fecha));
        String descripcion = parametros.getString(getResources().getString(R.string.key_descripcion));

        tvNombre = (TextView) findViewById(R.id.tvNombreUsuario);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvFecha.setText(fecha);
        tvDescripcion.setText(descripcion);
    }

    public void editar(View v)
    {
        String nombre = tvNombre.getText().toString();
        String email = tvEmail.getText().toString();
        String telefono = tvTelefono.getText().toString();
        String dia = tvFecha.getText().subSequence(1,1).toString();
        String mes = tvFecha.getText().subSequence(3,3).toString();
        String anio = tvFecha.getText().subSequence(5,8).toString();
        String descripcion = tvDescripcion.getText().toString();

        Intent intent = new Intent(confirmar.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.key_nombre), nombre);
        intent.putExtra(getResources().getString(R.string.key_email), email);
        intent.putExtra(getResources().getString(R.string.key_telefono), telefono);
        intent.putExtra(getResources().getString(R.string.key_dia), dia);
        intent.putExtra(getResources().getString(R.string.key_mes), mes);
        intent.putExtra(getResources().getString(R.string.key_anio), anio);
        intent.putExtra(getResources().getString(R.string.key_descripcion), descripcion);

        MainActivity.flag = 1;

        startActivity(intent);
    }
}
