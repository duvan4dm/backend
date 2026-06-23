package com.spa.citas.service;

import com.spa.citas.model.Cita;
import com.spa.citas.model.Usuario;
import com.spa.citas.repository.CitaRepository;
import com.spa.citas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //metodo que usare en react
    public Cita agendarCita(Cita nuevaCita) {

        
        if (citaRepository.existsByFechaAndHora(nuevaCita.getFecha(), nuevaCita.getHora())) {
            
            throw new RuntimeException("Lo sentimos, este horario ya está ocupado. Por favor elige otro.");
        }

        
        Usuario usuarioGuardado = usuarioRepository.save(nuevaCita.getUsuario());
        nuevaCita.setUsuario(usuarioGuardado);

        
        nuevaCita.setEstado("CONFIRMADA");

        
        return citaRepository.save(nuevaCita);
    }



    public java.util.List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }

    
    public void cancelarCita(Integer idCita) {
        citaRepository.deleteById(idCita);
    }

}
