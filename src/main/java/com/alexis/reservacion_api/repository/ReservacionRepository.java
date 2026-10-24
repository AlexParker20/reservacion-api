package com.alexis.reservacion_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alexis.reservacion_api.modelo.Reservacion;

public interface ReservacionRepository extends JpaRepository<Reservacion, String> {
}