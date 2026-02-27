package br.unesp.rc.MSCondominiumG1.entity;

import java.io.Serial;
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
@Table(name = "condominium")
@Getter
@Setter
@NoArgsConstructor
public class Condominium implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CondominiumType type;

    @OneToMany(mappedBy = "condominium", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Area> areas;

    @OneToMany(mappedBy = "condominium", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Unit> units;

    public void addArea(Area area) {
        areas.add(area);
        area.setCondominium(this);
    }

    public void removeArea(Area area) {
        areas.remove(area);
        area.setCondominium(null);
    }

    public void addUnit(Unit unit) {
        units.add(unit);
        unit.setCondominium(this);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
        unit.setCondominium(null);
    }
}
