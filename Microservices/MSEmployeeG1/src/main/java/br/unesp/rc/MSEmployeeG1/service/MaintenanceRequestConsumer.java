package br.unesp.rc.MSEmployeeG1.service;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import br.unesp.rc.MSEmployeeG1.dto.MaintenanceRequestDTO;

/**
 * The purpose of this class is to consume RabbitMQ's messages. It will receive
 * notifications send by MSResident
 */

@Service
public class MaintenanceRequestConsumer {

    private final Map<UUID, MaintenanceRequestDTO> receivedRequests = new ConcurrentHashMap<>();

    @RabbitListener(queues = "maintenance.request.queue")
    public void receiveMaintenanceRequest(MaintenanceRequestDTO request) {
        receivedRequests.put(request.getId(), request);
    }

    public Collection<MaintenanceRequestDTO> getAllRequests() {
        return receivedRequests.values();
    }

    public MaintenanceRequestDTO getById(UUID id) {
        return receivedRequests.get(id);
    }

    public boolean deleteById(UUID id) {
        return receivedRequests.remove(id) != null;
    }
}
