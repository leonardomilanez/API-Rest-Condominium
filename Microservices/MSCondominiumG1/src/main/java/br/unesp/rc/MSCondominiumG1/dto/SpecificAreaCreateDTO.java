package br.unesp.rc.MSCondominiumG1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecificAreaCreateDTO extends AreaCreateDTO{
    @NotBlank(message = "O nome da descrição não pode estar em branco.")
    private String description;
}
