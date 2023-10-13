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
public class FamilyUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id=0L;

    @Column(name = "family_unit_name")
    protected String familyUnitName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "personaName")
    @JsonIgnore
    private Set<Persona> persona = new HashSet<>();

}
