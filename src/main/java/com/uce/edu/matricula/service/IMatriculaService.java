package com.uce.edu.matricula.service;

import com.uce.edu.matricula.repository.modelo.Matricula;
import com.uce.edu.matricula.repository.modelo.Propietario;
import com.uce.edu.matricula.repository.modelo.Vehiculo;

public interface IMatriculaService {

	public Matricula buscar(String placa);

	public void guardar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void borrar(String placa);

	public void generarMatricula(String cedula, String placa);

}
