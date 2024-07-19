package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Demographic;
import za.ac.cput.service.DemographicService;

import java.util.List;

@RestController
@RequestMapping("/demographics")
public class DemographicController {

    private final DemographicService demographicService;

    @Autowired
    public DemographicController(DemographicService demographicService) {
        this.demographicService = demographicService;
    }

    @PostMapping("/create")
    public ResponseEntity<Demographic> createDemographic(@RequestBody Demographic demographic) {
        Demographic createdDemographic = demographicService.create(demographic);
        return new ResponseEntity<>(createdDemographic, HttpStatus.CREATED);
    }

    @GetMapping("/read/{race}")
    public ResponseEntity<Demographic> getDemographic(@PathVariable String race) {
        Demographic demographic = demographicService.read(race);
        if (demographic != null) {
            return new ResponseEntity<>(demographic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Demographic> updateDemographic(@RequestBody Demographic demographic) {
        Demographic updatedDemographic = demographicService.update(demographic);
        return new ResponseEntity<>(updatedDemographic, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{race}")
    public ResponseEntity<Void> deleteDemographic(@PathVariable String race) {
        demographicService.delete(race);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Demographic>> getAllDemographics() {
        List<Demographic> demographicList = demographicService.getAllDemographics();
        return new ResponseEntity<>(demographicList, HttpStatus.OK);
    }
}
