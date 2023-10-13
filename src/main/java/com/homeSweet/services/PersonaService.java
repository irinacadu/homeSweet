package com.homeSweet.services;

import com.homeSweet.entities.FamilyUnit;
import com.homeSweet.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {
    public void save (Persona persona);
    List<Persona> findAll();

    public void delete (Long persona_id);

    public void update (Long persona_id, Persona updatedPersona);
}
