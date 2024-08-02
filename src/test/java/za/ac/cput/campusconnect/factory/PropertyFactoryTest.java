package za.ac.cput.campusconnect.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.campusconnect.domain.Property;
import static org.junit.jupiter.api.Assertions.*;


public class PropertyFactoryTest {
    @Test
    void testBuildEmployee() {
        Property p = PropertyFactory.buildProperty(123456L, "Aphelele", "IvyProperty", "IvyProperties", 18, 18);
        assertNotNull(p);
        System.out.println(p.toString());
    }

}
