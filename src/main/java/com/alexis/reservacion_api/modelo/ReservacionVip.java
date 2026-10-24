package com.alexis.reservacion_api.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservacionVip extends Reservacion {
    private int descuento;
    private String mesero;


    public ReservacionVip(String id, String cliente, int mesa, LocalDate fecha, LocalTime hora, EstadoReservacion estado, int descuento, String mesero) {
        super(id, cliente, mesa, fecha, hora, estado);
        this.descuento = descuento;
        this.mesero = mesero;
    }

    public void setDescuento(int descuento){
        this.descuento=descuento;
    }

    public int getDescuento(){
        return descuento;
    }

    public void setMesero(String mesero){
        this.mesero=mesero;
    }

    public String getMesero(){
        return mesero;
    }

    @Override
    public String mostrarReservacion(){
        return super.mostrarReservacion() + "\ncon descuento: " + descuento + "%" + "\nmesero asignado: " + mesero;
    }

    

}
