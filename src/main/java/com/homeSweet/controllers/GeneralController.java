package com.homeSweet.controllers;


import com.homeSweet.entities.Task;
import com.homeSweet.servicesImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/")
public class GeneralController {

    @Autowired
    TaskServiceImpl taskService;


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

}
