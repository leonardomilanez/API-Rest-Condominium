// package br.unesp.rc.MSCondominiumG1.dto;
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

    // Base fields
    private Long id;
    private String name;
    private int sizeSM;
    private Long condominiumId;
    private AreaTypeDTO type;

    // Fields for subclasses
    private String location;    // Specific to CommonArea
    private String description; // Specific to SpecificArea

    // Fields for RentableArea
    private Integer capacity;
    private Double value;

    public AreaDTO() {

    }

    /**
     * All-arguments constructor, useful for testing and object creation in
     * code.
     */
    public AreaDTO(Long id, String name, int sizeSM, Long condominiumId, AreaTypeDTO type,
            String location, String description, Integer capacity, Double value) {
        this.id = id;
        this.name = name;
        this.sizeSM = sizeSM;
        this.condominiumId = condominiumId;
        this.type = type;
        this.location = location;
        this.description = description;
        this.capacity = capacity;
        this.value = value;
    }
}
