package com.upc.hospedajeparaperroswau.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.upc.hospedajeparaperroswau.R;


public class FavoritoFragment extends Fragment {

    ImageButton imgBtnTelefoo,imgBtnMenaje,imgBtnCorreo;

    public FavoritoFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View n=inflater.inflate(R.layout.fragment_favorito, container, false);;
        imgBtnTelefoo= n.findViewById(R.id.imgBtnTelefoo);
        imgBtnMenaje= n.findViewById(R.id.imgBtnMenaje);
        imgBtnCorreo= n.findViewById(R.id.imgBtnCorreo);


        imgBtnMenaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarmensaje();
            }
        });
        imgBtnTelefoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 936035177"));
                startActivity(intent);
            }
        });

        imgBtnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        return  n;
    }


    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + "u201724161@upc.edu.pe"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta sobre Hospedaje");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Consulta");
        try {
            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "No email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void enviarmensaje() {
        String num= "+51969715287";
        String text ="Hola WAU, desearia mas información acerca de los precios y promociones";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_VIEW);
        String uri = "whatsapp://send?phone="+num+"&text="+text;
        sendIntent.setData(Uri.parse(uri));

        try {
            startActivity(sendIntent);
        } catch (android.content.ActivityNotFoundException ex) {

            ex.printStackTrace();
            Toast.makeText(getActivity(), "El dispositivo no tiene instalado WhatsApp", Toast.LENGTH_SHORT).show();
        }
    }




}