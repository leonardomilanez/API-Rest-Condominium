// package br.unesp.rc.MSCondominiumG1.dto.assembler;
package br.unesp.rc.MSCondominiumG1.dto.assembler;

import br.unesp.rc.MSCondominiumG1.dto.*;
import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.entity.Common;
import br.unesp.rc.MSCondominiumG1.entity.RentableArea;
import br.unesp.rc.MSCondominiumG1.entity.Specific;

public class AreaAssembler {

    private AreaAssembler() {
        // Private constructor to prevent instantiation.
    }

    /**
     * Converts an AreaDTO to a new Area entity, in a style similar to the
     * tutorial.
     */
    public static Area dtoToEntityModel(AreaCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        Area area = switch (dto) {
            case RentableAreaCreateDTO rentableDto -> {
                RentableArea r = new RentableArea();
                r.setLocation(rentableDto.getLocation());
                r.setCapacity(rentableDto.getCapacity());
                r.setValue(rentableDto.getValue());
                yield r;
            }
            case CommonAreaCreateDTO commonDto -> {
                Common c = new Common();
                c.setLocation(commonDto.getLocation());
                yield c;
            }
            case SpecificAreaCreateDTO specificDto -> {
                Specific s = new Specific();
                s.setDescription(specificDto.getDescription());
                yield s;
            }
            default -> throw new IllegalArgumentException("Tipo de DTO desconhecido");
        };

        // Preenchemos os dados da classe pai
        area.setName(dto.getName());
        area.setSizeSM(dto.getSizeSM());

        return area;
    }

    public static AreaDTO entityToDto(Area entity) {
        if (entity == null) {
            return null;
        }

        // Instancia o DTO correto baseado no tipo da Entidade real
        AreaDTO dto = switch (entity) {
            case RentableArea rentable -> {
                RentableAreaDTO rDto = new RentableAreaDTO();
                rDto.setLocation(rentable.getLocation());
                rDto.setCapacity(rentable.getCapacity());
                rDto.setValue(rentable.getValue());
                yield rDto;
            }
            case Common common -> {
                CommonAreaDTO cDto = new CommonAreaDTO();
                cDto.setLocation(common.getLocation());
                yield cDto;
            }
            case Specific specific -> {
                SpecificAreaDTO sDto = new SpecificAreaDTO();
                sDto.setDescription(specific.getDescription());
                yield sDto;
            }
            default -> throw new IllegalArgumentException("Entidade Area de tipo desconhecido.");
        };

        // Preenche os dados base que existem em qualquer AreaDTO
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSizeSM(entity.getSizeSM());
        // Se a entidade tivesse o Condominium carregado, você também setaria o condominiumId aqui.

        if (entity.getCondominium() != null) {
            dto.setCondominiumId(entity.getCondominium().getId());
        }

        return dto;
    }
}
