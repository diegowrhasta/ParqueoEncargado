package com.example.diego.parqueoencargado;

public class UserInformation {


    public String nombre;
    public String apellido;
    public String ci;
    public String correo;
    public int puntos;



    public UserInformation(){

    }
    public String getnombre(){
        return nombre;
    }
    public int getpuntos(){
        return puntos;
    }

    public UserInformation(String nombre, String apellido, String ci, String correo, int puntos) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.ci=ci;
        this.correo=correo;
        this.puntos=puntos;
    }

}
