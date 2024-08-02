package za.ac.cput.campusconnect.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.campusconnect.domain.Administrator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AdministratorFactoryTest {

    @Test
    public void testCreateAdministrator() {
        Administrator administrator = AdministratorFactory.buildAdministrator(1, "adminUser", "adminPass");
        assertNotNull(administrator);
        System.out.println(administrator);
    }

    @Test
    public void testCreateAdministratorWithFail() {
        Administrator administrator = AdministratorFactory.buildAdministrator(0, "", "");
        assertNull(administrator);
    }
}
