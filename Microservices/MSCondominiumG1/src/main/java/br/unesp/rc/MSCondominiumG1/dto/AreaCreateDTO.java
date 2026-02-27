package br.unesp.rc.MSCondominiumG1.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
        property = "type" // O campo no JSON que define qual classe instanciar
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CommonAreaCreateDTO.class, name = "COMMON"),
        @JsonSubTypes.Type(value = SpecificAreaCreateDTO.class, name = "SPECIFIC"),
        @JsonSubTypes.Type(value = RentableAreaCreateDTO.class, name = "RENTABLE")
})
public abstract class AreaCreateDTO {
    @NotBlank(message = "O nome da área não pode estar em branco.")
    private String name;

    @Positive(message = "O tamanho da área (sizeSM) deve ser maior que zero.")
    private int sizeSM;

    @NotNull(message = "O ID do condomínio é obrigatório.")
    private Long condominiumId;
}
