package com.cmepps.proyecto.core.domain;

import java.util.List;

public class Dia {
	private int id;
	private List<Tarea> tareas;
	public Dia(int id, List<Tarea> tareas) {
		this.id = id;
		this.tareas = tareas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	public void addTarea(Tarea tarea) {
		this.tareas.add(tarea);
	}
	public void deleteTarea(Tarea tarea) {
		this.tareas.remove(tarea);
	}
}
