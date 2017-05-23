package com.example.user.proyectofinal;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
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
        cajaModelo = (EditText)findViewById(R.id.txtSeriePro);
        cajaSerie = (EditText)findViewById(R.id.txtSeriePro);

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
        cajaFecha.setText("");
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

    public void buscar(View v){
        Crea_Garantia g;
        String pasatiempos;
        if(validarRMA()) {
            g = Datos.buscarGarantia(getApplicationContext(), cajaRMA.getText().toString());
            if(g!=null){
                cajaRMA.setText(g.getRma());
                cajaCliente.setText(g.getCliente());
                cajaTelefono.setText(g.getTelefono());
                cajaCorreo.setText(g.getCorreo());
                cajaEquipo.setText(g.getEquipo());
                cajaModelo.setText(g.getModelo());
                cajaSerie.setText(g.getSerie());
                cajaFecha.setText(g.getFecha());
            }
        }
    }

    public void modificar(View v){
        Crea_Garantia g,g2;
        String rma,cliente,telefono,correo,equipo,modelo, serie, fecha;
        if(validarRMA()) {
            g = Datos.buscarGarantia(getApplicationContext(), cajaRMA.getText().toString());
            if(g!=null){

                rma = cajaRMA.getText().toString();
                cliente = cajaCliente.getText().toString();
                telefono = cajaTelefono.getText().toString();
                correo = cajaCorreo.getText().toString();
                equipo = cajaEquipo.getText().toString();
                modelo = cajaModelo.getText().toString();
                serie = cajaSerie.getText().toString();
                fecha = cajaFecha.getText().toString();

                g2 = new Crea_Garantia(rma,cliente,telefono,correo,equipo,modelo, serie, fecha);
                g2.modificar(getApplicationContext());

                Toast.makeText(getApplicationContext(), "Registro Modificada Exitosamente",
                        Toast.LENGTH_SHORT).show();

                limpiar();
            }
        }
    }

    public void eliminar(View v){
        Crea_Garantia g;
        if(validarRMA()) {
            g = Datos.buscarGarantia(getApplicationContext(), cajaRMA.getText().toString());
            if(g!=null){
                AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                ventana.setTitle("Confirmación");
                ventana.setMessage("¿Está seguro que desea eliminar este registro?");
                ventana.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Crea_Garantia g;
                        g = Datos.buscarGarantia(getApplicationContext(), cajaRMA.getText().toString());

                        g.eliminar(getApplicationContext());
                        limpiar();
                        Toast.makeText(getApplicationContext(), "Persona Eliminada Exitosamente",
                                Toast.LENGTH_SHORT).show();

                    }
                });

                ventana.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cajaRMA.requestFocus();
                    }
                });

                ventana.show();
            }
        }
    }

    public boolean validarRMA() {
        if (cajaRMA.getText().toString().isEmpty()) {
            cajaRMA.setError(getResources().getString(R.string.error_1));
            cajaRMA.requestFocus();
            return false;
        }
        return true;
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
