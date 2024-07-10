package za.ac.cput.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Name;

import java.util.List;

@Repository
public interface NameRepository extends JpaRepository<Name, String> {
    Name findByFirstName(String firstName);
    void deleteByFirstName(String firstName);
    List<Name> findAll();
}
