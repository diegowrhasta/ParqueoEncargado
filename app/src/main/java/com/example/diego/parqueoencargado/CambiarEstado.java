package com.example.diego.parqueoencargado;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class CambiarEstado extends AppCompatActivity {
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    static String par="";
    TextView tv1;
    EditText et1;
    static private DatabaseReference myRef;
    static int posicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_estado);
        tv1= findViewById(R.id.tv1);
        et1= findViewById(R.id.et1);
        Bundle datos = this.getIntent().getExtras();
        posicion = datos.getInt("posicion");


        if(posicion==0){par="A1";}
        if(posicion==1){par="A2";}
        if(posicion==2){par="A3";}
        if(posicion==3){par="M1";}
        if(posicion==4){par="M2";}
        if(posicion==5){par="M3";}
        if(posicion==6){par="M4";}
        if(posicion==7){par="M5";}
        if(posicion==8){par="M6";}
        if(posicion==9){par="M7";}
        if(posicion==10){par="M8";}
        if(posicion==11){par="M9";}

        Query query = FirebaseDatabase.getInstance().getReference().child("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child(par); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        query.addValueEventListener(new ValueEventListener() {
            String aux="";
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Parqueo value = dataSnapshot.getValue(Parqueo.class);
                if (value.getEstado().equals("Ocupado")) {
                    et1.setEnabled(true);

                }
                if (value.getEstado().equals("Libre")) {
                    et1.setEnabled(false);
                }
                if (value.getEstado().equals("Reservado")) {
                    et1.setEnabled(false);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void cambiar(View view){








        Query query = FirebaseDatabase.getInstance().getReference().child("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child(par); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        query.addValueEventListener(new ValueEventListener() {
            String aux="";
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (aux.equals("")) {
                    Parqueo value = dataSnapshot.getValue(Parqueo.class);
                    if (value.getEstado().equals("Ocupado")) {


                        DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("Historial").child(Calendar.getInstance().getTime()+" ");
                        myRef1.child("hora_fin").setValue(Calendar.getInstance().getTime()+" ");
                        myRef1.child("hora_inicio").setValue(value.getHora_inicio());
                        myRef1.child("placa").setValue(value.getPlaca());
                        myRef1.child("parqueo").setValue(par);


                        myRef = FirebaseDatabase.getInstance().getReference().child("Cliente").child("Parqueo").child("Calle_2").child("Sector_A");
                        myRef.child(par).child("estado").setValue("Libre");
                        myRef.child(par).child("hora_fin").setValue("0");
                        myRef.child(par).child("hora_inicio").setValue("0");
                        myRef.child(par).child("hora_reserva").setValue("0");
                        myRef.child(par).child("placa").setValue("0");
                        myRef.child(par).child("usuario").setValue("0");
                        Toast.makeText(getApplicationContext(), "Cambio de estado con exito", Toast.LENGTH_SHORT).show();
                        aux = "as";
                        finish();

                    }
                    if (value.getEstado().equals("Libre")) {
                        myRef = FirebaseDatabase.getInstance().getReference().child("Cliente").child("Parqueo").child("Calle_2").child("Sector_A");
                        myRef.child(par).child("estado").setValue("Ocupado");
                        myRef.child(par).child("hora_fin").setValue("0");
                        myRef.child(par).child("hora_inicio").setValue(Calendar.getInstance().getTime()+" ");
                        myRef.child(par).child("hora_reserva").setValue("0");
                        myRef.child(par).child("placa").setValue(et1.getText()+"");
                        myRef.child(par).child("usuario").setValue("0");
                        Toast.makeText(getApplicationContext(), "Cambio de estado con exito", Toast.LENGTH_SHORT).show();
                        aux = "as";
                        finish();
                    }
                    if (value.getEstado().equals("Reservado")) {
                        myRef = FirebaseDatabase.getInstance().getReference().child("Cliente").child("Parqueo").child("Calle_2").child("Sector_A");
                        myRef.child(par).child("estado").setValue("Ocupado");
                        myRef.child(par).child("hora_fin").setValue("0");
                        myRef.child(par).child("hora_inicio").setValue(Calendar.getInstance().getTime()+" ");
                        myRef.child(par).child("hora_reserva").setValue("0");
                        myRef.child(par).child("placa").setValue(et1.getText()+"");
                        myRef.child(par).child("usuario").setValue("0");
                        Toast.makeText(getApplicationContext(), "Cambio de estado con exito", Toast.LENGTH_SHORT).show();
                        aux = "as";
                        finish();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public static void historia(){

        Query query = FirebaseDatabase.getInstance().getReference().child("Cliente").child("Parqueo").child("Calle_2").child("Sector_A").child(par); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Parqueo value = dataSnapshot.getValue(Parqueo.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
