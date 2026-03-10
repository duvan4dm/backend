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

        //verificar si la fecha y hora ya estan ocupadas
        if (citaRepository.existsByFechaAndHora(nuevaCita.getFecha(), nuevaCita.getHora())) {
            //si ya existe lanzamos un error que React mostrara al cliente
            throw new RuntimeException("Lo sentimos, este horario ya está ocupado. Por favor elige otro.");
        }

        //guardando los datos del cliente (usuario) en la base de datos primero
        Usuario usuarioGuardado = usuarioRepository.save(nuevaCita.getUsuario());
        nuevaCita.setUsuario(usuarioGuardado);

        //confirmar la cita
        nuevaCita.setEstado("CONFIRMADA");

        //Guardar la cita final en la base de datos
        return citaRepository.save(nuevaCita);
    }


    //obtener las citas para mostrar en react
    public java.util.List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }

    //borrar cita por ID
    public void cancelarCita(Integer idCita) {
        citaRepository.deleteById(idCita);
    }

}
