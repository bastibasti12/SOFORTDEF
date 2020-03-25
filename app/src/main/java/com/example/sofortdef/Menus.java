package com.example.sofortdef;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sofortdef.fragments_nav.cuentafragment;
import com.example.sofortdef.fragments_nav.lineasfragment;
import com.example.sofortdef.fragments_nav.menufragment;
import com.example.sofortdef.fragments_nav.paradasfragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Menus extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btmnavi); /// ESTE ES EL XML DE LA PANTALLA
        mMainNav=(BottomNavigationView)findViewById(R.id.main_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame,new menufragment()).commit();
        /// EN LA LINEA DE ARRIBA SE COLOCA EL FRAGMENT QUE SE MOSTRARA AL INICIALIZAR LOS MENUS(LUEGO DE LOGEARSE)

        /// CON ESTE METODO SE PUEDE NAVEGAR ENTRE LOS FRAGMENTS DEL MENU MEDIANTE UN SWITCH
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_menu:
                        selectedFragment= new menufragment();
                        break;
                    case R.id.nav_paradas:
                        selectedFragment= new paradasfragment();
                        break;
                    case R.id.nav_lineas:
                        selectedFragment= new lineasfragment();
                        break;
                    case R.id.nav_cuenta:
                        selectedFragment= new cuentafragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame,selectedFragment).commit();
                return true;
            }
        });
    }
}
