package com.alexis.reservacion_api.controller;

import com.alexis.reservacion_api.modelo.Reservacion;
import com.alexis.reservacion_api.service.ReservacionServicio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservaciones")
public class ReservacionController {

    private ReservacionServicio servicio;

    public ReservacionController(ReservacionServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Reservacion> obtenerTodas() {
        return servicio.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<String> crearReservacion(@RequestBody Reservacion reservacion) {
        boolean creado = servicio.crearReservacion(reservacion);
        if (creado) {
            return ResponseEntity.status(201).body("Reservación creada con éxito");
    }
    return ResponseEntity.status(409).body("El ID ya existe");
}

    @GetMapping("/{id}")
    public ResponseEntity<Reservacion> buscarPorId(@PathVariable String id) {
        Optional<Reservacion> encontrada = servicio.buscarPorId(id);
        if(encontrada.isPresent()){
            return ResponseEntity.ok(encontrada.get());
        }
        return ResponseEntity.notFound().build();        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable String id) {
        boolean eliminado = servicio.eliminarPorId(id);

        if (eliminado) {
            return ResponseEntity.ok("Todo ok"); 
            
        }
        return ResponseEntity.notFound().build();        
    }

}