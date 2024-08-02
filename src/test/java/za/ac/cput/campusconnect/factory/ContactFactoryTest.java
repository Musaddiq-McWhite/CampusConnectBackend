package za.ac.cput.campusconnect.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.campusconnect.domain.Contact;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
public class ContactFactoryTest {
    @Test
    public void testCreateContact(){
        Contact contact = ContactFactory.buildContact("1234567890", "john@example.com", "123 Main St", "", "Springfield", "12345");
        assertNotNull(contact);
        System.out.println(contact);
    }
    @Test
    public void testCreateContactWithFail(){
        Contact contact = ContactFactory.buildContact("", "john@example.com", "123 Main St", "", "Springfield", "12345");
        assertNull(contact);
    }
}