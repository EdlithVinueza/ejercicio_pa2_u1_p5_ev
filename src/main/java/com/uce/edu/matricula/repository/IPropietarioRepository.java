package com.uce.edu.matricula.repository;

import com.uce.edu.matricula.repository.modelo.Propietario;

public interface IPropietarioRepository {

	public Propietario selecionar(String cedula);

	public void insertar(Propietario propietario);

	public void actualizar(Propietario propietario);

	public void eliminar(String placa);

}
