package com.example.diego.parqueoencargado;

public class Encargado { //Todos estos atributos son los registrados en Firebase, vale recalcar que son Case Sensitive, hay que respetar minúscula de mayúscula para trabajarlos de buena manera
    private String calle_activa;
    private String fecha_nac;
    private String nombre;
    private String telefono;

    public Encargado(String calle_activa, String fecha_nac, String nombre, String telefono) {
        this.calle_activa = calle_activa;
        this.fecha_nac = fecha_nac;
        this.nombre = nombre;
        this.telefono = telefono;
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
}