package br.unesp.rc.MSEmployeeG1.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AddressDTO {
    private String street;
    private int number;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String State;

    public AddressDTO(){

    }

    public AddressDTO(String street, int number, String neighborhood, String zipcode, String city, String state) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.zipcode = zipcode;
        this.city = city;
        State = state;
    }

    
}
