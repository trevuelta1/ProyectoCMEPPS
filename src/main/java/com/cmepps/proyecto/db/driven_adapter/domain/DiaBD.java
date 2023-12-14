package com.cmepps.proyecto.db.driven_adapter.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Dia")
public class DiaBD {
	@Id
	@Column(name = "id")
	private int id;
	@OneToMany(mappedBy = "dia")
	private List<TareaBD> tareas;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<TareaBD> getTareas() {
		return tareas;
	}
	public void setTareas(List<TareaBD> tareas) {
		this.tareas = tareas;
	}
}
