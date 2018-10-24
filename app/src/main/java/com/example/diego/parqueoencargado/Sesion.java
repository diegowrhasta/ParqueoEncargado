package com.example.diego.parqueoencargado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.errorprone.annotations.Var;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Sesion extends AppCompatActivity {
    private TextView tipo;
    public String correo;
    public String pass;
    boolean encontrado=false;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        tipo=findViewById(R.id.tipo);

        myRef = FirebaseDatabase.getInstance().getReference("Encargado");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot artistSnapshot: dataSnapshot.getChildren()){
                    Encargado usuario= artistSnapshot.getValue(Encargado.class);
                    Log.e("Objeto",""+usuario.toString());
                    if(usuario.getCorreo().equals(VariablesGlobales.correo) && usuario.getPassword().equals(VariablesGlobales.password))
                    {
                        VariablesGlobales.NombreEncargado=usuario.getNombre();
                        encontrado=true;
                        break;
                    }
                }
                if(encontrado){
                    finish();
                    startActivity(new Intent(getApplicationContext(),Bienvenido.class));
                }
                else{
                    finish();
                    //starting MainActivity
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    Toast.makeText(Sesion.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
