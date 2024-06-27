package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.campusconnect.domain.Business;
import za.ac.cput.campusconnect.service.BusinessService;

import java.util.List;

/**
 * FileName.java
 * Class:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */

@RestController
@RequestMapping("/business")
public class BusinessController {
    /*
    @Autowired
    private BusinessService businessService;
    @PostMapping("/create")
    public Business create(@RequestBody Business business){return businessService.create(business);}
    @GetMapping("/read/{businessID}")
    public Business read(@PathVariable String businessID){return businessService.read(businessID);}
    @PostMapping("/update")
    public Business update (@RequestBody Business business){return businessService.update(business);}
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){businessService.delete(id);}
    @GetMapping("/getall")
    public List<Business> getall(){return businessService.getall();}

     */
}
