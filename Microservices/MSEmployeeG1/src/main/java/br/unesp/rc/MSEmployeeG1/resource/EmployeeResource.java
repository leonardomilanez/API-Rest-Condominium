package br.unesp.rc.MSEmployeeG1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unesp.rc.MSEmployeeG1.dto.EmployeeDTO;
import br.unesp.rc.MSEmployeeG1.dto.assembler.EmployeeAssembler;
import br.unesp.rc.MSEmployeeG1.entity.Employee;
import br.unesp.rc.MSEmployeeG1.entity.mapper.EmployeeMapper;
import br.unesp.rc.MSEmployeeG1.service.EmployeeService;

@RestController
@RequestMapping("/employee/v1")
public class EmployeeResource {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{cpf}")
    public Employee getEmployeeByCpf(@PathVariable(value = "cpf") String cpf) {
        Employee employee = employeeService.findByCpf(cpf);
        return employee;
    }

    @GetMapping("/employee/{enrollmentNumber}")
    public Employee getEmployeeByEnrollmentNumber(@PathVariable(value = "enrollmentNumber") int enrollmentNumber) {
        Employee employee = employeeService.findByEnrollmentNumber(enrollmentNumber);
        return employee;
    }

    @DeleteMapping("/employee/{cpf}")
    public boolean delete(@PathVariable(value = "cpf") String cpf) {
        boolean delete = false;
        Employee employeeDelete = employeeService.findByCpf(cpf);
        if (employeeDelete != null) {
            employeeService.delete(employeeDelete);
            delete = true;
        }

        return delete;
    }

    @PostMapping("/employee")
    public boolean saveEmployee(@RequestBody EmployeeDTO employeeDto) {
        boolean insert = false;

        Employee employee = EmployeeAssembler.dtoToEntityModel(employeeDto);
        Employee employeeInsert = employeeService.save(employee);
        if (employeeInsert != null) {
            insert = true;
        }

        return insert;
    }

    @PutMapping("/employee")
    public boolean update(@RequestBody EmployeeDTO employeeDTO) {
        boolean update = false;

        Employee newEmployee = EmployeeAssembler.dtoToEntityModel(employeeDTO);
        Employee employeeUpdate = employeeService.findByCpf(newEmployee.getCpf());

        EmployeeMapper.update(employeeUpdate, newEmployee);

        Employee employeeUpdated = employeeService.update(employeeUpdate);
        if (employeeUpdated != null) {
            update = true;
        }

        return update;
    }
}
