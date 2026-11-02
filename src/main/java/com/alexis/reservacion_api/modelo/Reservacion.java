package com.alexis.reservacion_api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;



@Entity
public class Reservacion{
    @Id
    private String id;
    private String cliente;
    private int mesa;
    private LocalDate fecha;
    private LocalTime hora;
    @Enumerated(EnumType.STRING)
    private EstadoReservacion estado;

    public Reservacion(){
         // constructor vacío, necesario para que Spring/Jackson pueda crear el objeto desde JSON
    }    

    
    public Reservacion(String id,String cliente, int mesa, LocalDate fecha, LocalTime hora, EstadoReservacion estado){
        this.id = id;
        this.cliente = cliente;
        this.mesa = mesa;
        this.fecha = fecha;
        this.hora = hora;
        this.estado= estado;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getId(){
        return id;
    }


    public void setCliente(String cliente){
        this.cliente=cliente;
    }

    public String getCliente(){
        return cliente;
    }

    public void setMesa(int mesa){
        this.mesa=mesa;
    }

    public int getMesa(){
        return mesa;
    }

    public void setFecha(LocalDate fecha){
        this.fecha=fecha;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public void setHora(LocalTime hora){
        this.hora=hora;
    }

    public LocalTime getHora(){
        return hora;
    }    

    public void setEstado(EstadoReservacion estado){
        this.estado=estado;
    }

    public EstadoReservacion getEstado(){
        return estado;
    }




    public String mostrarReservacion(){
        return "La reservación con ID de: "+ id + "\n"
        + "para el cliente: " + cliente + "\n" 
        + "es a las: " + hora + "\n" 
        + "para el día: " + fecha + "\n"
        + "en la mesa: " + mesa + "\n"
        + "y su estado es: " + estado;
    }    

    
}


