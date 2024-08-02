package za.ac.cput.campusconnect.factory;

import za.ac.cput.campusconnect.domain.Business;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BusinessFactoryTest {
    @Test
    void testBuildEmployee() {
        Business b = BusinessFactory.buildBusiness(30260L, "IvyProperties", "student accomodation", "0218130260", "apelelejoka@gmail.com", "13 Ntlazane Street", "Khayelitsha","Cape Town","7784");
        assertNotNull(b);
        System.out.println(b.toString());
    }
}
