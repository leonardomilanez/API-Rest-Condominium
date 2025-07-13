package br.unesp.rc.MSCondominiumG1.utils;

import java.util.ArrayList;
import java.util.List;

import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.entity.Condominium;
import br.unesp.rc.MSCondominiumG1.entity.CondominiumType;
import br.unesp.rc.MSCondominiumG1.entity.Unit;

/**
 * Utility class to generate entity instances for testing purposes, mirroring
 * the pattern used in the tutorials.
 */
public class InstanceGenerator {
    public static Condominium getCondominium(String name, CondominiumType type) {
        Condominium condominium = new Condominium();
        condominium.setName(name);
        condominium.setType(type);

        // Criando áreas de exemplo
        Area area1 = new Area();
        area1.setName("Piscina");
        area1.setSizeSM(200);
        area1.setCondominium(condominium);

        Area area2 = new Area();
        area2.setName("Salão de Festas");
        area2.setSizeSM(300);
        area2.setCondominium(condominium);

        List<Area> areas = new ArrayList<>();
        areas.add(area1);
        areas.add(area2);
        condominium.setAreas(areas);

        // Criando unidades de exemplo
        Unit unit1 = new Unit();
        unit1.setIdUnit("A101");
        unit1.setLocation("Bloco A");
        unit1.setSizeSM(85.5);
        unit1.setCondominium(condominium);

        Unit unit2 = new Unit();
        unit2.setIdUnit("B202");
        unit2.setLocation("Bloco B");
        unit2.setSizeSM(95.0);
        unit2.setCondominium(condominium);

        List<Unit> units = new ArrayList<>();
        units.add(unit1);
        units.add(unit2);
        condominium.setUnits(units);

        return condominium;
    }

}
