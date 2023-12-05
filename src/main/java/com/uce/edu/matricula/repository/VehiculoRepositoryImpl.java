package com.uce.edu.matricula.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.matricula.repository.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	private List<Vehiculo> base = new ArrayList<Vehiculo>();

	@Override
	public Vehiculo selecionar(String placa) {
		// TODO Auto-generated method stub
		for (Vehiculo vehiculo : base) {
			if (vehiculo.getPlaca().equals(placa)) {
				Vehiculo tmp = new Vehiculo();
				tmp.setMarca(vehiculo.getMarca());
				tmp.setPlaca(vehiculo.getPlaca());
				tmp.setPrecio(vehiculo.getPrecio());
				tmp.setTipo(vehiculo.getTipo());
				return tmp;
			}
		}
		return null;
	}

	public Vehiculo selecionarEliminar(String placa) {
		for (Vehiculo vehiculo : base) {
			if (vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		base.add(vehiculo);

	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);

	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo tmp = this.selecionar(placa);
		base.remove(tmp);

	}

}
