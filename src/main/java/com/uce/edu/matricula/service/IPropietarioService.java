package com.uce.edu.matricula.service;

import com.uce.edu.matricula.repository.modelo.Propietario;

public interface IPropietarioService {

	public Propietario buscar(String cedula);

	public void guardar(Propietario propietario);

	public void actualizar(Propietario propietario);

	public void borrar(String placa);

}
