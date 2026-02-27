package br.unesp.rc.MSCondominiumG1.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CommonAreaPatchDTO.class, name = "COMMON"),
        @JsonSubTypes.Type(value = SpecificAreaPatchDTO.class, name = "SPECIFIC"),
        @JsonSubTypes.Type(value = RentableAreaPatchDTO.class, name = "RENTABLE")
})
public abstract class AreaPatchDTO {
    @NotBlank(message = "O nome da área não pode estar em branco.")
    private String name;
    @Positive(message = "O tamanho da área (sizeSM) deve ser maior que zero.")
    private Integer sizeSM; // Transformado em Wrapper Class para permitir 'null'
    private Long condominiumId;
}
