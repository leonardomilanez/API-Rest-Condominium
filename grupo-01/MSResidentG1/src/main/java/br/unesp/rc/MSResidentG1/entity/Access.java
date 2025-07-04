package br.unesp.rc.MSResidentG1.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable

public class Access implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "user_access", unique = true)
    private String user;

    @Column(name = "password_access")
    private String password;

    public Access() {
    }
}
