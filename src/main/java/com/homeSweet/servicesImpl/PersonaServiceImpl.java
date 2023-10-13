package com.homeSweet.servicesImpl;

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

@Service
public class PersonaServiceImpl  implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;
    @Override
    public void save(Persona persona) {
        LocalDate today = LocalDate.now();
        List<Persona> tasks =  personaRepository.findAll();

        //Lambda para comprobar que la instancia de objeto ya existe en bd
        boolean personaExists = tasks.stream().anyMatch(existingPersona -> existingPersona.getPersonaName().equals(persona.getPersonaName()));
        personaRepository.save(!personaExists ? persona : null);
//        if(!personaExists){
//            personaRepository.save(persona);
//        }else{
//            System.out.println(persona + " ya existe");
//        }
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }
}
