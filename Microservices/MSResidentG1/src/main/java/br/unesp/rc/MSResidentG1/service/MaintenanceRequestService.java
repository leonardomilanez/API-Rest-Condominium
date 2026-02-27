package br.unesp.rc.MSResidentG1.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unesp.rc.MSResidentG1.dto.MaintenanceRequestDTO;
import br.unesp.rc.MSResidentG1.utils.RabbitMQConfig;

/**
 * Service responsible for sending maintenance request messages
 * to the RabbitMQ exchange defined in RabbitMQConfig.
 * 
 * Uses RabbitTemplate to convert and send
 * MaintenanceRequestDTO objects as JSON messages to the configured
 * exchange and routing key, enabling asynchronous communication
 * with the MSEmployee service.
 */

@Service
public class MaintenanceRequestService {
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public MaintenanceRequestService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMaintenanceRequest(MaintenanceRequestDTO requestDTO) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                requestDTO);
    }
}
