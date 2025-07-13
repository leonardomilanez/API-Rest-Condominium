package br.unesp.rc.MSCondominiumG1.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AreaDTO {
    private Long id;
    private String name;
    private int sizeSM;
    private Long condominiumId;
    public AreaDTO(Long id, String name, int sizeSM, Long condominiumId) {
        this.id = id;
        this.name = name;
        this.sizeSM = sizeSM;
        this.condominiumId = condominiumId;
    }
    public AreaDTO() {
    }
    
}
