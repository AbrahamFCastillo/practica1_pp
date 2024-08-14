package com.ejercicio.service;

import java.util.List;

import com.ejercicio.exception.ServiceException;
import com.ejercicio.model.Automovil;

public interface AutomovilService { 
    public void ingresaAutomovil(Automovil Automovil) throws ServiceException;
	
	public List<Automovil> consultaAutomoviles() throws ServiceException; 
	
	public void actualizaAutomovil(Automovil Automovil) throws ServiceException;
	
	public void eliminaAutomovil(Integer id) throws ServiceException;
	
	public Automovil consultaAutomovil(Integer id) throws ServiceException;
} 


