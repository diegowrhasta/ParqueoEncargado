package com.example.diego.parqueoencargado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

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

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        firebaseAuth = FirebaseAuth.getInstance();



        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, MainActivity.class));
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("Cliente");
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        tipo=findViewById(R.id.tipo);
        Query query = FirebaseDatabase.getInstance().getReference("Cliente").child(currentFirebaseUser.getUid()).child("Usuario");
                query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Encargado usuario=dataSnapshot.getValue(Encargado.class);
                tipo.setText("" + usuario.getTipo());
                //Verificamos que el usuario sea encargado
               if(usuario.getTipo().equals("UsuarioEncargado")){

                finish();
                   startActivity(new Intent(getApplicationContext(), Bienvenido.class));



                   return;
                }
                else
                {
                    firebaseAuth.signOut();
                    //closing activity
                    finish();
                    //starting MainActivity
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    Toast.makeText(Sesion.this, "Usted no es encargado \nFavor use la aplicación normal", Toast.LENGTH_SHORT).show();
                }


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
