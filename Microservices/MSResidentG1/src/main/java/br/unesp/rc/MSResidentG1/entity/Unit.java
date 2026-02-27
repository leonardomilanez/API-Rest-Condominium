package br.unesp.rc.MSResidentG1.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Unit")
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Unit implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long unitId;

    private String location;
    private double sizeSM;
    private long condominiumId;

    public Unit() {
    }
}
