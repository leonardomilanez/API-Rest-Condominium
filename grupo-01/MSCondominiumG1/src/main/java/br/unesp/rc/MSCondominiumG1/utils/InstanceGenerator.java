// package br.unesp.rc.MSCondominiumG1.utils;
package br.unesp.rc.MSCondominiumG1.utils;

import java.util.ArrayList;

import br.unesp.rc.MSCondominiumG1.entity.Common;
import br.unesp.rc.MSCondominiumG1.entity.Condominium;
import br.unesp.rc.MSCondominiumG1.entity.CondominiumType;
import br.unesp.rc.MSCondominiumG1.entity.Specific;
import br.unesp.rc.MSCondominiumG1.entity.Unit;

/**
 * Utility class to generate entity instances for testing and demonstration.
 */
public class InstanceGenerator {

    private InstanceGenerator() {
        // Private constructor to prevent instantiation.
    }

    public static Condominium getCondominium(String name, CondominiumType type) {
        Condominium condominium = new Condominium();
        condominium.setName(name);
        condominium.setType(type);
        condominium.setAreas(new ArrayList<>());
        condominium.setUnits(new ArrayList<>());

        // Create example areas (using concrete classes)
        Common area1 = new Common();
        area1.setName("Swimming Pool");
        area1.setSizeSM(200);
        area1.setLocation("Leisure Area");
        // We DON'T call area1.setCondominium() anymore.

        Specific area2 = new Specific();
        area2.setName("Electrical Room");
        area2.setSizeSM(25);
        area2.setDescription("High voltage equipment. Authorized personnel only.");
        // We DON'T call area2.setCondominium() anymore.

        // Associate areas by adding them to the parent's list
        condominium.getAreas().add(area1);
        condominium.getAreas().add(area2);

        // Create example units
        Unit unit1 = new Unit();
        unit1.setIdUnit("A101");
        unit1.setLocation("Block A");
        unit1.setSizeSM(85.5);
        // We DON'T call unit1.setCondominium() anymore.

        Unit unit2 = new Unit();
        unit2.setIdUnit("B202");
        unit2.setLocation("Block B");
        unit2.setSizeSM(95.0);
        // We DON'T call unit2.setCondominium() anymore.

        // Associate units by adding them to the parent's list
        condominium.getUnits().add(unit1);
        condominium.getUnits().add(unit2);

        return condominium;
    }
}
