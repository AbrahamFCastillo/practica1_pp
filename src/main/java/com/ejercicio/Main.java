package com.ejercicio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ejercicio.config.AppConfig;
import com.ejercicio.exception.ServiceException;
import com.ejercicio.model.Automovil;
import com.ejercicio.service.AutomovilService;

public class Main {
    public static void main(String[] args) throws ServiceException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AutomovilService automovilService = context.getBean(AutomovilService.class);

        Automovil automovil = new Automovil();
		automovil.setMarca("Volkswagen");
		automovil.setModelo("Golf GTI");
        automovil.setanioFabricacion(1976);

        //Insertar automovil
        automovilService.ingresaAutomovil(automovil);
        System.out.println("Automovil insertado: " + automovil.getModelo());

        //Consultar automovil
        Automovil automovilRec= automovilService.consultaAutomovil(automovil.getId());
        System.out.println("Automovil recuperado: " + automovilRec.getModelo());


        context.close();
    } 
}
