package br.unesp.rc.MSCondominiumG1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecificAreaDTO extends AreaDTO {
    @NotBlank(message = "A descrição da área não pode estar em branco.")
    private String description;
}
