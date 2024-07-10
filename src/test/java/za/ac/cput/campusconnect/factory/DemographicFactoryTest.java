package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Demographic;
import static org.junit.jupiter.api.Assertions.*;
public class DemographicFactoryTest {
    // Test case to verify successful Demographic creation
    @Test
    public void testCreateDemographic(){
        Demographic demographic = DemographicFactory.createDemographic("South African","African", "Male", "14 October 1997");
        assertNotNull(demographic);  // Assert that the created Demographic object is not null
        System.out.println(demographic);  // Print the created Demographic object
    }
    // Test case to verify Demographic creation with a failing condition
    @Test
    public void testCreateDemographicWithFail(){
        Demographic demographic = DemographicFactory.createDemographic("South African","African", "Male", "");
        assertNotNull(demographic);  // Assert that the created Demographic object is not null
        System.out.println(demographic);
    }
}