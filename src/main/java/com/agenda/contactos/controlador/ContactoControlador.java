package com.agenda.contactos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agenda.contactos.entidad.Contactos;
import com.agenda.contactos.repositorio.ContactoRepositorio;

@Controller
public class ContactoControlador {
	
	@Autowired
	private ContactoRepositorio contactoRepositorio;
	
	@GetMapping({"/",""})
	public String verPaginaInicio(Model modelo) {
		List<Contactos> contactos = contactoRepositorio.findAll();
		modelo.addAttribute("contactos", contactos);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormularioREgistro(Model modelo) {
		modelo.addAttribute("contacto", new Contactos());
		return "nuevo";
	}
	
	@PostMapping("/nuevo")
	public String guardarContacto(
	        @jakarta.validation.Valid
	        @org.springframework.web.bind.annotation.ModelAttribute("contacto")
	        Contactos contacto,
	        BindingResult bindingResult,
	        RedirectAttributes redirect) {

	    if (bindingResult.hasErrors()) {
	        return "nuevo";
	    }

	    contactoRepositorio.save(contacto);
	    redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");
	    return "redirect:/";
	}
	
	@GetMapping("/{id}/editar")
	public String mostrarFormularioEditar(@PathVariable Integer id, Model modelo) {
		Contactos contacto = contactoRepositorio.findById(id).orElseThrow(() ->
				new IllegalArgumentException("ID de contacto invalido: " + id));
		modelo.addAttribute("contacto", contacto);
		return "nuevo";
	}
	
	@PostMapping("/{id}/editar")
	public String actualizarContacto(
			@PathVariable Integer id,
	        @jakarta.validation.Valid
	        @org.springframework.web.bind.annotation.ModelAttribute("contacto")
	        Contactos contacto,
	        BindingResult bindingResult,
	        RedirectAttributes redirect) {
		Contactos contactoDB = contactoRepositorio.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID de contacto invalido: " + id));
	    if (bindingResult.hasErrors()) {
	        return "nuevo";
	    }
	    contactoDB.setNombre(contacto.getNombre());
	    contactoDB.setCelular(contacto.getCelular());
	    contactoDB.setEmail(contacto.getEmail());
	    contactoDB.setFechaNacimiento(contacto.getFechaNacimiento());

	    contactoRepositorio.save(contactoDB);
	    redirect.addFlashAttribute("msgExito", "El contacto ha sido actualizado correctamente");
	    return "redirect:/";
	}
}
