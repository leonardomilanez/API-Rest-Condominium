// package br.unesp.rc.MSCondominiumG1.dto;
package br.unesp.rc.MSCondominiumG1.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CommonAreaDTO.class, name = "COMMON"),
        @JsonSubTypes.Type(value = SpecificAreaDTO.class, name = "SPECIFIC"),
        @JsonSubTypes.Type(value = RentableAreaDTO.class, name = "RENTABLE")
})
public abstract class AreaDTO {

    private Long id;
    private String name;
    private int sizeSM;
    private Long condominiumId;


}
