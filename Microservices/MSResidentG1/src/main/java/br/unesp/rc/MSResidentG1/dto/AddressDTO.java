package br.unesp.rc.MSResidentG1.dto;

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
    private String number;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;

    public AddressDTO() {
    }

    public AddressDTO(String street, String number, String neighborhood, String zipCode, String city, String state) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }
}
