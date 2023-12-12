package com.cmepps.proyecto.ui.driver_adapter;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.cmepps.proyecto.core.driver_ports.*;

@RestController
public class TareaController {
	@Autowired
	private operacionesUsuario funcionesUsuario;
}
