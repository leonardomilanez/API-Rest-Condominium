// package br.unesp.rc.MSCondominiumG1.dto.assembler;
package br.unesp.rc.MSCondominiumG1.dto.assembler;

import br.unesp.rc.MSCondominiumG1.dto.AreaDTO;
import br.unesp.rc.MSCondominiumG1.dto.AreaTypeDTO;
import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.entity.Common;
import br.unesp.rc.MSCondominiumG1.entity.Specific;

public class AreaAssembler {

    private AreaAssembler() {
        // Private constructor to prevent instantiation.
    }

    /**
     * Converts an AreaDTO to a new Area entity, in a style similar to the
     * tutorial.
     */
    public static Area dtoToEntityModel(AreaDTO dto) {
        if (dto == null) {
            return null;
        }

        Area entity;

        // Check the type from the DTO to decide which class to instantiate
        if (dto.getType() == AreaTypeDTO.SPECIFIC) {
            Specific specificArea = new Specific();
            specificArea.setDescription(dto.getDescription());
            entity = specificArea;
        } else {
            // Default to Common if the type is COMMON or null
            Common commonArea = new Common();
            commonArea.setLocation(dto.getLocation());
            entity = commonArea;
        }

        // Set the base properties
        entity.setName(dto.getName());
        entity.setSizeSM(dto.getSizeSM());

        return entity;
    }
}
