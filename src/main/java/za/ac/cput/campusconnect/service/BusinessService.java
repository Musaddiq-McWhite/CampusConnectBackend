package za.ac.cput.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.campusconnect.domain.Business;
import za.ac.cput.campusconnect.repository.BusinessRepository;

import java.util.List;

/**
 * FileName.java
 * Class:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */
@Service
public class BusinessService implements IBusinessService{


    @Autowired
    private BusinessRepository repository;
    BusinessService(BusinessRepository repository){this.repository = repository;}
@Override
    public Business create(Business business){return repository.save(business);}

    @Override
    public Business read(String businessID) {return this.repository.findById(businessID).orElse(null);}

    @Override
    public Business update(Business business) {return repository.save(business);}

    @Override
    public void delete(String id) {repository.deleteById(id);}

    @Override
    public List<Business> getall() {return repository.findAll();}



}
