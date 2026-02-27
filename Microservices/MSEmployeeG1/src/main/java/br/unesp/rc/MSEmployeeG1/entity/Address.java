package br.unesp.rc.MSEmployeeG1.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Address")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long AddressId;

    private String street;
    private int number;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    
    
    public Address() {
    }

}
