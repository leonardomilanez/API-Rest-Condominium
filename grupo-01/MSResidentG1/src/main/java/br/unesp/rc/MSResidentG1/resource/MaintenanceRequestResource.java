package br.unesp.rc.MSResidentG1.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unesp.rc.MSResidentG1.dto.MaintenanceRequestDTO;
import br.unesp.rc.MSResidentG1.service.MaintenanceRequestService;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceRequestResource {
    private final MaintenanceRequestService service;

    public MaintenanceRequestResource(MaintenanceRequestService service) {
        this.service = service;
    }

    @PostMapping("/request")
    public ResponseEntity<String> requestMaintenance(@RequestBody MaintenanceRequestDTO dto) {
        service.sendMaintenanceRequest(dto);
        return ResponseEntity.ok("Maintenance request sent.");
    }
}
