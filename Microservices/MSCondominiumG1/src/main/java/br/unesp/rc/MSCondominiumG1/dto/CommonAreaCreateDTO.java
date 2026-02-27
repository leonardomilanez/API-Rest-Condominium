package br.unesp.rc.MSCondominiumG1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonAreaCreateDTO extends AreaCreateDTO {
    @NotBlank(message = "O nome do local não pode estar em branco.")
    private String location;
}
