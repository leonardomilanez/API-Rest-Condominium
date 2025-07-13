package br.unesp.rc.MSCondominiumG1.entity.mapper;

import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.entity.Condominium;

public class AreaMapper {
        private AreaMapper() {
        // Construtor privado para evitar instância
    }

    public static void update(Area areaUpdate, Area newArea) {
        areaUpdate.setName(newArea.getName());
        areaUpdate.setSizeSM(newArea.getSizeSM());

        if (newArea.getCondominium() != null) {
            Condominium condominium = newArea.getCondominium();
            areaUpdate.setCondominium(condominium);
        }
    }
}
