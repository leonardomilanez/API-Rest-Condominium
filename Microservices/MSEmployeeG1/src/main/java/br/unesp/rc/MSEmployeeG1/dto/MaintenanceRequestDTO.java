package br.unesp.rc.MSEmployeeG1.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO used to receive maintenance request messages from the MSResident service
 * through the RabbitMQ messaging system.
 *
 * This object represents the content of the message sent via RabbitMQ to the
 * MSEmployee service when a resident requests maintenance for a common area.
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MaintenanceRequestDTO implements Serializable {
    private UUID id = UUID.randomUUID();
    private String area;
    private String residentName;
    private String description;




}
