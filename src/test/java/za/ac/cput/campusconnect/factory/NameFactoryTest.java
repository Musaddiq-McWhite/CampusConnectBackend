package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;
import static org.junit.jupiter.api.Assertions.*;
public class NameFactoryTest {
    // Test case to verify successful Name creation
    @Test
    public void testCreateName(){
        Name name = NameFactory.createName("John", "Fred", "Doe");
        assertNotNull(name);  // Assert that the created Name object is not null
        System.out.println(name);  // Print the created Name object
    }

    // Test case to verify Name creation with a failing condition
    @Test
    public void testCreateNameWithFail(){
        Name name = NameFactory.createName("", "Fred", "Doe");

        assertNotNull(name);  // Assert that the created Name object is not null
    }
}
