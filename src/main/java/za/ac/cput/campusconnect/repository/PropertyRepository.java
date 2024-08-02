package za.ac.cput.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.campusconnect.domain.Property;

/**
 * FileName.java
 * Interface:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long > {
    Property findPropertyByPropertyID(Long propertyID);
    Property findPropertyByPropertyOwnerIgnoreCase(String propertyOwner);
    Property findPropertyByPropertyAddress(String propertyAddress);
}