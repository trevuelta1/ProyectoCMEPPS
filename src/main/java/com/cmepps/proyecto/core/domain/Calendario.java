package com.cmepps.proyecto.core.domain;

import java.util.Date;

public class Calendario {
	private Date fecha;
	public Calendario() {
		this.fecha = new Date();
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@SuppressWarnings("deprecation")
	public void setDia(int dia) {
		this.fecha.setDate(dia);
	}
	@SuppressWarnings("deprecation")
	public void setMes(int mes) {
		this.fecha.setMonth(mes);
	}
	@SuppressWarnings("deprecation")
	public void setAnio(int anio) {
		this.fecha.setYear(anio);
	}
}
