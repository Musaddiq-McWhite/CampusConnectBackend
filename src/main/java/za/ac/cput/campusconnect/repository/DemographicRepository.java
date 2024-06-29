package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Demographic;

import java.util.List;

@Repository
public interface DemographicRepository extends JpaRepository<Demographic, String> {
    Demographic findByRace(String race);
    void deleteByRace(String race);
    List<Demographic> findAllDemogaphics();
}
