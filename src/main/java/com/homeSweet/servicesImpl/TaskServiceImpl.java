package com.homeSweet.servicesImpl;

import com.homeSweet.entities.FamilyUnit;
import com.homeSweet.entities.Persona;
import com.homeSweet.entities.Task;
import com.homeSweet.repositories.TaskRepository;
import com.homeSweet.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public void save(Task task) {
        LocalDate today = LocalDate.now();
        List<Task> tasks =  taskRepository.findAll();

        //Lambda para comprobar que la instancia de objeto ya existe en bd
       boolean taskExists = tasks.stream().anyMatch(existingTask ->
               existingTask.getTaskName().equals(task.getTaskName()) &&
                       existingTask.getFrequency().equals(task.getFrequency())
       );

       if(!taskExists){
           task.setDateTask(today);
           taskRepository.save(task);
       }else{
           System.out.println(task + " ya existe");
       }

    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void delete(Long task_id) {
        List <Task> tasks = taskRepository.findAll();
        //Expresión lambda que recorre la lista y elimina la coincidencia
        tasks.removeIf(task -> task.getId().equals(task_id));

    }

    @Override
    public void update(Long task_id, Task updatedTask) {
        List <Task> tasks = taskRepository.findAll();
        //Lambda que busca el elemento a través del id y setea los datos
        tasks = tasks.stream()
                .map(task -> {
                    if (task.getId().equals(task_id)) {
                        task.setTaskName(updatedTask.getTaskName());
                        task.setTaskDescription(updatedTask.getTaskDescription());
                        task.setFrequency(updatedTask.getFrequency());
                    }
                    return task;
                })
                .collect(Collectors.toList());
        taskRepository.saveAll(tasks);

    }
}
