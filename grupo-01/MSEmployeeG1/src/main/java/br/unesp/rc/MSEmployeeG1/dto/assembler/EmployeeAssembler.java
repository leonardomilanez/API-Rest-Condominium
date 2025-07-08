package br.unesp.rc.MSEmployeeG1.dto.assembler;

import br.unesp.rc.MSEmployeeG1.dto.AddressDTO;
import br.unesp.rc.MSEmployeeG1.dto.EmployeeDTO;
import br.unesp.rc.MSEmployeeG1.entity.Access;
import br.unesp.rc.MSEmployeeG1.entity.Address;
import br.unesp.rc.MSEmployeeG1.entity.Contact;
import br.unesp.rc.MSEmployeeG1.entity.Employee;

public class EmployeeAssembler {
    private EmployeeAssembler() {

    }

    public static Employee dtoToEntityModel(EmployeeDTO dto) {
        Employee employee = new Employee();

        employee.setCpf(dto.getCpf());
        employee.setBirthDate(dto.getBirthDate());
        employee.setName(dto.getName());

        Access a = new Access();
        a.setUser(dto.getUser());
        a.setPassword(dto.getPassword());
        employee.setAcess(a);

        Contact c = new Contact();
        c.setPhoneHome(dto.getPhoneHome());
        c.setPhoneCommercial(dto.getPhoneCommercial());
        c.setCellPhone(dto.getCellphone());
        c.setEmail(dto.getEmail());
        employee.setContact(c);

        for (AddressDTO edto : dto.getAddress()) {
            Address e = new Address();
            e.setStreet(edto.getStreet());
            e.setNumber(edto.getNumber());
            e.setNeighborhood(edto.getNeighborhood());
            e.setZipCode(edto.getZipcode());
            e.setCity(edto.getCity());
            e.setState(edto.getState());
            employee.setAddress(e);
        }
        return employee;
    }
}
