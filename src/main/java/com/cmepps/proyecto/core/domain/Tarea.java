package com.cmepps.proyecto.core.domain;

import java.util.UUID;

public class Tarea {
	private int id;
	private String nombre;
	private String descripcion;
	private int horas;
	private int prioridad;
	private int dia;
	private int sucesora;
	private int antecesora;
	public Tarea(int id, String nombre, String descripcion, int horas, int prioridad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horas = horas;
		this.prioridad = prioridad;
		this.sucesora = -1;
		this.antecesora = -1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getSucesora() {
		return sucesora;
	}
	public void setSucesora(int sucesora) {
		this.sucesora = sucesora;
	}
	public int getAntecesora() {
		return antecesora;
	}
	public void setAntecesora(int antecesora) {
		this.antecesora = antecesora;
	}
}
