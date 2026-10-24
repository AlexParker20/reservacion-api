package com.alexis.reservacion_api.service;

import com.alexis.reservacion_api.modelo.Reservacion;
import com.alexis.reservacion_api.repository.ReservacionRepository;
import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ReservacionServicio {

    private ReservacionRepository repository;

    public ReservacionServicio(ReservacionRepository repository) {
        this.repository = repository;
    }

    public boolean crearReservacion(Reservacion reservacion) {

        if (repository.findById(reservacion.getId()).isPresent()) {
            return false;
        }

        repository.save(reservacion);
        return true;
    }

    public Optional<Reservacion> buscarPorId(String id) {
        return repository.findById(id);
    }

    public boolean eliminarPorId(String id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
    return false;
    }  

    public List<Reservacion> obtenerTodas() {
        return repository.findAll();
    }
}
