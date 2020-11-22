package com.upc.hospedajeparaperroswau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuarioActivty extends AppCompatActivity {

    EditText txtEmailR,txtNombresR,txtApellidosR, txtDireccionR,txtdni,txtCelular;
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txtEmailR = findViewById(R.id.txtEmailR);
        txtNombresR = findViewById(R.id.txtNombresR);
        txtApellidosR = findViewById(R.id.txtApellidosR);
        txtDireccionR = findViewById(R.id.txtDireccionR);
        txtdni = findViewById(R.id.txtdni);
        txtCelular = findViewById(R.id.txtCelular);

        btnCrear = findViewById(R.id.btnCrear);


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario(){
        String email = txtEmailR.getText().toString();
        String nombres = txtNombresR.getText().toString();
        String apellidos = txtApellidosR.getText().toString();
        String direccion = txtDireccionR.getText().toString();
        String dni = txtdni.getText().toString();
        String celular = txtCelular.getText().toString();


        if(email.isEmpty() || nombres.isEmpty()|| apellidos.isEmpty()|| direccion.isEmpty()|| dni.isEmpty()|| celular.isEmpty()){
            if(email.isEmpty()){
                txtEmailR.setError("Campo Obligatorio");
            }
            if(nombres.isEmpty()){
                txtNombresR.setError("Campo Obligatorio");
            }
            if(apellidos.isEmpty()){
                txtApellidosR.setError("Campo Obligatorio");
            }
            if(direccion.isEmpty()){
                txtDireccionR.setError("Campo Obligatorio");
            }
            if(dni.isEmpty()){
                txtdni.setError("Campo Obligatorio");
            }
            if(celular.isEmpty()){
                txtCelular.setError("Campo Obligatorio");
            }
        }else{
            String url = "http://200.60.80.182/api/Usuario/Create";
            StringRequest peticion = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(RegistroUsuarioActivty.this, "Se creó correctamente "+response, Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RegistroUsuarioActivty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> parametros = new HashMap<>();
                    parametros.put("emailUsu",email);
                    parametros.put("nomsUsu",nombres);
                    parametros.put("apesUsu",apellidos);
                    parametros.put("dirUsu",direccion);
                    parametros.put("numCelUsu",celular);
                    parametros.put("nroDocUsu",dni);
                    return parametros;
                }
            };
            Volley.newRequestQueue(this).add(peticion);
        }
    }



}