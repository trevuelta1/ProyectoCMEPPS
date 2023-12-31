package com.cmepps.proyecto.db.driven_adapter.jparepository;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cmepps.proyecto.core.driven_ports.operacionesBD;
import com.cmepps.proyecto.db.driven_adapter.domain.*;

@Component
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
	public TareaBD buscarTareaPorId(int id) {
		return tareajpa.findById(id);
	}
	public List<DiaBD> listarDias(){
		return diajpa.findAll();
	}
	public DiaBD buscarDiaPorId(int id){
		return diajpa.findById(id);
	}
	public void guardaDia(DiaBD d) {
		diajpa.save(d);
	}
	public void guardarTarea(TareaBD t) {
		tareajpa.save(t);
	}
	public void eliminarTarea(TareaBD t) {
		tareajpa.delete(t);
	}
	@Transactional
	public void modificarTarea(int id, String name, String description, int hours, int priority) {
		tareajpa.update(id, name, description, hours, priority);
	}
	@Transactional
	public void asignarSucesora(int id, int idsucesora) {
		tareajpa.setNext(id, idsucesora);
	}
	@Transactional
	public void asignarAntecesora(int id, int idantecesora) {
		tareajpa.setPrevious(id, idantecesora);
	}
	@Transactional
	public void asignarDia(int id, DiaBD dia) {
		tareajpa.updateDia(id, dia.getId());
	}
}
