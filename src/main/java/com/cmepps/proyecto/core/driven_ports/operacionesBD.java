package com.cmepps.proyecto.core.driven_ports;
import java.util.List;

import com.cmepps.proyecto.db.driven_adapter.domain.*;

public interface operacionesBD {
	List<TareaBD> listarTareas();
	List<TareaBD> buscarTareaPorNombre(String nombre);
	TareaBD buscarTareaPorId(int id);
	List<DiaBD> listarDias();
	DiaBD buscarDiaPorId(int id);
	void guardarTarea(TareaBD t);
	void eliminarTarea(TareaBD t);
	void modificarTarea(int id, String name, String description, int hours, int priority);
	void asignarSucesora(int id, int idsucesora);
	public void asignarAntecesora(int id, int idantecesora);
	public void asignarDia(int id, DiaBD dia);
}
