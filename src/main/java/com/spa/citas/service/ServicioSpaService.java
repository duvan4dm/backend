package com.spa.citas.service;

import com.spa.citas.model.Servicio;
import com.spa.citas.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioSpaService {

    @Autowired // Inyecta (trae) el repositorio que creamos antes
    private ServicioRepository servicioRepository;

    // Método para obtener todos los servicios y mostrarlos en React
    public List<Servicio> obtenerTodosLosServicios() {
        return servicioRepository.findAll();
    }

}
