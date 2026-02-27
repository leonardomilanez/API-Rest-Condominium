package br.unesp.rc.MSResidentG1.entity.mapper;

import br.unesp.rc.MSResidentG1.entity.Access;
import br.unesp.rc.MSResidentG1.entity.Address;
import br.unesp.rc.MSResidentG1.entity.Contact;
import br.unesp.rc.MSResidentG1.entity.Resident;
import br.unesp.rc.MSResidentG1.entity.Unit;

public class ResidentMapper {

    private ResidentMapper() {
    }

    public static void update(Resident residentUpdate, Resident newResident) {

        residentUpdate.setName(newResident.getName());
        residentUpdate.setBirthDate(newResident.getBirthDate());
        residentUpdate.setResidentType(newResident.getResidentType());

        Access access = residentUpdate.getAccess();
        access.setUser(newResident.getAccess().getUser());
        access.setPassword(newResident.getAccess().getPassword());
        residentUpdate.setAccess(access);

        Contact contact = residentUpdate.getContact();
        contact.setPhoneHome(newResident.getContact().getPhoneHome());
        contact.setPhoneCommercial(newResident.getContact().getPhoneCommercial());
        contact.setCellPhone(newResident.getContact().getCellPhone());
        contact.setEmail(newResident.getContact().getEmail());
        residentUpdate.setContact(contact);

        Unit unit = residentUpdate.getUnit();
        unit.setLocation(newResident.getUnit().getLocation());
        unit.setSizeSM(newResident.getUnit().getSizeSM());
        residentUpdate.setUnit(unit);

        int i = 0;
        for (Address e : residentUpdate.getAddress()) {
            Address adto = newResident.getAddress().get(i);
            e.setStreet(adto.getStreet());
            e.setNumber(adto.getNumber());
            e.setNeighborhood(adto.getNeighborhood());
            e.setZipCode(adto.getZipCode());
            e.setCity(adto.getCity());
            e.setState(adto.getState());
            i++;
        }
    }
}