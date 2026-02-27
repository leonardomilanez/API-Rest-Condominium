package br.unesp.rc.MSResidentG1.dto.assembler;

import br.unesp.rc.MSResidentG1.dto.AddressDTO;
import br.unesp.rc.MSResidentG1.dto.ResidentDTO;
import br.unesp.rc.MSResidentG1.entity.Access;
import br.unesp.rc.MSResidentG1.entity.Address;
import br.unesp.rc.MSResidentG1.entity.Contact;
import br.unesp.rc.MSResidentG1.entity.Resident;
import br.unesp.rc.MSResidentG1.entity.Unit;

public class ResidentAssembler {
    public static Resident dtoToEntityModel(ResidentDTO dto) {
        Resident resident = new Resident();

        resident.setCpf(dto.getCpf());
        resident.setBirthDate(dto.getBirthDate());
        resident.setName(dto.getName());
        resident.setResidentType(dto.getResidentType());

        Access a = new Access();
        a.setUser(dto.getUser());
        a.setPassword(dto.getPassword());
        resident.setAccess(a);

        Contact c = new Contact();
        c.setPhoneHome(dto.getPhoneHome());
        c.setPhoneCommercial(dto.getPhoneCommercial());
        c.setCellPhone(dto.getCellPhone());
        c.setEmail(dto.getEmail());
        resident.setContact(c);

        Unit u = new Unit();
        u.setLocation(dto.getUnitLocation());
        u.setSizeSM(dto.getUnitSizeSM());
        resident.setUnit(u);

        for (AddressDTO edto : dto.getAddress()) {
            Address e = new Address();
            e.setStreet(edto.getStreet());
            e.setNumber(edto.getNumber());
            e.setNeighborhood(edto.getNeighborhood());
            e.setZipCode(edto.getZipCode());
            e.setCity(edto.getCity());
            e.setState(edto.getState());
            resident.setAddress(e);
        }

        return resident;
    }
}
