package com.spa.citas.controller;

import com.spa.citas.model.Cita;
import com.spa.citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    
    @PostMapping
    public ResponseEntity<?> agendarCita(@RequestBody Cita nuevaCita) {
        try {
            
            Cita citaGuardada = citaService.agendarCita(nuevaCita);
            return ResponseEntity.ok(citaGuardada); 

        } catch (RuntimeException e) {
            
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public java.util.List<Cita> obtenerCitas() {
        return citaService.obtenerTodasLasCitas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelarCita(@PathVariable Integer id) {
        citaService.cancelarCita(id);
        return ResponseEntity.ok("Cita cancelada correctamente");
    }

}
