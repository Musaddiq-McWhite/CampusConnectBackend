package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ContactServiceTest {
    @Autowired
    private ContactService contactService;
    private static Contact contact = ContactFactory.createContact("1", "john.doe@example.com", "18 St Marks", "District 6", "Cape town", "7441");
    @Test
    void create() {
        Contact createdContact = contactService.create(contact);
        assertNotNull(createdContact);
        System.out.println("Created Contact: " + createdContact);
    }
    @Test
    void read() {
        Contact readContact = contactService.read(contact.getPhoneNumber());
        assertNotNull(readContact);
        System.out.println("Read Contact: " + readContact);
    }
    @Test
    void update() {
        Contact newContact = new Contact.Builder().copyContact(contact).setEmail("jane.doe@example.com").buildContact();
        Contact updatedContact = contactService.update(newContact);
        assertNotNull(updatedContact);
        System.out.println("Updated Contact: " + updatedContact);
    }
    @Test
    void delete() {
        contactService.delete(contact.getPhoneNumber());
        Contact deletedContact = contactService.read(contact.getPhoneNumber());
        assertNull(deletedContact);
        System.out.println("Contact deleted successfully.");
    }
    @Test
    void getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        assertNotNull(contacts);
        assertFalse(contacts.isEmpty());
        System.out.println("All Contacts: " + contacts);
    }
}
