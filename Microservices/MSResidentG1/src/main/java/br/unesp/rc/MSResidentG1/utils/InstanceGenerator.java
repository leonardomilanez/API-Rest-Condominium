package br.unesp.rc.MSResidentG1.utils;

import java.util.Date;

import br.unesp.rc.MSResidentG1.entity.Access;
import br.unesp.rc.MSResidentG1.entity.Address;
import br.unesp.rc.MSResidentG1.entity.Contact;
import br.unesp.rc.MSResidentG1.entity.Resident;
import br.unesp.rc.MSResidentG1.entity.ResidentType;
import br.unesp.rc.MSResidentG1.entity.Unit;

public class InstanceGenerator {
    
    private InstanceGenerator() {
    }

    public static Resident getResident(String cpf, String user) {
        Resident resident = new Resident();
        resident.setCpf(cpf);
        resident.setBirthDate(new Date());
        resident.setName("Brendo Medeiros Milanez");
        resident.setResidentType(ResidentType.OWNER);

        Access access = new Access();
        access.setUser(user);
        access.setPassword("123456");
        resident.setAccess(access);

        Contact contact = new Contact();
        contact.setPhoneHome("1111-2222");
        contact.setPhoneCommercial("3333-4444");
        contact.setCellPhone("5555-6666");
        contact.setEmail("bren.med.mil@gmail.com");
        resident.setContact(contact);

        Unit unit = new Unit();
        unit.setLocation("Location 1");
        unit.setSizeSM(100);
        resident.setUnit(unit);

        Address address1 = new Address();
        address1.setStreet("Street 1");
        address1.setNumber("111");
        address1.setNeighborhood("Neighborhood 1");
        address1.setZipCode("11111-111");
        address1.setCity("City 1");
        address1.setState("State 1");
        
        Address address2 = new Address();
        address2.setStreet("Street 2");
        address2.setNumber("222");
        address2.setNeighborhood("Neighborhood 2");
        address2.setZipCode("22222-222");
        address2.setCity("City 2");
        address2.setState("State 2");

        resident.setAddress(address1);
        resident.setAddress(address2);

        return resident;
    }
}
