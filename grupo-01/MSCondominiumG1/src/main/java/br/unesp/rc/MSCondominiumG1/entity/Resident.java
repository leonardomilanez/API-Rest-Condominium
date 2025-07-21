package br.unesp.rc.MSCondominiumG1.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Resident")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resident implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // O UML define estes campos. Usamos "idResident" para o ID vindo do outro microserviço
    private int idResident;
    private String name;
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private ResidentType type;

    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL)
    private List<Unit> units;
}
