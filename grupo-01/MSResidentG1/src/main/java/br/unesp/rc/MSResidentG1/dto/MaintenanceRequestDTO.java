package br.unesp.rc.MSResidentG1.dto;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Here, MaintenanceRequestDTO will produce a message that has
 * the follow structure.
 */


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MaintenanceRequestDTO implements Serializable {
    private String area;
    private String description;
    private String residentName;

    //Should we use the resident's name or their id?
    //private Long residentId; 
}
