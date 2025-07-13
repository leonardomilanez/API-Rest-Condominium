package br.unesp.rc.MSCondominiumG1.dto;

import java.util.Date;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResidentDTO {
    private Long id;
    private int idResident;
    private String name;
    private Date birthDate;
    private String type;
    private List<Long> unitIds;
    public ResidentDTO() {
    }
    public ResidentDTO(Long id, int idResident, String name, Date birthDate, String type, List<Long> unitIds) {
        this.id = id;
        this.idResident = idResident;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.unitIds = unitIds;
    }

    
}
