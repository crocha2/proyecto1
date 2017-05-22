package com.example.user.proyectofinal;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Ingreso extends AppCompatActivity implements View.OnClickListener {

    Button fecha;
    private EditText cajaFecha;
    private EditText cajaRMA;
    private EditText cajaCliente;
    private EditText cajaTelefono;
    private EditText cajaCorreo;
    private EditText cajaEquipo;
    private EditText cajaModelo;
    private EditText cajaSerie;

    private int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        cajaRMA = (EditText)findViewById(R.id.txtRma);
        cajaCliente = (EditText)findViewById(R.id.txtCliente);
        cajaTelefono = (EditText)findViewById(R.id.txtTelefono);
        cajaCorreo = (EditText)findViewById(R.id.txtCorreo);
        cajaEquipo = (EditText)findViewById(R.id.txtEquipo);
        cajaModelo = (EditText)findViewById(R.id.txtModelo);
        cajaSerie = (EditText)findViewById(R.id.txtSerie);

        fecha = (Button)findViewById(R.id.btnFecha);
        cajaFecha = (EditText)findViewById(R.id.txtFecha);
        fecha.setOnClickListener(this);

    }


    public boolean validar(){
        if(cajaRMA.getText().toString().isEmpty()){
            cajaRMA.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(cajaCliente.getText().toString().isEmpty()){
            cajaCliente.setError(getResources().getString(R.string.error_2));
            return false;
        }
        if(cajaTelefono.getText().toString().isEmpty()){
            cajaTelefono.setError(getResources().getString(R.string.error_3));
            return false;
        }
        if(cajaCorreo.getText().toString().isEmpty()){
            cajaCorreo.setError(getResources().getString(R.string.error_4));
            return false;
        }
        if(cajaEquipo.getText().toString().isEmpty()){
            cajaEquipo.setError(getResources().getString(R.string.error_5));
            return false;
        }
        if(cajaModelo.getText().toString().isEmpty()){
            cajaModelo.setError(getResources().getString(R.string.error_6));
            return false;
        }
        if(cajaSerie.getText().toString().isEmpty()){
            cajaSerie.setError(getResources().getString(R.string.error_7));
            return false;
        }
        if(cajaFecha.getText().toString().isEmpty()){
            cajaFecha.setError(getResources().getString(R.string.error_8));
            return false;
        }
        return  true;
    }

    public void limpiar(){
        cajaRMA.setText("");
        cajaCliente.setText("");
        cajaTelefono.setText("");
        cajaCorreo.setText("");
        cajaEquipo.setText("");
        cajaModelo.setText("");
        cajaSerie.setText("");
        cajaRMA.requestFocus();
    }

    public void guardar(View v){
        String rma,cliente,telefono,correo,equipo,modelo, serie, fecha;
        Crea_Garantia g;

        if(validar()){
            rma = cajaRMA.getText().toString();
            cliente = cajaCliente.getText().toString();
            telefono = cajaTelefono.getText().toString();
            correo = cajaCorreo.getText().toString();
            equipo = cajaEquipo.getText().toString();
            modelo = cajaModelo.getText().toString();
            serie = cajaSerie.getText().toString();
            fecha = cajaFecha.getText().toString();

            g = new Crea_Garantia(rma,cliente,telefono,correo,equipo,modelo, serie, fecha);
            g.guardar(getApplicationContext());

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.registrado),
                    Toast.LENGTH_SHORT).show();

            limpiar();

        }
    }










    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if(v==fecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    cajaFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            ,dia, mes, año);
            datePickerDialog.show();
        }
    }
}
