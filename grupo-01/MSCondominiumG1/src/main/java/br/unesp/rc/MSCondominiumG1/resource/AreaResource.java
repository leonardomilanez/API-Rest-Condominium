package br.unesp.rc.MSCondominiumG1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; // Using repository directly as in tutorials
import org.springframework.web.bind.annotation.RestController;

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
    public List<Area> getAllAreas() {
        return areaService.findAll();
    }

    @GetMapping("/area/{id}")
    public Area getAreaById(@PathVariable(value = "id") Long id) {
        return areaService.findById(id);
    }

    @DeleteMapping("/area/{id}")
    public boolean delete(@PathVariable(value = "id") Long id) {
        boolean deleted = false;
        Area area = areaService.findById(id);
        if (area != null) {
            areaService.delete(area);
            deleted = true;
        }
        return deleted;
    }

    @PostMapping("/area")
    public boolean saveArea(@RequestBody AreaDTO areaDto) {
        boolean inserted = false;

        // The logic to find the parent entity is done here in the resource, as per the tutorial style.
        if (areaDto.getCondominiumId() != null) {
            Condominium parentCondo = condominiumRepository.findById(areaDto.getCondominiumId()).orElse(null);

            if (parentCondo != null) {
                Area area = AreaAssembler.dtoToEntityModel(areaDto);

                // We add the new area to the parent's list before saving the parent.
                parentCondo.getAreas().add(area);
                condominiumRepository.save(parentCondo); // Saving the parent will cascade and save the new area.
                inserted = true;
            }
        }
        return inserted;
    }

    @PutMapping("/area")
    public boolean update(@RequestBody AreaDTO areaDto) {
        boolean updated = false;

        if (areaDto.getId() == null) {
            return false; // Cannot update without an ID
        }

        Area existingArea = areaService.findById(areaDto.getId());

        if (existingArea != null) {
            Area newDetails = AreaAssembler.dtoToEntityModel(areaDto);
            AreaMapper.update(existingArea, newDetails);

            Area updatedArea = areaService.update(existingArea);
            if (updatedArea != null) {
                updated = true;
            }
        }
        return updated;
    }
}
