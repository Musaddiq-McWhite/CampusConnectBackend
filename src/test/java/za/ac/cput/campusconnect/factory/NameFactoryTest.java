package za.ac.cput.campusconnect.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.campusconnect.domain.Name;
import static org.junit.jupiter.api.Assertions.*;
public class NameFactoryTest {
    @Test
    public void testCreateName(){
        Name name = NameFactory.buildName("John", "Fred", "Doe");
        assertNotNull(name);
        System.out.println(name);
    }
    @Test
    public void testCreateNameWithFail(){
        Name name = NameFactory.buildName("", "Fred", "Doe");
        assertNull(name);
    }
}