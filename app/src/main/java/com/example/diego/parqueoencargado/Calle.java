package com.example.diego.parqueoencargado;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class Calle extends Fragment {

    ListView listaReporte;
    FirebaseListAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calle, container, false);


        listaReporte = (ListView)view.findViewById(R.id.listview);
        Query query = FirebaseDatabase.getInstance().getReference().child("Cliente").child("Parqueo").child("Calle_2").child("Sector_A"); //Se hace un pequeño Query a la base de datos para poner un puntero en el objeto de encargados
        FirebaseListOptions<Parqueo> options = new FirebaseListOptions.Builder<Parqueo>() //Este parámetro es el que nutre al Adaptador de Firebase para colocar los valores del Query
                .setLayout(R.layout.calle)
                .setQuery(query,Parqueo.class)
                .build();
        adapter = new FirebaseListAdapter(options) { //El adaptador de Firebase para aplicarlo al item personalizado que hicimos: encargado.xml para los items del el listview en ListaEncargados
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) { //Esta funcion comienza a llenar los cambos del list view
                TextView espacio = v.findViewById(R.id.espacio);
                TextView estado = v.findViewById(R.id.estado); /*Primero asigna los objectos con sus identificadores de encargado.xml */
                TextView placa = v.findViewById(R.id.placa);

                Parqueo enc = (Parqueo) model; //El modelo es el cual se obtiene desde Firebase; del objeto: Con sus atributos, acá es donde entra la parte de case sensitive, si los nombres
                // de la clase local y los nombres en firebase difieren surgirá un error.
                espacio.setText("Lugar: "+enc.getEspacio().toString()); /*Todos los valores los estamos manejando como Strings para facilitar el uso */
                estado.setText("Estado: "+enc.getEstado().toString()+"    Calle 2");
                placa.setText("Placa: "+enc.getPlaca().toString());
            }
        };
        listaReporte.setAdapter(adapter); /*Una vez todos los valores se obtienen se lo aplican al listview que tenemos en la actividad */


        listaReporte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getContext(),CambiarEstado.class);
                intent.putExtra("posicion",i);
                startActivity(intent);

            }
        });
        return view; }



    @Override
    public void onStart() { /*Metodos necesarios para que la funcion populateView pueda ser llamada y corra el llenado estando en la actividad, y cuando se salga pare con la función de igual manera*/
        super.onStart();
        adapter.startListening();
    }
    //List changes okay
    //Check
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}