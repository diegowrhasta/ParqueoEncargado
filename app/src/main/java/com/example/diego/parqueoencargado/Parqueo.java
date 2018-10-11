package com.example.diego.parqueoencargado;

public class Parqueo {
    public String espacio,estado,hora_fin,hora_inicio,hora_reserva,placa,usuario;
    public Parqueo(){

    }

    public Parqueo(String espacio, String estado, String hora_fin, String hora_inicio, String hora_reserva, String placa, String usuario) {
        this.espacio = espacio;
        this.estado = estado;
        this.hora_fin = hora_fin;
        this.hora_inicio = hora_inicio;
        this.hora_reserva = hora_reserva;
        this.placa = placa;
        this.usuario = usuario;
    }

    public String getEspacio() {
        return espacio;
    }

    public String getEstado() {
        return estado;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public String getHora_reserva() {
        return hora_reserva;
    }

    public String getPlaca() {
        return placa;
    }

    public String getUsuario() {
        return usuario;
    }
}
