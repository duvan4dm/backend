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

    //cuando React haga una peticion POST enviando datos se ejecuta esto
    @PostMapping
    public ResponseEntity<?> agendarCita(@RequestBody Cita nuevaCita) {
        try {
            // Intentamos guardar la cita usando el servicio que creamos antes
            Cita citaGuardada = citaService.agendarCita(nuevaCita);
            return ResponseEntity.ok(citaGuardada); // Devolvemos un 200 OK y los datos de la cita

        } catch (RuntimeException e) {
            // Si el servicio lanza un error (ej. horario ocupado), devolvemos un 400 Bad Request
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
