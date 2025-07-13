package br.unesp.rc.MSCondominiumG1.dto.assembler;

import br.unesp.rc.MSCondominiumG1.dto.AreaDTO;
import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.entity.Condominium;

public class AreaAssembler {
        private AreaAssembler() {
       
    }

    public static Area dtoToEntityModel(AreaDTO dto) {
        Area area = new Area();

        area.setId(dto.getId());
        area.setName(dto.getName());
        area.setSizeSM(dto.getSizeSM());

        if (dto.getCondominiumId() != null) {
            Condominium condominium = new Condominium();
            condominium.setId(dto.getCondominiumId()); 
            area.setCondominium(condominium);
        }

        return area;
    }
}
