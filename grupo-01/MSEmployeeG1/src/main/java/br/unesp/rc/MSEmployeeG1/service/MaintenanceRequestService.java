package br.unesp.rc.MSEmployeeG1.service;

import org.springframework.stereotype.Service;

import br.unesp.rc.MSEmployeeG1.dto.MaintenanceRequestDTO;

/**
 * It process the requested maintenance
 */

@Service
public class MaintenanceRequestService {
    

    public void processRequest(MaintenanceRequestDTO dto){
        //Maybe verify if the area exists?
    }


}
