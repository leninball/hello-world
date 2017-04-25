package com.leninball.usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    ArrayList<Usuario> usuarios;

    EditText   tvNombreUsuario;
    EditText   tvEmailUsuario;
    EditText   tvTelefonoUsuario;
    DatePicker dtFecha;
    EditText   tvDescripcion;
    public static int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios = new ArrayList<Usuario>();

        tvNombreUsuario = (EditText) findViewById(R.id.tvNombreUsuario);
        tvTelefonoUsuario = (EditText) findViewById(R.id.tvTelefonoUsuario);
        tvEmailUsuario = (EditText) findViewById(R.id.tvEmailUsuario);
        dtFecha = (DatePicker) findViewById(R.id.dtFecha);
        tvDescripcion = (EditText) findViewById(R.id.tvDescripcion);

        /*RECUPERAR DATOS DE PANTALLA DE CONFIRMACION*/
        if(flag == 1) {
            Bundle parametros = getIntent().getExtras();
            String nombre = parametros.getString(getResources().getString(R.string.key_nombre));
            String telefono = parametros.getString(getResources().getString(R.string.key_telefono));
            String email = parametros.getString(getResources().getString(R.string.key_email));
            int anio = parametros.getInt(getResources().getString(R.string.key_anio));
            int mes = parametros.getInt(getResources().getString(R.string.key_mes));
            int dia = parametros.getInt(getResources().getString(R.string.key_dia));
            String descripcion = parametros.getString(getResources().getString(R.string.key_descripcion));


            tvNombreUsuario.setText(String.paranio);
            tvTelefonoUsuario.setText(telefono);
            tvEmailUsuario.setText(email);
            dtFecha.updateDate(anio,mes,dia);
            tvDescripcion.setText(descripcion);
        }
    }

    public void siguiente(View v)
    {
        String nombre = tvNombreUsuario.getText().toString();
        String email = tvEmailUsuario.getText().toString();
        String telefono = tvTelefonoUsuario.getText().toString();
        int dia = dtFecha.getDayOfMonth();
        int mes = dtFecha.getMonth();
        int anio = dtFecha.getYear();
        String fecha = String.valueOf(dia) + '/' + String.valueOf(mes) + '/' + String.valueOf(anio);
        String descripcion = tvDescripcion.getText().toString();

        Intent intent = new Intent(MainActivity.this, confirmar.class);
        intent.putExtra(getResources().getString(R.string.key_nombre), nombre);
        intent.putExtra(getResources().getString(R.string.key_email), email);
        intent.putExtra(getResources().getString(R.string.key_telefono), telefono);
        intent.putExtra(getResources().getString(R.string.key_fecha), fecha);
        intent.putExtra(getResources().getString(R.string.key_descripcion), descripcion);

        startActivity(intent);
    }
}
