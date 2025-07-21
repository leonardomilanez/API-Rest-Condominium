package br.unesp.rc.MSCondominiumG1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "specific_area")
@ToString(callSuper = true)

public class Specific extends Area {

    private static final long serialVersionUID = 1L;

    private String description;

}
