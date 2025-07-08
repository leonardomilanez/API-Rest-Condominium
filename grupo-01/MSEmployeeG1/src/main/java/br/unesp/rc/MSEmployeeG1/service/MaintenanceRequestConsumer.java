package br.unesp.rc.MSEmployeeG1.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import br.unesp.rc.MSEmployeeG1.dto.MaintenanceRequestDTO;
import br.unesp.rc.MSEmployeeG1.utils.RabbitMQConfig;

@Service
public class MaintenanceRequestConsumer {

    @RabbitListener(queues = "maintenance.request.queue")
    public void receiveMaintenanceRequest(MaintenanceRequestDTO request) {
        System.out.println("Received maintenance request:");
        System.out.println("Area: " + request.getArea());
        System.out.println("Description: " + request.getDescription());
        System.out.println("Resident name: " + request.getResidentName());
    }
}
