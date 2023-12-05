package com.uce.edu.matricula.service;

import com.uce.edu.matricula.repository.modelo.Vehiculo;

public interface IVehiculoService {

	public Vehiculo guardar(String placa);

	public void guardar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void borrar(String placa);

}
