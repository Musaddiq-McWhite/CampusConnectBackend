package za.ac.cput.campusconnect.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.campusconnect.domain.Demographic;
import static org.junit.jupiter.api.Assertions.*;
public class DemographicFactoryTest {
    @Test
    public void testCreateDemographic(){
        Demographic demographic = DemographicFactory.buildDemographic("South African","African", "Male", "14 October 1997");
        assertNotNull(demographic);
        System.out.println(demographic);
    }
    @Test
    public void testCreateDemographicWithFail(){
        Demographic demographic = DemographicFactory.buildDemographic("South African","African", "Male", "");
        assertNull(demographic);
        System.out.println(demographic);
    }
}