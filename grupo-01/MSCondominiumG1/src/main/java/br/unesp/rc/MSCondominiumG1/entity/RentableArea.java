package br.unesp.rc.MSCondominiumG1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rentable_area")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentableArea extends Common {

    private static final long serialVersionUID = 1L;

    private Integer capacity;

    @Column(name = "rentable_value")
    private Double value;
}
