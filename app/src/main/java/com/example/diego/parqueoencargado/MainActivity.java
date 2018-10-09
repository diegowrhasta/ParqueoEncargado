package com.example.diego.parqueoencargado;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    private EditText Contrasena, Codigo;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            //close this activity
            finish();
            //opening profile activity
            startActivity(new Intent(getApplicationContext(), Sesion.class));
        }
        firebaseAuth = FirebaseAuth.getInstance();
        Codigo = (EditText) findViewById(R.id.codigo);
        Contrasena = (EditText) findViewById(R.id.contrasena);
        progressDialog = new ProgressDialog(this);
    }
    public void ingresar(View view) {
        Log.e("Hello", "Eres");
        String email = Codigo.getText().toString().trim();
        String password = Contrasena.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Ingrese su correo", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Ingrese su contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Ingresando...");
        progressDialog.show();


        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {

                            finish();
                            startActivity(new Intent(getApplicationContext(), Sesion.class));

                        } else {
                            Toast.makeText(MainActivity.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                            return;
                        }


                    }
                });
    }
}
