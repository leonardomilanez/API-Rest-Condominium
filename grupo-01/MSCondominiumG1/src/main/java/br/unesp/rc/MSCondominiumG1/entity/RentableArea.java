package br.unesp.rc.MSCondominiumG1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "RentableArea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RentableArea extends Common {

    private static final long serialVersionUID = 1L;

    private int capacity;

    @Column(name = "rentable_value")
    private double value;
}
