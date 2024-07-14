package za.ac.cput.campusconnect.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Demographic;
import za.ac.cput.repository.DemographicRepository;

import java.util.List;

@Service
public class DemographicService implements IService<Demographic, String> {
    private final DemographicRepository demographicRepository;

    @Autowired
    public DemographicService(DemographicRepository demographicRepository) {
        this.demographicRepository = demographicRepository;
    }

    @Override
    public Demographic create(Demographic demographic) {
        return demographicRepository.save(demographic);
    }

    @Override
    public Demographic read(String race) {
        return demographicRepository.findByRace(race);
    }

    @Override
    public Demographic update(Demographic demographic) {
        return demographicRepository.save(demographic);
    }

    public void delete(String race) {
        demographicRepository.deleteByRace(race);
    }

    public List<Demographic> getAllDemographics() {
        return demographicRepository.findAll();
    }
}
