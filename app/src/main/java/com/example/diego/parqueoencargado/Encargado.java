package com.example.diego.parqueoencargado;

public class Encargado { //Todos estos atributos son los registrados en Firebase, vale recalcar que son Case Sensitive, hay que respetar minúscula de mayúscula para trabajarlos de buena manera
    public String calle_activa;
    public String correo;
    public String fecha_nac;
    public String nombre;
    public String password;
    public String sector;
    public String telefono;

    public Encargado(String calle_activa, String correo, String fecha_nac, String nombre, String password, String sector, String telefono) {
        this.calle_activa = calle_activa;
        this.correo = correo;
        this.fecha_nac = fecha_nac;
        this.nombre = nombre;
        this.password = password;
        this.sector = sector;
        this.telefono = telefono;
    }

    public Encargado() {
    }

    public String getCalle_activa() {
        return calle_activa;
    }

    public void setCalle_activa(String calle_activa) {
        this.calle_activa = calle_activa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}