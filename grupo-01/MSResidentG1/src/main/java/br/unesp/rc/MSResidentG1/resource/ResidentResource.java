package br.unesp.rc.MSResidentG1.resource;

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

import br.unesp.rc.MSResidentG1.dto.ResidentDTO;
import br.unesp.rc.MSResidentG1.dto.assembler.ResidentAssembler;
import br.unesp.rc.MSResidentG1.entity.Resident;
import br.unesp.rc.MSResidentG1.entity.mapper.ResidentMapper;
import br.unesp.rc.MSResidentG1.service.ResidentService;

@RestController
@RequestMapping("/resident/v1")
public class ResidentResource {

    @Autowired
    ResidentService residentService;

    @GetMapping("/")
    public List<Resident> getAllResident() {
        return residentService.findAll();
    }

    @GetMapping("/{cpf}")
    public Resident getResidentByCpf(@PathVariable(value = "cpf") String cpf) {
        Resident resident = residentService.findByCpf(cpf);
        return resident;
    }

    @DeleteMapping("/{cpf}")
    public boolean deleteResident(@PathVariable(value = "cpf") String cpf) {
        boolean deleted = false;
        Resident residentDelete = residentService.findByCpf(cpf);
        if (residentDelete != null) {
            residentService.delete(residentDelete);
            deleted = true;
        }
        return deleted;
    }

    @PostMapping("/")
    public boolean saveResident(@RequestBody ResidentDTO residentDTO) {
        boolean insert = false;
        Resident resident = ResidentAssembler.dtoToEntityModel(residentDTO);
        Resident residentInsert = residentService.save(resident);
        if (residentInsert != null) {
            insert = true;
        }
        return insert;
    }

    @PutMapping("/")
    public boolean update(@RequestBody ResidentDTO residentDTO) {
        boolean update = false;

        Resident newResident = ResidentAssembler.dtoToEntityModel(residentDTO);
        Resident residentUpdate = residentService.findByCpf(newResident.getCpf());

        ResidentMapper.update(residentUpdate, newResident);

        Resident residentUpdated = residentService.update(residentUpdate);
        if (residentUpdated != null) {
            update = true;
        }

        return update;
    }
}
