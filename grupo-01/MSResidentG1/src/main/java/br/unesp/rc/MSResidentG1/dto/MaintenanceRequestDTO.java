package br.unesp.rc.MSResidentG1.dto;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO used to represent a maintenance request that will be sent
 * from the MSResident service to the MSEmployee service via RabbitMQ.
 */

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MaintenanceRequestDTO implements Serializable {
    private String area;
    private String description;
    private String residentName;


}
