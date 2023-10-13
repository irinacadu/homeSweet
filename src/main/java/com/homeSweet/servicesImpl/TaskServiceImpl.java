package com.homeSweet.servicesImpl;

import com.homeSweet.entities.Task;
import com.homeSweet.repositories.TaskRepository;
import com.homeSweet.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public void save(Task task) {
        LocalDate today = LocalDate.now();
        List<Task> tasks =  taskRepository.findAll();

        //Lambda para comprobar que la instancia de objeto ya existe en bd
       boolean taskExists = tasks.stream().anyMatch(existingTask -> existingTask.getTaskName().equals(task.getTaskName()));

       //Si taskExists es false se guarda
       taskRepository.save(!taskExists ? task : null);
       System.out.println(taskExists ? task + " ya existe" : "");
//       if(!taskExists){
//           task.setDateTask(today);
//           taskRepository.save(task);
//
//       }else{
//
//           System.out.println(task + " ya existe");
//
//       }



    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
}
