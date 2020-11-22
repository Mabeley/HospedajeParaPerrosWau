package com.upc.hospedajeparaperroswau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.upc.hospedajeparaperroswau.Fragments.ConfiguracionFragment;
import com.upc.hospedajeparaperroswau.Fragments.FavoritoFragment;
import com.upc.hospedajeparaperroswau.Fragments.InicioFragment;
import com.upc.hospedajeparaperroswau.Fragments.UbicacionFragment;

public class MenuActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bottomNavigationView=findViewById(R.id.botton_navegation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        //Abrir el fragment principal
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new InicioFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment =null;
            switch (item.getItemId()){
                case R.id.nav_inicio:
                    selectedFragment=new InicioFragment();
                    break;
                case R.id.navigation_ubicacion:
                    selectedFragment=new UbicacionFragment();
                    break;
                case R.id.navigation_favorito:
                    selectedFragment=new FavoritoFragment();
                    break;
                case R.id.navigation_configuracion:
                    selectedFragment=new ConfiguracionFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            return true;
        }
    };

}