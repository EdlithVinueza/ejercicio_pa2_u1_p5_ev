package com.uce.edu.matricula.repository;

import com.uce.edu.matricula.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public Vehiculo selecionar(String placa);

	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);

}


