package com.upc.hospedajeparaperroswau.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.upc.hospedajeparaperroswau.MainActivity;
import com.upc.hospedajeparaperroswau.MascotaActivity;
import com.upc.hospedajeparaperroswau.MenuActivity;
import com.upc.hospedajeparaperroswau.R;
import com.upc.hospedajeparaperroswau.ReservaActivity;
import com.upc.hospedajeparaperroswau.utils.Sesiones;

import org.json.JSONException;
import org.json.JSONObject;


public class InicioFragment extends Fragment {

    ImageButton btnMascota,btnReserva;
    TextView LblNombreI;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Sesiones s= new Sesiones();

        View v=inflater.inflate(R.layout.fragment_inicio, container, false);

        btnMascota=v.findViewById(R.id.btnMascota);
        btnReserva=v.findViewById(R.id.btnReserva);
        LblNombreI=v.findViewById(R.id.LblNombreI);

       String  usu=s.leerValor(getContext(),"usuario");
        try {
            JSONObject objeto = new JSONObject(usu);
            if(objeto!=null){

                LblNombreI.setText(objeto.getString("nomsUsu"));
            }
        } catch (JSONException e) {

            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getContext(), ReservaActivity.class);
               startActivity(intent);
            }
        });
        btnMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MascotaActivity.class);
                startActivity(intent);
            }
        });


        return v;
    }
}