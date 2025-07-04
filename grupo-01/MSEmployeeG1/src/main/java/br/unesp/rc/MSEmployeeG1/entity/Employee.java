package br.unesp.rc.MSEmployeeG1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@EqualsAndHashCode
@ToString(callSuper = true, includeFieldNames = true)
public class Employee extends Person {

    private static final long serialVersionUID = 1L;

    @Column(name = "enrollmentNumber", unique = true)
    private int enrollmentNumber;

    public Employee() {
    }
    
}
