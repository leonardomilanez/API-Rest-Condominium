package br.unesp.rc.MSCondominiumG1.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class UnitDTO {

    private Long id;
    private String idUnit;
    private String location;
    private double sizeSM;
    private Long condominiumId;
    private Long residentId;

    public UnitDTO() {
    }

    public UnitDTO(Long id, String idUnit, String location, double sizeSM, Long condominiumId, Long residentId) {
        this.id = id;
        this.idUnit = idUnit;
        this.location = location;
        this.sizeSM = sizeSM;
        this.condominiumId = condominiumId;
        this.residentId = residentId;
    }

}
