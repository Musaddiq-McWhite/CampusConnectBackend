package za.ac.cput.campusconnect.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.campusconnect.domain.Property;
import static org.junit.jupiter.api.Assertions.*;


public class PropertyFactoryTest {
    @Test
    void testBuildEmployee() {
        Property p = PropertyFactory.buildProperty(BusinessFactory.buildBusiness("Test Business","This is a business made for testing","123456780","business@gmail.com","1, Test Drive, Test Area","","Test Town","1234"), "IvyProperty", "IvyProperties", 18, 18);
        assertNotNull(p);
        System.out.println(p.toString());
    }

}
