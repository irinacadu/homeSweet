package com.homeSweet.repositories;

import com.homeSweet.entities.TaskPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskPersonaRepository extends JpaRepository<TaskPersona,Long> {


}
