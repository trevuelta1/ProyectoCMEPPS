package com.cmepps.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import com.cmepps.proyecto.core.driven_ports.*;
import com.cmepps.proyecto.db.driven_adapter.jparepository.TareaJpaRepository;
import com.cmepps.proyecto.db.driven_adapter.jparepository.operacionesBDImpl;


@Configuration
public class SpringBeans {
	@Bean
	operacionesBD operaciones(final TareaJpaRepository TareaRepository) {
		return new operacionesBDImpl(TareaRepository);
	}
}

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

}
