package com.upc.hospedajeparaperroswau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ReservaActivity extends AppCompatActivity {

    Spinner cboMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        Spinner spinnerM = (Spinner) findViewById(R.id.cboMascota);
        ArrayAdapter<CharSequence> adapterM = ArrayAdapter.createFromResource(this, R.array.pets_array, android.R.layout.simple_spinner_item);
        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerM.setAdapter(adapterM);

        Spinner spinnerS = (Spinner) findViewById(R.id.cboServicio);
        ArrayAdapter<CharSequence> adapterS = ArrayAdapter.createFromResource(this, R.array.servicio_array, android.R.layout.simple_spinner_item);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerS.setAdapter(adapterS);

    }
}