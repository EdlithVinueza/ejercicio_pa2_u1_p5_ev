package com.uce.edu.matricula.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matricula.repository.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	private List<Propietario> base = new ArrayList<Propietario>();

	@Override
	public Propietario selecionar(String cedula) {
		// TODO Auto-generated method stub
		for (Propietario propietario : base) {
			if (propietario.getCedula().equals(cedula)) {
				Propietario tmp = new Propietario();
				tmp.setApellido(propietario.getApellido());
				tmp.setCedula(propietario.getCedula());
				tmp.setGenero(propietario.getGenero());
				tmp.setNombre(propietario.getNombre());
				return tmp;
			}
		}

		return null;
	}

	public Propietario selecionarEliminar(String cedula) {
		for (Propietario propietario : base) {
			if (propietario.getCedula().equals(cedula)) {
				return propietario;
			}
		}
		return null;
	}

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		base.add(propietario);

	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.eliminar(propietario.getCedula());
		this.insertar(propietario);

	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Propietario tmp = this.selecionarEliminar(cedula);
		base.remove(tmp);

	}

}
