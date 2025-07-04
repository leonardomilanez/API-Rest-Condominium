package br.unesp.rc.MSEmployeeG1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unesp.rc.MSEmployeeG1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByCpf(String cpf);
}
