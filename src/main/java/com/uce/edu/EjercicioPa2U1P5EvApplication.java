package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.matricula.repository.modelo.Propietario;
import com.uce.edu.matricula.repository.modelo.Vehiculo;
import com.uce.edu.matricula.service.IMatriculaService;
import com.uce.edu.matricula.service.IPropietarioService;
import com.uce.edu.matricula.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5EvApplication implements CommandLineRunner {
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	
	@Autowired
	private IVehiculoService iVehiculoService;
	

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5EvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Marca 1");
		vehiculo.setPlaca("ASD-123");
		vehiculo.setPrecio(new BigDecimal(5000));
		vehiculo.setTipo("pesado");
		this.iVehiculoService.guardar(vehiculo);
		
		
		Propietario propietario = new Propietario();
		propietario.setApellido("Perez");
		propietario.setCedula("1751674021");
		propietario.setGenero("Masculino");
		propietario.setNombre("Juan");
		
		this.iPropietarioService.guardar(propietario);
		propietario.setApellido("Vinueza");
		propietario.setNombre("Emanuel");
		
		this.iPropietarioService.actualizar(propietario);
		
		this.iMatriculaService.generarMatricula("1751674021", "ASD-123");
		
		
	}

}

