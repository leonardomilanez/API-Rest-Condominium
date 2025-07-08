package br.unesp.rc.MSResidentG1.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unesp.rc.MSResidentG1.dto.MaintenanceRequestDTO;
import br.unesp.rc.MSResidentG1.utils.RabbitMQConfig;

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
