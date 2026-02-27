package br.unesp.rc.MSCondominiumG1.resource;

import java.util.List;

import br.unesp.rc.MSCondominiumG1.dto.AreaCreateDTO;
import br.unesp.rc.MSCondominiumG1.dto.AreaPatchDTO;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unesp.rc.MSCondominiumG1.dto.AreaDTO;
import br.unesp.rc.MSCondominiumG1.dto.assembler.AreaAssembler;
import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.entity.Condominium;
import br.unesp.rc.MSCondominiumG1.entity.mapper.AreaMapper;
import br.unesp.rc.MSCondominiumG1.repository.CondominiumRepository;
import br.unesp.rc.MSCondominiumG1.service.AreaService;

@RestController
@RequestMapping("/condominium/v1")
public class AreaResource {

    @Autowired
    private AreaService areaService;

    // We inject the CondominiumRepository directly to find the parent,
    // similar to how tutorials handle related data.
    @Autowired
    private CondominiumRepository condominiumRepository;

    @GetMapping("/area")
    public ResponseEntity<Page<AreaDTO>> getAllAreas(
            @ParameterObject @PageableDefault(page = 0, size = 10, sort = "name") Pageable pageable) {

        Page<Area> areaPage = areaService.findAll(pageable);
        Page<AreaDTO> dtoPage = areaPage.map(AreaAssembler::entityToDto);

        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/area/{id}")
    public ResponseEntity<AreaDTO> getAreaById(@PathVariable(value = "id") Long id) {
        Area area = areaService.findById(id);
        return ResponseEntity.ok(AreaAssembler.entityToDto(area));
    }


    @DeleteMapping("/area/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        areaService.deleteById(id);
    }

    @PostMapping("/area")
    public ResponseEntity<AreaDTO> create(@Valid @RequestBody AreaCreateDTO dto) {

        Area created = areaService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AreaAssembler.entityToDto(created));
    }

    @PatchMapping("/area/{id}")
    public ResponseEntity<Void> patch(@Valid @RequestBody AreaPatchDTO dto, @PathVariable(value = "id") Long id) {
        Area area = areaService.findById(id);
        AreaMapper.partialUpdate(area, dto);
        areaService.save(area);

        return ResponseEntity.noContent().build();
    }
}
