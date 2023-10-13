package com.homeSweet.controllers;


import com.homeSweet.entities.FamilyUnit;
import com.homeSweet.entities.Persona;
import com.homeSweet.entities.Task;
import com.homeSweet.servicesImpl.FamilyUnitServiceImpl;
import com.homeSweet.servicesImpl.PersonaServiceImpl;
import com.homeSweet.servicesImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/")
public class GeneralController {

    @Autowired
    TaskServiceImpl taskService;

    @Autowired
    PersonaServiceImpl personaService;

    @Autowired
    FamilyUnitServiceImpl familyUnitService;


    //CRUD Tasks
    @PostMapping("create-task")
    @ResponseBody
    public void  newTask (@RequestBody Task task){
        taskService.save(task);
    }

    @GetMapping("all-tasks")
    @ResponseBody
    public List<Task> allTasks(){
        return taskService.findAll();

    }

    @DeleteMapping("delete-task")
    @ResponseBody
    public void deleteTask(@RequestParam("id")Long task_id){
        taskService.delete(task_id);
    }

    @PatchMapping("update-task")
    @ResponseBody
    public ResponseEntity <String> updateTask(@RequestParam("id")Long task_id , @RequestBody Task updatedTask ){

        try {
            taskService.update(task_id, updatedTask);
            return ResponseEntity.ok("Registro actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
    //CRUD Persona
    @PostMapping("create-persona")
    @ResponseBody
    public void  newPersona (@RequestBody Persona persona){
        personaService.save(persona);
    }

    @GetMapping("all-personas")
    @ResponseBody
    public List<Persona> allPersonas(){
        return personaService.findAll();
    }

    @DeleteMapping("delete-persona")
    @ResponseBody
    public void deletePersona(@RequestParam("id")Long persona_id){
        personaService.delete(persona_id);
    }

    @PatchMapping("update-persona")
    @ResponseBody
    public ResponseEntity <String> updatePersona(@RequestParam("id")Long persona_id , @RequestBody Persona updatedPersona ){

        try {
            personaService.update(persona_id, updatedPersona);
            return ResponseEntity.ok("Registro actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


    //CRUD Family Unit
    @PostMapping("create-familyUnit")
    @ResponseBody
    public void  newFamilyUnit (@RequestBody FamilyUnit familyUnit){
        familyUnitService.save(familyUnit);
    }

    @GetMapping("all-familyUnits")
    @ResponseBody
    public List<FamilyUnit> allFamilyUnits(){
        return familyUnitService.findAll();

    }

    @DeleteMapping("delete-familyUnit")
    @ResponseBody
    public void deleteFamilyUnit(@RequestParam("id")Long familyUnit_id){
        familyUnitService.delete(familyUnit_id);
    }

    @PatchMapping("update-familyUnit")
    @ResponseBody
    public ResponseEntity <String> updateFamilyUnit(@RequestParam("id")Long familyUnit_id , @RequestBody FamilyUnit updatedFamilyUnit ){

        try {
            familyUnitService.update(familyUnit_id, updatedFamilyUnit);
            return ResponseEntity.ok("Registro actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }



}
