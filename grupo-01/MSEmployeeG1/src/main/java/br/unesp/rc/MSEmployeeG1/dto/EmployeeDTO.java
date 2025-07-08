package br.unesp.rc.MSEmployeeG1.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeDTO {
    private String user;
    private String password;
    private String phoneHome;
    private String phoneCommercial;
    private String cellphone;
    private String email;
    private String name;
    private String cpf;
    private int enrollmentNumber;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date birthDate;
    private List<AddressDTO> address;

    public EmployeeDTO() {
        this.address = new ArrayList<>();
    }

    public EmployeeDTO(String user, String password, String phoneHome, String phoneCommercial, String cellphone,
            String email, String name, String cpf, int enrollmentNumber, Date birthDate, List<AddressDTO> address) {
        this.user = user;
        this.password = password;
        this.phoneHome = phoneHome;
        this.phoneCommercial = phoneCommercial;
        this.cellphone = cellphone;
        this.email = email;
        this.name = name;
        this.cpf = cpf;
        this.enrollmentNumber = enrollmentNumber;
        this.birthDate = birthDate;
        this.address = address;
    }



    


}
