package za.ac.cput.campusconnect.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactRepository;
import java.util.List;

/**
 * FileName ContactService.java
 * Class: ContactService
 * Author: Kabo Khudunyane
 * Completion date: 11 July 2024
 */

@Service
public class ContactService implements IService<Contact, String> {
    private final ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }
    @Override
    public Contact read(String phoneNumber) {
        return contactRepository.findByPhoneNumber(phoneNumber);
    }
    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }
    public void delete(String phoneNumber) {
        contactRepository.deleteByPhoneNumber(phoneNumber);
    }
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
