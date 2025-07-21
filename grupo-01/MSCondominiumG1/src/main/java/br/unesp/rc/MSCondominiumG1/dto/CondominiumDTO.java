package br.unesp.rc.MSCondominiumG1.dto;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CondominiumDTO {

    private Long id;
    private String name;
    private String type;
    private List<Long> unitIds;
    private List<Long> areaIds;

    public CondominiumDTO() {
    }

    public CondominiumDTO(Long id, String name, String type, List<Long> unitIds, List<Long> areaIds) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.unitIds = unitIds;
        this.areaIds = areaIds;
    }

}
