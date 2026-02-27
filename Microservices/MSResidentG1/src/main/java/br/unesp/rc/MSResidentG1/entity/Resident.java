package br.unesp.rc.MSResidentG1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Resident")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true, includeFieldNames = true)

public class Resident extends Person {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    private ResidentType residentType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_unitId")
    private Unit unit;

    public Resident() {
    }
}
