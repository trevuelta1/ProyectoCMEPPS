package com.cmepps.proyecto.core.driver_ports;

import java.util.List;

import com.cmepps.proyecto.core.domain.*;

public interface operacionesUsuario {
	List<Tarea> listaTareas();
	List<Tarea> buscarTarea(String nombre);
	Tarea buscarTareaPorId(int id);
	List<Dia> listaDias();
	Dia buscarDia(int id);
	Dia guardaDia(Dia d);
	Tarea guardaTarea(Tarea t);
	void eliminaTarea(Tarea t);
	void modificaTarea(Tarea t);
	void asignaTareaSucesora(Tarea t, Tarea sucesora);
	void asignaTareaAntecesora(Tarea t, Tarea antecesora);
	void asignaDia(Tarea t, Dia d);
}
