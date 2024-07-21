package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.campusconnect.domain.Administrator;
import za.ac.cput.campusconnect.service.AdministratorService;

import java.util.List;

/**
 * FileName.java
 * Class:
 * Author:
 * Completion date:
 */
@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/create")
    public Administrator create(@RequestBody Administrator administrator) {
        return administratorService.create(administrator);
    }

    @GetMapping("/read/{adminId}")
    public Administrator read(@PathVariable int adminId) {
        return administratorService.read(adminId);
    }

    @PostMapping("/update")
    public Administrator update(@RequestBody Administrator administrator) {
        return administratorService.update(administrator);
    }

    @GetMapping("/getAll")
    public List<Administrator> getAll() {
        return administratorService.getAll();
    }}