package com.homeSweet.services;

import com.homeSweet.entities.FamilyUnit;
import com.homeSweet.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaService {
    public void save (Persona persona);
    List<Persona> findAll();
}
