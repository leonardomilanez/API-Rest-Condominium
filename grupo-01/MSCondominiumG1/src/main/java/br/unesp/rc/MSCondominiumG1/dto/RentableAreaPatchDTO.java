package br.unesp.rc.MSCondominiumG1.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentableAreaPatchDTO extends CommonAreaPatchDTO{
    @PositiveOrZero(message = "A capacidade não pode ser negativa.")
    private Integer capacity;

    @PositiveOrZero(message = "O valor não pode ser negativo.")
    private Double value;
}
