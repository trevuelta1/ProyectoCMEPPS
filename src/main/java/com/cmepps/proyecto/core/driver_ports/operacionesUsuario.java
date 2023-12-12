package com.cmepps.proyecto.core.driver_ports;

import java.util.List;

import com.cmepps.proyecto.core.domain.*;

public interface operacionesUsuario {
	List<Tarea> listaTareas();
	List<Tarea> buscarTarea(String nombre);
	List<Dia> listaDias();
	List<Dia> buscarDia(int id);
}
