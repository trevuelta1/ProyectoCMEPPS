package com.cmepps.proyecto.db.driven_adapter.jparepository;

import java.util.List;

import org.springframework.beans.factory.annotation.*;

import com.cmepps.proyecto.core.driven_ports.operacionesBD;
import com.cmepps.proyecto.db.driven_adapter.domain.*;

public class operacionesBDImpl implements operacionesBD {
	@Autowired
	TareaJpaRepository tareajpa;
	@Autowired
	DiaJpaRepository diajpa;
	public List<TareaBD> listarTareas(){
		return tareajpa.findAll();	
	}
	public List<TareaBD> buscarTareaPorNombre(String nombre){
		return tareajpa.findByName(nombre);
	}
	public List<DiaBD> listarDias(){
		return diajpa.findAll();
	}
	public List<DiaBD> buscarDiaPorId(int id){
		return diajpa.findById(id);
	}
}