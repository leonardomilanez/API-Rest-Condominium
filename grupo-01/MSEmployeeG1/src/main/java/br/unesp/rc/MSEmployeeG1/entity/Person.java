package br.unesp.rc.MSEmployeeG1.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Person")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, exclude = {"birthdate"})
@ToString
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    
    @Column(name = "cpf", unique = true) // See if that will work
    private String cpf;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_contactId")
    private Contact contact;
    private Acess acess;


    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "person_id")
    private List<Address> address;

    public Person(){
        this.address = new ArrayList<>();
    }
    
    public void setAddress(Address address){
        this.address.add(address);
    }

}
