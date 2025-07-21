package br.unesp.rc.MSCondominiumG1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.repository.AreaRepository;

@Component
@Service
public class AreaService {

    @Autowired
    private AreaRepository repository;

    public AreaService() {

    }

    public Area save(Area entity) {
        Area persistedEntity = null;

        if (repository != null) {
            persistedEntity = repository.save(entity);
        }

        return persistedEntity;
    }

    public Area findById(Long id) {
        Area foundEntity = null;

        if (repository != null) {
            foundEntity = repository.findById(id).orElse(null);
        }

        return foundEntity;
    }

    public void delete(Area entity) {
        if (repository != null) {
            repository.delete(entity);
        }
    }

    public Area update(Area entity) {
        Area persistedEntity = null;

        if (repository != null) {
            persistedEntity = repository.save(entity);
        }

        return persistedEntity;
    }

    public List<Area> findAll() {
        List<Area> list = null;

        if (repository != null) {
            list = new ArrayList<>();
            list = repository.findAll();
        }

        return list;
    }
}
