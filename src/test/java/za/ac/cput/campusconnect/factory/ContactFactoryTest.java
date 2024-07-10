package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ContactFactoryTest {

    // Test case to verify successful Contact creation
    @Test
    public void testCreateContact(){
        Contact contact = ContactFactory.createContact("1234567890", "john@example.com", "123 Main St", "", "Springfield", "12345");

        assertNotNull(contact);  // Assert that the created Contact object is not null
        System.out.println(contact);  // Print the created Contact object
    }

    // Test case to verify Contact creation with a failing condition
    @Test
    public void testCreateContactWithFail(){
        Contact contact = ContactFactory.createContact("", "john@example.com", "123 Main St", "", "Springfield", "12345");

        assertNull(contact);  // Assert that the created Contact object is null
    }
}
