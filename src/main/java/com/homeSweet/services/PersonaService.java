package com.homeSweet.services;

import com.homeSweet.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {
     void save (Persona persona);
    List<Persona> findAll();

     void delete (Long persona_id);

     void update (Long persona_id, Persona updatedPersona);
}
