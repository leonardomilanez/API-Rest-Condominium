package br.unesp.rc.MSCondominiumG1.service;

import java.util.ArrayList;
import java.util.List;

import br.unesp.rc.MSCondominiumG1.dto.AreaCreateDTO;
import br.unesp.rc.MSCondominiumG1.dto.assembler.AreaAssembler;
import br.unesp.rc.MSCondominiumG1.entity.Condominium;
import br.unesp.rc.MSCondominiumG1.exception.ResourceNotFoundException;
import br.unesp.rc.MSCondominiumG1.repository.CondominiumRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.repository.AreaRepository;
import org.springframework.web.server.ResponseStatusException;

@Component
@Service
public class AreaService {

    @Autowired
    private AreaRepository repository;

    @Autowired
    private CondominiumRepository condominiumRepository;

    public AreaService() {

    }

    public Area save(Area entity) {
        return repository.save(entity);
    }

    public Area findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Área com ID " + id + " não encontrada."));
    }

    public Page<Area> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void deleteById(Long id) {
        Area area = findById(id);
        repository.delete(area);
    }

    public Area create(AreaCreateDTO dto) {
        Condominium condoRef;
        try {
            condoRef = condominiumRepository.getReferenceById(dto.getCondominiumId());
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Condomínio não encontrado");
        }
        Area area = AreaAssembler.dtoToEntityModel(dto);

        area.setCondominium(condoRef);

        return repository.save(area);
    }
}
