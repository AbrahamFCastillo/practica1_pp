package com.ejercicio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.mapper.AutomovilMapper;
import com.ejercicio.model.Automovil;
import com.ejercicio.service.AutomovilService;

import java.util.List;

@Service
public class AutomovilServiceImpl implements AutomovilService {
    @Autowired
    AutomovilMapper automovilMapper; 

    @Override
    @Transactional
    public void ingresaAutomovil(Automovil automovil) throws RuntimeException {
        try {
            automovilMapper.ingresaAutomovil(automovil);
        } catch (Exception e) {
			throw new RuntimeException("Error al insertar el automovil");
        }
    }

    @Override
    public List<Automovil> consultaAutomoviles() throws RuntimeException {
        List<Automovil> Automoviles = null;
		try {
			Automoviles = automovilMapper.consultaAutomoviles();
		} catch (Exception e) {
			throw new RuntimeException("Error al consultar registros");
		}
		return Automoviles;    
    }
    
    @Override
    @Transactional
    public void actualizaAutomovil(Automovil Automovil) throws RuntimeException {
        try {
            if (Automovil.getId() == null) {
				throw new RuntimeException("Es requerido el ID.");
            }
            else {
                Automovil consulta = this.consultaAutomovil(Automovil.getId()); 
                if (consulta == null) {
					throw new RuntimeException("El Automovil no existe."); 
                }
                automovilMapper.actualizaAutomovil(Automovil); 
            }
        } catch (Exception e) {
			throw new RuntimeException("Error al actualizar Automovil");
        }    
    }

    @Override
    @Transactional
    public void eliminaAutomovil(Integer id) throws RuntimeException {
        try {
			automovilMapper.eliminaAutomovil(id);
		} catch (Exception e) {
			throw new RuntimeException("Error al eliminar Automovil");
		}
    }

    @Override
    public Automovil consultaAutomovil(Integer id) throws RuntimeException {
        Automovil Automovil = null;
		try {
			Automovil = automovilMapper.consultaAutomovil(id);
		} catch (Exception e) {
			throw new RuntimeException("Error al consultar registro");
		}
		return Automovil;
    }
    
}
