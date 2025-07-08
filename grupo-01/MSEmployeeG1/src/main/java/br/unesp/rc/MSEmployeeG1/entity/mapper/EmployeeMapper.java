package br.unesp.rc.MSEmployeeG1.entity.mapper;

import br.unesp.rc.MSEmployeeG1.entity.Access;
import br.unesp.rc.MSEmployeeG1.entity.Address;
import br.unesp.rc.MSEmployeeG1.entity.Contact;
import br.unesp.rc.MSEmployeeG1.entity.Employee;

public class EmployeeMapper {
    private EmployeeMapper() {

    }

    public static void update(Employee employeeUpdate, Employee newEmployee) {

        employeeUpdate.setBirthDate(newEmployee.getBirthDate());

        employeeUpdate.setName(newEmployee.getName());

        Access a = employeeUpdate.getAcess();
        a.setUser(newEmployee.getAcess().getUser());
        a.setPassword(newEmployee.getAcess().getPassword());
        employeeUpdate.setAcess(a);

        Contact c = employeeUpdate.getContact();
        c.setPhoneHome(newEmployee.getContact().getPhoneHome());
        c.setPhoneCommercial(newEmployee.getContact().getPhoneCommercial());
        c.setCellPhone(newEmployee.getContact().getCellPhone());
        c.setEmail(newEmployee.getContact().getEmail());
        employeeUpdate.setContact(c);

        int i = 0;
        for (Address e : employeeUpdate.getAddress()) {
            Address edto = newEmployee.getAddress().get(i);
            e.setStreet(edto.getStreet());
            e.setNumber(edto.getNumber());
            e.setNeighborhood(edto.getNeighborhood());
            e.setZipCode(edto.getZipCode());
            e.setCity(edto.getCity());
            e.setState(edto.getState());
            i++;
        }
    }
}
