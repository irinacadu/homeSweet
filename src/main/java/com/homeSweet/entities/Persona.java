package com.homeSweet.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id=0L;
    @Column(name = "persona_name")
    protected String personaName;

    @Column(name = "persona_member")
    protected String personaMember;

    @Column(name = "persona_age")
    protected String personaAge;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "persona")
    @JsonIgnore
    private Set<TaskPersona> eventosUsuario = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FamilyUnit familyUnit;

    public String toString() {
        return "{ \n id: " + id + " \n"
                + "persona name: " + personaName + " \n"
                + "persona member: " + personaMember + " \n"
                + "persona age: " + personaAge + " \n}";

    }
}
