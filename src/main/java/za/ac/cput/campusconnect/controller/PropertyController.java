package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.campusconnect.domain.Property;
import za.ac.cput.campusconnect.service.PropertyService;

import java.util.List;

/**
 * FileName.java
 * Class:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */
@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    @PostMapping("/create")
    public Property create(@RequestBody Property property){return propertyService.create(property);}
    @GetMapping("/read/{propertyID}")
    public Property read(@PathVariable String propertyID){return propertyService.read(propertyID);}
    @PostMapping("/update")
    public Property update (@RequestBody Property property){return propertyService.update(property);}
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){propertyService.delete(id);}
    @GetMapping("/getall")
    public List<Property> getall(){return propertyService.getall();}


}

