package br.unesp.rc.MSCondominiumG1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unesp.rc.MSCondominiumG1.dto.AreaDTO;
import br.unesp.rc.MSCondominiumG1.dto.assembler.AreaAssembler;
import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.entity.mapper.AreaMapper;
import br.unesp.rc.MSCondominiumG1.service.AreaService;

@RestController
@RequestMapping("/condominium/v1")
public class AreaResource {
        @Autowired
    private AreaService areaService;

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

        Area area = AreaAssembler.dtoToEntityModel(areaDto);
        Area areaInserted = areaService.save(area);
        if (areaInserted != null) {
            inserted = true;
        }

        return inserted;
    }

    @PutMapping("/area")
    public boolean update(@RequestBody AreaDTO areaDto) {
        boolean updated = false;

        Area newArea = AreaAssembler.dtoToEntityModel(areaDto);
        Area existingArea = areaService.findById(newArea.getId());

        if (existingArea != null) {
            AreaMapper.update(existingArea, newArea);

            Area updatedArea = areaService.update(existingArea);
            if (updatedArea != null) {
                updated = true;
            }
        }

        return updated;
    }
}
