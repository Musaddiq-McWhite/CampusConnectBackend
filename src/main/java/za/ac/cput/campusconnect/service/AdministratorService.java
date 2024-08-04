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
public class AdministratorService implements IService<Administrator, Integer> {
    private AdministratorRepository repository;
    @Autowired
    AdministratorService(AdministratorRepository repository){this.repository = repository;}
    @Override
    public Administrator create(Administrator administrator) {
        return repository.save(administrator);
    }

    @Override
    public Administrator read(Integer administratorID) {
        return repository.findAdministratorByAdminId(administratorID);
    }

    @Override
    public Administrator update(Administrator administrator) {
        return repository.save(administrator);
    }

    @Override
    public void delete(Integer administratorID) {
        repository.deleteById(administratorID);
    }

    @Override
    public List<Administrator> getAll() {
        return repository.findAll();
    }
}