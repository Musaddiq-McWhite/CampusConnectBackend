package za.ac.cput.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.campusconnect.domain.Administrator;

/**
 * FileName.java
 * Interface:
 * Author:
 * Completion date:
 */
@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    Administrator findAdministratorByAdminId(int adminId);
    void deleteAdministratorByAdminId(int adminId);
}
