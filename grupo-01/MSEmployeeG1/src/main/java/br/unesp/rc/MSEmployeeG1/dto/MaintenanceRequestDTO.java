package br.unesp.rc.MSEmployeeG1.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The main goal of this DTO is to receive the request for maintenance
 * of a common area of the condominium from MSResident through the API.
 */



@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MaintenanceRequestDTO {
    private String area;
    private String residentName;
    private String description;


    public MaintenanceRequestDTO(String area, String residentName, String description) {
        this.area = area;
        this.residentName = residentName;
        this.description = description;
    }


}
