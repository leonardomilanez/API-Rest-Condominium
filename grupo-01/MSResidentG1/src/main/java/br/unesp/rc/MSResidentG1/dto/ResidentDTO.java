package br.unesp.rc.MSResidentG1.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.unesp.rc.MSResidentG1.entity.ResidentType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResidentDTO {
    
    private String user;
    private String password;
    private String phoneHome;
    private String phoneCommercial;
    private String cellPhone;
    private String email;
    private String name;
    private String cpf;
    private ResidentType residentType;
    private String unitLocation;
    private double unitSizeSM;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date birthDate;
    private List<AddressDTO> address;

    public ResidentDTO() {
        this.address = new ArrayList<>();
    }

    public ResidentDTO(String user, String password, String phoneHome, String phoneCommercial, String cellPhone,
            String email, String name, String cpf, ResidentType residentType, String unitLocation, double unitSizeSM, Date birthDate, List<AddressDTO> address) {
        this.user = user;
        this.password = password;
        this.phoneHome = phoneHome;
        this.phoneCommercial = phoneCommercial;
        this.cellPhone = cellPhone;
        this.email = email;
        this.name = name;
        this.cpf = cpf;
        this.residentType = residentType;
        this.unitLocation = unitLocation;
        this.unitSizeSM = unitSizeSM;
        this.birthDate = birthDate;
        this.address = address;
    }
}
