package br.unesp.rc.MSCondominiumG1.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Unit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idUnit;
    private String location;
    private double sizeSM;

    // CORREÇÃO: Adicionado o campo 'resident' com @ManyToOne para corresponder ao
    // 'mappedBy' em Resident.java
    @ManyToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;

    @ManyToOne
    @JoinColumn(name = "condominium_id")
    @JsonIgnore
    private Condominium condominium;
}
