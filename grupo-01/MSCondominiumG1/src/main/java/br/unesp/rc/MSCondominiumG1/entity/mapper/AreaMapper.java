package br.unesp.rc.MSCondominiumG1.entity.mapper;

import br.unesp.rc.MSCondominiumG1.entity.Area;
import br.unesp.rc.MSCondominiumG1.entity.Common;
import br.unesp.rc.MSCondominiumG1.entity.RentableArea;
import br.unesp.rc.MSCondominiumG1.entity.Specific;

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
     * @param newDetails An entity object containing the new data.
     */
    public static void update(Area existingArea, Area newDetails) {
        // First, update the fields that are common to all Area types.
        existingArea.setName(newDetails.getName());
        existingArea.setSizeSM(newDetails.getSizeSM());

        // Check if the area is a 'Common' area and update its specific fields.
        if (existingArea instanceof Common && newDetails instanceof Common) {
            Common existingCommon = (Common) existingArea;
            Common newCommonDetails = (Common) newDetails;
            existingCommon.setLocation(newCommonDetails.getLocation());
        }

        // Check if the area is a 'Specific' area and update its specific fields.
        if (existingArea instanceof Specific && newDetails instanceof Specific) {
            Specific existingSpecific = (Specific) existingArea;
            Specific newSpecificDetails = (Specific) newDetails;
            existingSpecific.setDescription(newSpecificDetails.getDescription());
        }

        // Check if the area is a 'RentableArea' and update its specific fields.
        // This check is nested because a RentableArea is also a Common area.
        if (existingArea instanceof RentableArea && newDetails instanceof RentableArea) {
            RentableArea existingRentable = (RentableArea) existingArea;
            RentableArea newRentableDetails = (RentableArea) newDetails;
            existingRentable.setCapacity(newRentableDetails.getCapacity());
            existingRentable.setValue(newRentableDetails.getValue());
        }
    }
}
