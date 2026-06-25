package com.agenda.contactos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.contactos.entidad.Contactos;

public interface ContactoRepositorio extends JpaRepository<Contactos, Integer>{

}
