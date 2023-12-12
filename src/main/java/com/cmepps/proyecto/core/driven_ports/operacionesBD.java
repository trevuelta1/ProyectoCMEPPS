package com.cmepps.proyecto.core.driven_ports;
import java.util.List;

import com.cmepps.proyecto.db.driven_adapter.domain.*;

public interface operacionesBD {
	List<TareaBD> listarTareas();
	List<TareaBD> buscarTareaPorNombre(String nombre);
	List<DiaBD> listarDias();
	List<DiaBD> buscarDiaPorId(int id);
}
