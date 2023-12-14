package com.cmepps.proyecto.core.driver_ports;

import java.util.List;

import com.cmepps.proyecto.core.domain.*;

public interface operacionesUsuario {
	List<Tarea> listaTareas();
	List<Tarea> buscarTarea(String nombre);
	List<Dia> listaDias();
	Dia buscarDia(int id);
	Tarea guardaTarea(Tarea t);
	void eliminaTarea(Tarea t);
	void modificaTarea(Tarea t);
	void asignaTareaSucesora(Tarea t, Tarea sucesora);
	void asignaTareaAntecesora(Tarea t, Tarea antecesora);
	void asignaDia(Tarea t, Dia d);
}
