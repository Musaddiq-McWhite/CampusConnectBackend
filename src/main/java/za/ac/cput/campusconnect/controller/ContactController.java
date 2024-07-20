package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.ContactService;

import java.util.List;

/**
 * FileName ContactController.java
 * Class: ContactController
 * Author: [Your Name]
 * Completion date: [Today's Date]
 */
/
@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/create")
    public ResponseEntity<Contact> create(@RequestBody Contact contact) {
        Contact newContact = contactService.create(contact);
        return ResponseEntity.ok(newContact);
    }

    @GetMapping("/read/{phoneNumber}")
    public ResponseEntity<Contact> read(@PathVariable String phoneNumber) {
        Contact contact = contactService.read(phoneNumber);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Contact> update(@RequestBody Contact contact) {
        Contact updatedContact = contactService.update(contact);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/delete/{phoneNumber}")
    public ResponseEntity<Void> delete(@PathVariable String phoneNumber) {
        contactService.delete(phoneNumber);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }
}

