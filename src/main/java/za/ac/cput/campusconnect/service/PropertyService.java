package za.ac.cput.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.campusconnect.domain.Property;
import za.ac.cput.campusconnect.repository.PropertyRepository;

import java.util.List;

/**
 * FileName.java
 * Class:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */
@Service
public class PropertyService {
        /*implements IPropertyService


    @Autowired
    private PropertyRepository repository;

    PropertyService(PropertyRepository repository){this.repository = repository;}

    @Override
    public Property create(Property property) {
        return repository.save(property);
    }

    @Override
    public Property read(String propertyID) {
        return this.repository.findById(propertyID).orElse(null);
    }

    @Override
    public Property update(Property property) {
        return repository.save(property);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Property> getall() {
        return repository.findAll() ;
    }

     */


}
