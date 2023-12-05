package com.uce.edu.matricula.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.matricula.repository.IMatriculaRepository;
import com.uce.edu.matricula.repository.IPropietarioRepository;
import com.uce.edu.matricula.repository.IVehiculoRepository;
import com.uce.edu.matricula.repository.modelo.Matricula;
import com.uce.edu.matricula.repository.modelo.Propietario;
import com.uce.edu.matricula.repository.modelo.Vehiculo;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public Matricula buscar(String placa) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.selecionar(placa);
	}

	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.actualizar(matricula);

	}

	@Override
	public void borrar(String placa) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.eliminar(placa);

	}

	@Override
	public void generarMatricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		// Calculos de valor dematrícula
		// Calculamos el nuevo Valor
		Propietario propietario = this.iPropietarioRepository.selecionar(cedula);
		Vehiculo vehiculo = this.iVehiculoRepository.selecionar(placa);
		
		if (propietario!=null && vehiculo !=null) {
		BigDecimal nuevoValor = null;
		if (vehiculo.getTipo().equals("pesado")) {
			nuevoValor = vehiculo.getPrecio().multiply(new BigDecimal(0.25));
		} else if (vehiculo.getTipo().equals("liviano")) {
			nuevoValor = vehiculo.getPrecio().multiply(new BigDecimal(0.20));
		} else {
			System.err.println("El vehiculo ingresado no tiene el tipo solicitado");
		}
		// Vemos si no superamos los 2000
		if (nuevoValor.compareTo(new BigDecimal(2000)) == 1) { // si es mayor a 2000 compareTo dara 1
			nuevoValor = nuevoValor.subtract(nuevoValor.multiply(new BigDecimal(0.05)));
		}

		// Creamos la Matricula
		Matricula tmp = new Matricula();
		tmp.setFecha(LocalDateTime.now());
		tmp.setPropietario(propietario);
		tmp.setValorMatricula(nuevoValor);
		tmp.setVehiculo(vehiculo);

		this.guardar(tmp);

		System.out.println("Se genero la matricula: " + tmp);
		}
		else {
			System.out.println("DATOS INVALIDOS, NO EXISTE UN REGISTRO");
		}

	}

}
