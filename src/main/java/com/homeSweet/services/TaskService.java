package com.homeSweet.services;

import com.homeSweet.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    public void save (Task task);
    List<Task> findAll();
}
