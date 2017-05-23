package com.example.user.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Ingreso_Producto extends AppCompatActivity {

    private EditText cajaModelo;
    private EditText cajaSerie;
    private EditText cajaDescripcion;
    private EditText cajaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso__producto);
        cajaModelo = (EditText)findViewById(R.id.txtModeloPro);
        cajaSerie = (EditText)findViewById(R.id.txtSeriePro);
        cajaDescripcion = (EditText)findViewById(R.id.txtDescripcion);
        cajaCliente = (EditText)findViewById(R.id.txtClientePro);
    }

    public void guardarPro(View v){
        String  foto, serie, modelo, descripcion, cliente;

        Producto p;

        if(validarTodo()){
            serie = cajaSerie.getText().toString();
            modelo = cajaModelo.getText().toString();
            descripcion = cajaDescripcion.getText().toString();
            cliente = cajaCliente.getText().toString();

            foto = String.valueOf(numeroFoto(modelo));

            p = new Producto(foto, serie, modelo, descripcion, cliente);
            p.guardarPro(getApplicationContext());

            Toast.makeText(getApplicationContext(), "Producto Guardado Exitosamente",
                    Toast.LENGTH_SHORT).show();

            limpiar();
        }
    }

    public int numeroFoto(String modelo){
        int numero, aux = 0;

        int fotos[] = {R.drawable.ups1000,R.drawable.ups1300,R.drawable.ups1500,R.drawable.upsbr24,R.drawable.upsbge,R.drawable.upsbe};

            if (modelo == "ups1000"){
                numero = fotos[0];
                aux = numero;

            }if (modelo == "ups1300"){
                numero = fotos[1];
                aux = numero;

            }if (modelo == "ups1500"){
                numero = fotos[2];
                aux = numero;

            }if (modelo == "br24bpg"){
                numero = fotos[3];
                aux = numero;

            }if (modelo == "bge50ml"){
                numero = fotos[4];
                aux = numero;

            }if (modelo == "be350g-lm"){
                numero = fotos[5];
                aux = numero;
            }
        return fotos[aux];
    }


    public boolean validarTodo(){

        if(cajaModelo.getText().toString().isEmpty()){
            cajaModelo.setError(getResources().getString(R.string.error_6));
            return false;
        }
        if(cajaSerie.getText().toString().isEmpty()){
            cajaSerie.setError(getResources().getString(R.string.error_7));
            return false;
        }
        return  true;
    }


    public boolean validarSerie() {
        if (cajaSerie.getText().toString().isEmpty()) {
            cajaSerie.setError("Digite la serie");
            cajaSerie.requestFocus();
            return false;
        }
        return true;
    }
    public void limpiar(){
        cajaSerie.setText("");
        cajaModelo.setText("");
        cajaDescripcion.setText("");
        cajaCliente.setText("");
        cajaSerie.requestFocus();

    }

    public void buscar(View v){
        Producto p;
        if(validarSerie()) {
            p = Datos.buscarProducto(getApplicationContext(), cajaSerie.getText().toString());
            if(p!=null){
                cajaSerie.setText(p.getSerie());
                cajaModelo.setText(p.getModelo());
                cajaDescripcion.setText(p.getDescripcion());
                cajaCliente.setText(p.getCliente());
            }
        }
    }


}
