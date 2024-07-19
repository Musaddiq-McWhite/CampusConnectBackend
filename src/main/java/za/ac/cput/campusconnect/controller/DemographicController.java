package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Demographic;
import za.ac.cput.service.DemographicService;

import java.util.List;

@RestController
@RequestMapping("/demographics")
public class DemographicController {

    @Autowired
    private DemographicService demographicService;

    @PostMapping("/create")
    public Demographic create(@RequestBody Demographic demographic) {
        return demographicService.create(demographic);
    }

    @GetMapping("/read/{race}")
    public Demographic read(@PathVariable String race) {
        return demographicService.read(race);
    }

    @PutMapping("/update")
    public Demographic update(@RequestBody Demographic demographic) {
        return demographicService.update(demographic);
    }

    @DeleteMapping("/delete/{race}")
    public void delete(@PathVariable String race) {
        demographicService.delete(race);
    }

    @GetMapping("/getAll")
    public List<Demographic> getAll() {
        return demographicService.getAllDemographics();
    }
}
