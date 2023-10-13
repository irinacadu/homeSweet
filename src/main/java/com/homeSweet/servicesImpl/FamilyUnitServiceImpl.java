package com.homeSweet.servicesImpl;

import com.homeSweet.entities.FamilyUnit;
import com.homeSweet.entities.Persona;
import com.homeSweet.repositories.FamilyUnitRepository;
import com.homeSweet.repositories.PersonaRepository;
import com.homeSweet.services.FamilyUnitService;
import com.homeSweet.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyUnitServiceImpl implements FamilyUnitService {
    @Autowired
    FamilyUnitRepository familyUnitRepository;

    /*SRP : sistema de responsabilidad única.
     List<FamilyUnit> familyUnits =  familyUnitRepository.findAll();
    Pese a necesitar recuperar la lista de datos en cada uno de los métodos
    se decide declararla en cada método en vez de hacerlo globalmente  para que se haga solamente una acción sobre ella cada vez */


    @Override
    public void save(FamilyUnit familyUnit) {
          List<FamilyUnit> familyUnits =  familyUnitRepository.findAll();

        //Lambda para comprobar que la instancia de objeto ya existe en bd
        boolean familyUnitExist = familyUnits.stream().anyMatch(existingFamilyUnit ->
                existingFamilyUnit.getFamilyUnitName().equals(familyUnit.getFamilyUnitName()));

        if(!familyUnitExist){
            familyUnitRepository.save(familyUnit);
        }else{
            System.out.println(familyUnit + " ya existe");
        }

    }

    @Override
    public List<FamilyUnit> findAll() {
        return familyUnitRepository.findAll();
    }

    @Override
    public void delete(Long familyUnit_id) {
        List <FamilyUnit> familyUnits = familyUnitRepository.findAll();
        //Expresión lambda que recorre la lista y elimina la coincidencia
        familyUnits.removeIf(familyUnit -> familyUnit.getId().equals(familyUnit_id));

    }

    @Override
    public void update(Long familyUnit_id, FamilyUnit updatedFamilyUnit) {
        List <FamilyUnit> familyUnits = familyUnitRepository.findAll();

        //Lambda que busca el elemento a través del id y setea los datos
        familyUnits = familyUnits.stream()
                .map(familyUnit -> {
                    if (familyUnit.getId().equals(familyUnit_id)) {
                        familyUnit.setFamilyUnitName(updatedFamilyUnit.getFamilyUnitName());
                    }
                    return familyUnit;
                })
                .collect(Collectors.toList());
        familyUnitRepository.saveAll(familyUnits);

    }
}
