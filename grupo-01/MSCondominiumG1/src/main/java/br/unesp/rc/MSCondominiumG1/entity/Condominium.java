package br.unesp.rc.MSCondominiumG1.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Ensure this import is present
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Condominium")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Condominium implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CondominiumType type;

    @OneToMany(mappedBy = "condominium", cascade = CascadeType.ALL)
    private List<Unit> units;

    @OneToMany(mappedBy = "condominium", cascade = CascadeType.ALL)
    private List<Area> areas;
}
