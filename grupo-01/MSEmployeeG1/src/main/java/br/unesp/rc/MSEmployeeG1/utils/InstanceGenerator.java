package br.unesp.rc.MSEmployeeG1.utils;

import java.util.Date;

import br.unesp.rc.MSEmployeeG1.entity.Access;
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
        employee.setName("Michael Scott");

        Access access = new Access();
        access.setUser(user);
        access.setPassword("123456");
        employee.setAcess(access);

        Contact contact = new Contact();
        contact.setPhoneHome("1421-9658");
        contact.setPhoneCommercial("5136-0251");
        contact.setCellPhone("3025-5245");
        contact.setEmail("michael-scott@gmail.com");
        employee.setContact(contact);
        
        Address address1 = new Address();
        address1.setStreet("Kellum Court");
        address1.setNumber(126);
        address1.setNeighborhood("Kellum Court Complex");
        address1.setZipCode("18508-000");
        address1.setCity("Scranton");
        address1.setState("Pennsylvania");

        Address address2 = new Address();
        address2.setStreet("Bessemer Street");
        address2.setNumber(222);
        address2.setNeighborhood("Reseda");
        address2.setZipCode("91335-000");
        address2.setCity("Los Angeles");
        address2.setState("California");

        employee.setAddress(address1);
        employee.setAddress(address2);

        return employee;

    }
}
