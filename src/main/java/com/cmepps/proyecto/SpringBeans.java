package com.cmepps.proyecto;

import org.springframework.context.annotation.*;

import com.cmepps.proyecto.core.driver_ports.*;
import com.cmepps.proyecto.core.driven_ports.*;


@Configuration
public class SpringBeans {
	@Bean
	operacionesUsuario operaciones(final operacionesBD funcionesBD) {
		return new operacionesUsuarioImpl(funcionesBD);
	}
}
