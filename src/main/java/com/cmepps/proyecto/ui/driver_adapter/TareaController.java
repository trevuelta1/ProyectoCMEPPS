package com.cmepps.proyecto.ui.driver_adapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cmepps.proyecto.core.driver_ports.*;

@Controller
@RequestMapping("/")
public class TareaController {
	@Autowired
	private operacionesUsuario funcionesUsuario;
	@GetMapping("/")
	public ResponseEntity<String> inicio(@RequestParam(value = "name", defaultValue = "World") String name) {
        String content = null;
        try {
        	content = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir").replace('\\', '/') + "/src/main/webapp/WEB-INF/jsp/index.jsp")),"UTF-8");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<String>(content, HttpStatus.OK);
    }
	@GetMapping("/tareas")
	public String listatareas(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "listatareas";
    }
}
