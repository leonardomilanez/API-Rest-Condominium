package br.unesp.rc.MSCondominiumG1.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentableAreaDTO extends CommonAreaDTO{
    @NotNull(message = "A capacidade é obrigatória para áreas locáveis.")
    @PositiveOrZero(message = "A capacidade não pode ser negativa.")
    private Integer capacity;

    @NotNull(message = "O valor do aluguel é obrigatório.")
    @PositiveOrZero(message = "O valor não pode ser negativo.")
    private Double value;
}
