package com.uce.edu.matricula.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matricula.repository.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	private List<Matricula> base = new ArrayList<Matricula>();

	@Override
	public Matricula selecionar(String placa) {
		// TODO Auto-generated method stub
		for (Matricula matricula : base) {
			if (matricula.getVehiculo().getPlaca().equals(placa)) {
				Matricula tmp = new Matricula();
				tmp.setFecha(matricula.getFecha());
				tmp.setPropietario(matricula.getPropietario());
				tmp.setValorMatricula(matricula.getValorMatricula());
				tmp.setVehiculo(matricula.getVehiculo());
				return tmp;
			}
		}

		return null;
	}

	public Matricula selecionarEliminar(String placa) {
		for (Matricula matricula : base) {
			if (matricula.getVehiculo().getPlaca().equals(placa)) {
				return matricula;
			}
		}
		return null;
	}

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		base.add(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.eliminar(matricula.getVehiculo().getPlaca());
		this.insertar(matricula);

	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Matricula tmp = this.selecionarEliminar(placa);
		base.remove(tmp);

	}

}
