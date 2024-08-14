package com.ejercicio.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejercicio.Constantes;
import com.ejercicio.exception.ServiceException;
import com.ejercicio.mapper.AutomovilMapper;
import com.ejercicio.model.Automovil;
import com.ejercicio.service.AutomovilService;

import java.util.List;

@Service
public class AutomovilServiceImpl implements AutomovilService {
    @Autowired 
    AutomovilMapper automovilMapper; 

    public Log log = LogFactory.getLog(AutomovilServiceImpl.class);

    @Override
    @Transactional
    public void ingresaAutomovil(Automovil automovil) throws ServiceException {
        try {
            automovilMapper.ingresaAutomovil(automovil);
        } catch (Exception e) {
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_AGREGAR, "Error al agregar Automovil");
        }
    }

    @Override
    public List<Automovil> consultaAutomoviles() throws ServiceException {
        List<Automovil> Automoviles = null;
		try {
			Automoviles = automovilMapper.consultaAutomoviles();
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registros");
		}
		return Automoviles;    
    }
    
    @Override
    @Transactional
    public void actualizaAutomovil(Automovil Automovil) throws ServiceException {
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
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			if(e instanceof RuntimeException) {
				throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar Automovil, "+e.getMessage());
			}
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar Automovil");
        }      
    }

    @Override
    @Transactional
    public void eliminaAutomovil(Integer id) throws ServiceException {
        try {
			automovilMapper.eliminaAutomovil(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al eliminar Automovil");
		}
    }

    @Override
    public Automovil consultaAutomovil(Integer id) throws ServiceException {
        Automovil Automovil = null;
		try {
			Automovil = automovilMapper.consultaAutomovil(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registro");
		}
		return Automovil;
    }
    
}
