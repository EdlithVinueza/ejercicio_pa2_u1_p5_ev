package com.uce.edu.matricula.repository;

import com.uce.edu.matricula.repository.modelo.Matricula;
import com.uce.edu.matricula.repository.modelo.Vehiculo;

public interface IMatriculaRepository {

	public Matricula selecionar(String placa);

	public void insertar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminar(String placa);

}
