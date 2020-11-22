package com.upc.hospedajeparaperroswau.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.upc.hospedajeparaperroswau.R;
import com.upc.hospedajeparaperroswau.utils.Sesiones;

import org.json.JSONException;
import org.json.JSONObject;


public class ConfiguracionFragment extends Fragment {

    TextView lblNombreC,lblCorreoC;


    public ConfiguracionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_configuracion, container, false);
        Sesiones s= new Sesiones();

        lblNombreC=v.findViewById(R.id.lblNombreC);
        lblCorreoC=v.findViewById(R.id.lblCorreoC);

        String  usu=s.leerValor(getContext(),"usuario");
        try {
            JSONObject objeto = new JSONObject(usu);
            if(objeto!=null){

                lblNombreC.setText(objeto.getString("nomsUsu"));
                lblCorreoC.setText(objeto.getString("emailUsu"));
            }
        } catch (JSONException e) {

            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        return v;
    }
}