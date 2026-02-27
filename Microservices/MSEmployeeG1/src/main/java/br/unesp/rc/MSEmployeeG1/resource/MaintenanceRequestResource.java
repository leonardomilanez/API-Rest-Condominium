package br.unesp.rc.MSEmployeeG1.resource;

import java.util.Collection;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unesp.rc.MSEmployeeG1.dto.MaintenanceRequestDTO;
import br.unesp.rc.MSEmployeeG1.service.MaintenanceRequestConsumer;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceRequestResource {
    private final MaintenanceRequestConsumer consumer;

    public MaintenanceRequestResource(MaintenanceRequestConsumer consumer) {
        this.consumer = consumer;
    }

    @GetMapping("/received")
    public ResponseEntity<Collection<MaintenanceRequestDTO>> getReceivedRequests() {
        return ResponseEntity.ok(consumer.getAllRequests());
    }

    @GetMapping("/received/{id}")
    public ResponseEntity<MaintenanceRequestDTO> getById(@PathVariable UUID id) {
        MaintenanceRequestDTO request = consumer.getById(id);
        if (request != null) {
            return ResponseEntity.ok(request);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/received/{id}")
    public ResponseEntity<String> deleteReceivedRequest(@PathVariable UUID id) {
        boolean removed = consumer.deleteById(id);
        if (removed) {
            return ResponseEntity.ok("Notification removed.");
        } else {
            return ResponseEntity.status(404).body("Notification not found.");
        }
    }
}
