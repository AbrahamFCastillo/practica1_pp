package com.ejercicio.service;

import java.util.List;

import com.ejercicio.model.Automovil;

public interface AutomovilService { 
    public void ingresaAutomovil(Automovil Automovil) throws RuntimeException;
	
	public List<Automovil> consultaAutomoviles() throws RuntimeException; 
	
	public void actualizaAutomovil(Automovil Automovil) throws RuntimeException;
	
	public void eliminaAutomovil(Integer id) throws RuntimeException;
	
	public Automovil consultaAutomovil(Integer id) throws RuntimeException;
}


