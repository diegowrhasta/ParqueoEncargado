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
import com.google.errorprone.annotations.Var;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;


    //firebase auth object

    private FirebaseAuth firebaseAuth;

    //progress dialog

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
        //getting firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();



        et1 = (EditText) findViewById(R.id.codigo);
        et2 = (EditText) findViewById(R.id.contrasena);

    }

    public void ingresar(View view) {
        String email = et1.getText().toString().trim();
        String password = et2.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Ingrese su CI", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Ingrese su contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            VariablesGlobales.correo = email;
            VariablesGlobales.password = password;
        }
        et1.setText("");
        et2.setText("");
        finish();
        startActivity(new Intent(getApplicationContext(), Sesion.class));

    }

}