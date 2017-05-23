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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso__producto);
        cajaModelo = (EditText)findViewById(R.id.txtModeloPro);
        cajaSerie = (EditText)findViewById(R.id.txtSeriePro);
        cajaDescripcion = (EditText)findViewById(R.id.txtDescripcion);
    }

    public void guardar(View v){
        String  foto, serie, modelo, descripcion, aux;

        Producto p;

        if(validarTodo()){
            serie = cajaSerie.getText().toString();
            modelo = cajaModelo.getText().toString();
            descripcion = cajaDescripcion.getText().toString();

            if (modelo == "ups1000"){
                foto = String.valueOf(numeroFoto());
            }
            if (modelo == "ups1300"){
                foto = String.valueOf(numeroFoto()+1);
            }
            if (modelo == "ups1500"){
                foto = String.valueOf(numeroFoto())+2;
            }
            if (modelo == "br24bpg"){
                foto = String.valueOf(numeroFoto())+3;
            }
            if (modelo == "bge50ml"){
                foto = String.valueOf(numeroFoto())+4;
            }
            if (modelo == "be350g-lm"){
                foto = String.valueOf(numeroFoto())+5;
            }

            //p = new Producto(foto, serie, modelo, descripcion);
            //p.guardarPro(getApplicationContext());

            Toast.makeText(getApplicationContext(), "Producto Guardado Exitosamente",
                    Toast.LENGTH_SHORT).show();

            limpiar();
        }
    }

    public int numeroFoto(){
        int fotos[] = {R.drawable.ups1000,R.drawable.ups1300,R.drawable.ups1500,R.drawable.upsbr24,R.drawable.upsbge,R.drawable.upsbe};
        int numero = 0;
        return fotos[numero];
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
        cajaSerie.requestFocus();

    }


}
