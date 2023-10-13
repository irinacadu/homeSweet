package com.homeSweet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id=0L;
    @Column(name = "task_name")
    protected String taskName;

    @Column(name = "task_description")
    protected String taskDescription;

    @Column(name = "frequency")
    protected String frequency;

    @Column(name = "dateTask")
    protected LocalDate dateTask;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")
    @JsonIgnore
    private Set<TaskPersona> tasksPersona = new HashSet<>();


    public String toString() {
        return "{ \n taskName: " + taskName + " \n"
                + "taskDescription: " + taskDescription + " \n"
                + "frequency" + frequency +  " \n"
                + "dateTask: " + dateTask + " \n}";
    }
}
