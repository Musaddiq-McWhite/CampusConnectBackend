package za.ac.cput.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.campusconnect.domain.Business;

/**
 * FileName.java
 * Interface:
 * Author: Aphelele Zimkhita Joka 218130260
 * Completion date:
 */
@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    Business findBusinessByBusinessID(Long businessID);
}
