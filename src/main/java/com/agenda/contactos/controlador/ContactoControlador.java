package com.agenda.contactos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoControlador {
	
	@GetMapping({"/",""})
	public String verPaginaInicio() {
		return "index";
	}
}
