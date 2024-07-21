package za.ac.cput.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.campusconnect.domain.Administrator;
import za.ac.cput.campusconnect.repository.AdministratorRepository;

import java.util.List;

/**
 * FileName.java
 * Class:
 * Author:
 * Completion date:
 */
@Service
public class AdministratorService implements IAdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public Administrator create(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator read(Integer integer) {
        return administratorRepository.findById(integer).orElse(null);
    }


    @Override
    public Administrator update(Administrator administrator) {
        return administratorRepository.save(administrator);
    }


    @Override
    public List<Administrator> getAll() {
        return administratorRepository.findAll();
    }
}
