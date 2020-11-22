package com.upc.hospedajeparaperroswau.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Sesiones {
    private  String PREFS_KEY= "mispreferencias";

    public  void guardarValor(Context context, String keyPref, String valor) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putString(keyPref, valor);
        editor.commit();
    }

    public  String leerValor(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, context.MODE_PRIVATE);
        return  preferences.getString(keyPref, "");
    }


}
