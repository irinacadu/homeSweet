package com.homeSweet.services;

import com.homeSweet.entities.FamilyUnit;
import com.homeSweet.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FamilyUnitService {
    public void save (FamilyUnit familyUnit);
    List<FamilyUnit> findAll();
    public void delete (Long familyUnit_id);

    public void update (Long familyUnit_id, FamilyUnit updatedFamilyUnit);
}
