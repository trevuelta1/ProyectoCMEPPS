package com.cmepps.proyecto.db.driven_adapter.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Dia")
public class DiaBD {
	@Id
	private int id;
	private List<TareaBD> tareas;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToMany(mappedBy = "dia")
	public List<TareaBD> getTareas() {
		return tareas;
	}
	public void setTareas(List<TareaBD> tareas) {
		this.tareas = tareas;
	}
}
