package br.unesp.rc.MSEmployeeG1.utils;

import java.util.Date;

import br.unesp.rc.MSEmployeeG1.entity.Acess;
import br.unesp.rc.MSEmployeeG1.entity.Address;
import br.unesp.rc.MSEmployeeG1.entity.Contact;
import br.unesp.rc.MSEmployeeG1.entity.Employee;

public class InstanceGenerator {
    private InstanceGenerator(){

    }

    public static Employee getEmployee(String cpf, String user){
        Employee employee = new Employee();

        employee.setEnrollmentNumber(1);

        employee.setCpf(cpf);
        employee.setBirthDate(new Date());
        employee.setName("Brendo Medeiros Milanez");

        Acess acess = new Acess();
        acess.setUser(user);
        acess.setPassword("123456");
        employee.setAcess(acess);

        Contact contact = new Contact();
        contact.setPhoneHome("1111-2222");
        contact.setPhoneCommercial("3333-4444");
        contact.setCellPhone("5555-6666");
        contact.setEmail("bren.med.mil@gmail.com");
        employee.setContact(contact);
        
        Address address1 = new Address();
        address1.setStreet("Street 1");
        address1.setNumber(111);
        address1.setNeighborhood("Neighborhood 1");
        address1.setZipCode("11111-111");
        address1.setCity("City 1");
        address1.setState("State 1");

        Address address2 = new Address();
        address2.setStreet("Street 2");
        address2.setNumber(222);
        address2.setNeighborhood("Neighborhood 2");
        address2.setZipCode("22222-222");
        address2.setCity("City 2");
        address2.setState("State 2");

        employee.setAddress(address1);
        employee.setAddress(address2);

        return employee;

    }
}
