package com.example.sofortdef.fragments_nav;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sofortdef.MainActivity;
import com.example.sofortdef.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class cuentafragment extends Fragment {

    private Button btnCerrar;
    private TextView textBienve;

    private FirebaseAuth cAuth;
    private DatabaseReference dbRef;

    private String id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cuentafragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cAuth = FirebaseAuth.getInstance();
        id= cAuth.getCurrentUser().getUid();
        textBienve=(TextView)getView().findViewById(R.id.textBienv);
        dbRef= FirebaseDatabase.getInstance().getReference();
        /*dbRef.child("Usuarios").addValueEventListener(new ValueEventListener() { /// AQUI SE OBTIENE EL EL NOMBRE DE LA CUENTA A TRAVES DE SU UID
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String nombre= dataSnapshot.child(id).child("name").getValue().toString();
                    textBienve.setText("¡Bienvenido "+nombre+"!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
        btnCerrar=(Button)getView().findViewById(R.id.btnCerrarSesion);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { /// CON ESTE METODO SE CIERRA LA SESION DEL USUARIO Y SE LLEVA A LA PANTALLA DE LOGIN
                cAuth.signOut();
                startActivity(new Intent(view.getContext(), MainActivity.class));
                getActivity().finish();
            }
        });
    }
}
