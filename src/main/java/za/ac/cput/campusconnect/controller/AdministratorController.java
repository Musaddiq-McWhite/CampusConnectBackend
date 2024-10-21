package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.campusconnect.domain.Administrator;
import za.ac.cput.campusconnect.service.AdministratorService;

import java.util.List;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Administrator administrator) {
        Administrator created = administratorService.create(administrator);
        if (created == null) {
            return ResponseEntity.badRequest().body("Error creating Administrator");
        }
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/read/{administratorID}")
    public ResponseEntity<?> read(@PathVariable int administratorID) {
        Administrator read = administratorService.read(administratorID);
        if (read == null) {
            return ResponseEntity.badRequest().body("Admin with Admin ID: " + administratorID + " does not exist");
        }
        return ResponseEntity.ok(read);
    }

    @GetMapping("/getAll")  // Change this to GetMapping to allow GET requests
    public List<Administrator> getAll() {
        return administratorService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Administrator administrator) {
        Administrator updatedAdministrator = administratorService.create(administrator);
        if (updatedAdministrator == null) {
            return ResponseEntity.badRequest().body("Error updating administrator");
        }
        return ResponseEntity.ok(updatedAdministrator);
    }
}
//