package com.example.diego.parqueoencargado;

public class Encargado { //Todos estos atributos son los registrados en Firebase, vale recalcar que son Case Sensitive, hay que respetar minúscula de mayúscula para trabajarlos de buena manera
    public String calle_activa;
    public String fecha_nac;
    public String nombre;
    public String telefono;
    public String tipo;
    public Encargado(){

    }
    public Encargado(String calle_activa, String fecha_nac, String nombre, String telefono, String tipo) {
        this.calle_activa = calle_activa;
        this.fecha_nac = fecha_nac;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public String getCalle_activa() {
        return calle_activa;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipo() {
        return tipo;
    }
}