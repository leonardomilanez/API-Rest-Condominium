package br.unesp.rc.MSEmployeeG1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.unesp.rc.MSEmployeeG1.entity.Employee;
import br.unesp.rc.MSEmployeeG1.repository.EmployeeRepository;

@Component
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public EmployeeService() {

    }

    public Employee save(Employee entity) {
        Employee persistedEntity = null;

        if (repository != null) {
            persistedEntity = repository.save(entity);
        }

        return persistedEntity;
    }

    public Employee findByCpf(String cpf) {
        Employee insertedEntity = null;

        if (repository != null) {
            insertedEntity = repository.findByCpf(cpf);
        }

        return insertedEntity;
    }

    public Employee findByEnrollmentNumber(int enrollmentNumber) {
        Employee insertedEntity = null;

        if (repository != null) {
            insertedEntity = repository.findByEnrollmentNumber(enrollmentNumber);
        }

        return insertedEntity;
    }

    public void delete(Employee entity) {
        if (repository != null) {
            repository.delete(entity);
        }
    }

    public Employee update(Employee entity) {
        Employee persistedEntity = null;
        if (repository != null) {
            persistedEntity = repository.save(entity);
        }

        return persistedEntity;
    }

    public List<Employee> findAll() {
        List<Employee> list = null;
        if (repository != null) {
            list = new ArrayList<>();
            list = repository.findAll();
        }
        return list;
    }
}
