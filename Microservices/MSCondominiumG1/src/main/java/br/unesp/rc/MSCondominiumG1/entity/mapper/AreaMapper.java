package br.unesp.rc.MSCondominiumG1.entity.mapper;

import br.unesp.rc.MSCondominiumG1.dto.AreaPatchDTO;
import br.unesp.rc.MSCondominiumG1.dto.CommonAreaPatchDTO;
import br.unesp.rc.MSCondominiumG1.dto.RentableAreaPatchDTO;
import br.unesp.rc.MSCondominiumG1.dto.SpecificAreaPatchDTO;
import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.entity.Common;
import br.unesp.rc.MSCondominiumG1.entity.RentableArea;
import br.unesp.rc.MSCondominiumG1.entity.Specific;

import java.util.function.Consumer;

public class AreaMapper {

    private AreaMapper() {
        // Private constructor to prevent instantiation of this utility class.
    }

    /**
     * Updates an existing Area entity with data from another Area instance.
     * This method handles the different types of Areas (Common, Specific,
     * RentableArea) by checking their instance type before updating specific
     * fields.
     *
     * * @param existingArea The entity fetched from the database to be
     * updated.
     * @param dto An entity object containing the new data.
     */
    public static void partialUpdate(Area existingArea, AreaPatchDTO dto) {

        // Atualiza campos da classe pai
        setIfNotNull(dto.getName(), existingArea::setName);
        setIfNotNull(dto.getSizeSM(), existingArea::setSizeSM);

        // Atualiza campos específicos garantindo que a Entidade e o DTO batem
        if (existingArea instanceof RentableArea r && dto instanceof RentableAreaPatchDTO rDto) {
            setIfNotNull(rDto.getLocation(), r::setLocation);
            setIfNotNull(rDto.getCapacity(), r::setCapacity);
            setIfNotNull(rDto.getValue(), r::setValue);

        } else if (existingArea instanceof Common c && dto instanceof CommonAreaPatchDTO cDto) {
            setIfNotNull(cDto.getLocation(), c::setLocation);

        } else if (existingArea instanceof Specific s && dto instanceof SpecificAreaPatchDTO sDto) {
            setIfNotNull(sDto.getDescription(), s::setDescription);
        }

    }

    private static <T> void setIfNotNull(T value, Consumer<T> setter) {
        if (value != null) setter.accept(value);
    }
}
