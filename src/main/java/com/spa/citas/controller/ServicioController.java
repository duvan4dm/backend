package com.spa.citas.controller;

import com.spa.citas.model.Servicio;
import com.spa.citas.service.ServicioSpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*")
public class ServicioController {

    @Autowired
    private ServicioSpaService servicioSpaService;

    
    @GetMapping
    public List<Servicio> obtenerServicios() {
        return servicioSpaService.obtenerTodosLosServicios();
    }
}
