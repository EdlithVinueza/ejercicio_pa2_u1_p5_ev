package com.uce.edu.matricula.repository.modelo;

import org.springframework.stereotype.Component;

@Component
public class Propietario {
	private String nombre;
	private String apellido;
	private String cedula;
	private String genero;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Propietarios [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", genero=" + genero
				+ "]";
	}

}
