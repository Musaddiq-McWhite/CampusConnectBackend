package za.ac.cput.campusconnect.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Contact;

import java.util.List;
/**
 * FileName ContactRepository.java
 * Interface: ContactRepository
 * Author: Kabo Khudunyane
 * Completion date: 10 July 2024
 */

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
    Contact findByPhoneNumber(String phoneNumber);
    void deleteByPhoneNumber(String phoneNumber);
    List<Contact> findAll();
}
