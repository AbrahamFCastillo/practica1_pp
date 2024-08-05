package com.ejercicio.mapper.test.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test; 
import org.junit.runner.RunWith; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ejercicio.config.AppConfig;
import com.ejercicio.mapper.AutomovilMapper;
import com.ejercicio.model.Automovil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AutomovilMapperTest {
    @Autowired
    private AutomovilMapper automovilMapper;

    @Test
	public void ingresaAutomovilTest(){  
		Assert.assertNotNull(automovilMapper);
		
		try {
			Automovil automovil = new Automovil();
			automovil.setMarca("Volkswagen");
			automovil.setModelo("Golf GTI");
            automovil.setanioFabricacion(1976);

			automovilMapper.ingresaAutomovil(automovil);  
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}			
	}

    @Test
	public void consultaAutomovilesTest(){
		Assert.assertNotNull(automovilMapper);
		List<Automovil> automoviles = null;
		
		try {
			automoviles=automovilMapper.consultaAutomoviles();	
			Assert.assertNotNull(automoviles);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

    @Test
	public void actualizaAutomovil(){
		Assert.assertNotNull(automovilMapper);
		
		try {
			Automovil automovil = new Automovil();
			automovil.setId(16);
			automovil.setMarca("Hyundai");
			automovil.setModelo("Elantra N");
            automovil.setanioFabricacion(2022);
			
			automovilMapper.actualizaAutomovil(automovil);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}			
	}

    @Test
	public void eliminaAutomovil(){
		Assert.assertNotNull(automovilMapper);
		
		try {
			automovilMapper.eliminaAutomovil(3);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}

}
