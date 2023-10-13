package com.homeSweet.servicesImpl;

import com.homeSweet.entities.FamilyUnit;
import com.homeSweet.entities.Persona;
import com.homeSweet.entities.Task;
import com.homeSweet.repositories.PersonaRepository;
import com.homeSweet.repositories.TaskRepository;
import com.homeSweet.services.PersonaService;
import com.homeSweet.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl  implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;
    @Override
    public void save(Persona persona) {

        List<Persona> tasks =  personaRepository.findAll();

        //Lambda para comprobar que la instancia de objeto ya existe en bd
        boolean personaExists = tasks.stream().anyMatch(existingPersona ->
                existingPersona.getPersonaName().equals(persona.getPersonaName()) &&
                        existingPersona.getPersonaMember().equals(persona.getPersonaMember())
        );

        if(!personaExists){
            personaRepository.save(persona);
        }else{
            System.out.println(persona + " ya existe");
        }
    }

    @Override
    public List<Persona> findAll() {

        return personaRepository.findAll();
    }

    @Override
    public void delete(Long persona_id) {
        List <Persona> personas = personaRepository.findAll();
        //Expresión lambda que recorre la lista y elimina la coincidencia
        personas.removeIf(persona -> persona.getId().equals(persona_id));
    }

    @Override
    public void update(Long persona_id, Persona updatedPersona) {

        List <Persona> personas = personaRepository.findAll();

        //Lambda que busca el elemento a través del id y setea los datos
        personas = personas.stream()
                .map(persona -> {
                    if (persona.getId().equals(persona_id)) {
                        persona.setPersonaName(updatedPersona.getPersonaName());
                        persona.setPersonaMember(updatedPersona.getPersonaMember());
                        persona.setPersonaAge(updatedPersona.getPersonaMember());
                    }
                    return persona;
                })
                .collect(Collectors.toList());
        personaRepository.saveAll(personas);

    }
}
