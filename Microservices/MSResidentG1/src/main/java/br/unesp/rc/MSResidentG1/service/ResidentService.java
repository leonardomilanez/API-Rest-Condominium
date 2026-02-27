package br.unesp.rc.MSResidentG1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unesp.rc.MSResidentG1.entity.Resident;
import br.unesp.rc.MSResidentG1.repository.ResidentRepository;

@Component
public class ResidentService {
    
    @Autowired
    private ResidentRepository repository;
    
    public ResidentService(){

    }

    public Resident save (Resident entity) {
        Resident persistedEntity = null;
        if(repository != null) {
            persistedEntity = repository.save(entity);
        }

        return persistedEntity;
    }

    public Resident findByCpf(String cpf) {
        Resident insertedEntity = null;
        if(repository != null) {
            insertedEntity = repository.findByCpf(cpf);
        }
        return insertedEntity;
    }

    public void delete(Resident entity) {
        if(repository != null) {
            repository.delete(entity);
        }
    }

    public Resident update(Resident entity) {
        Resident persistedEntity = null;
        if(repository != null) {
            persistedEntity = repository.save(entity);
        }
        return persistedEntity;
    }

    public List<Resident> findAll() {
        List<Resident> list = null;
        if(repository != null) {
            list = new ArrayList<>();
            list = repository.findAll();
        }
        return list;
    }
}