package com.example.diego.parqueoencargado;

public class Auto {

    private String marca,modelo,color,cprv,estado;
    public Auto(String marca, String modelo, String color, String cprv, String estado) {
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;
        this.cprv=cprv;
        this.estado = estado;
    }

    public String getmarca() {
        return marca;
    }
    public void setmarca(String marca) {
        this.marca = marca;
    }

    public String getmodelo() {
        return modelo;
    }
    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }
    public String getcolor() {
        return color;
    }
    public void setcolor(String color) {
        this.color = color;
    }
    public String getcprv() {
        return cprv;
    }
    public void setcprv(String cprv) {
        this.cprv = cprv;
    }
    public String getestado() {
        return estado;
    }
    public void setestado(String estado) {
        this.estado = estado;
    }
    public Auto() { /*Se requiere de un constructor vacío por sintaxis, de no tenerlo la aplicación hará crash*/
    }
}
