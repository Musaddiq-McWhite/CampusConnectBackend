package za.ac.cput.campusconnect.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.campusconnect.domain.Administrator;
import za.ac.cput.campusconnect.factory.AdministratorFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdministratorServiceTest {

    @Autowired
    private AdministratorService administratorService;

    private static Administrator admin1, admin2;

    @BeforeAll
    static void setUp() {
        admin1 = AdministratorFactory.buildAdministrator(1, "adminUser1", "adminPass1");
        admin2 = AdministratorFactory.buildAdministrator(2, "adminUser2", "adminPass2");

        assertNotNull(admin1);
        assertNotNull(admin2);

        System.out.println("Setup complete:");
        System.out.println("Admin1: " + admin1);
        System.out.println("Admin2: " + admin2);
    }

    @Test
    @Order(1)
    void save() {
        Administrator saved1 = administratorService.create(admin1);
        assertNotNull(saved1);
        System.out.println("Saved Admin1: " + saved1);

        Administrator saved2 = administratorService.create(admin2);
        assertNotNull(saved2);
        System.out.println("Saved Admin2: " + saved2);
    }

    @Test
    @Order(2)
    void read() {
        Administrator read = administratorService.read(admin1.getAdminId());
        assertNotNull(read);
        System.out.println("Read Admin1: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Administrator updatedAdmin = new Administrator.Builder()
                .copy(admin1)
                .setAdminUsername("updatedUser")
                .build();

        Administrator updated = administratorService.update(updatedAdmin);
        assertNotNull(updated);
        System.out.println("Updated Admin1: " + updated);
        assertEquals("updatedUser", updated.getAdminUsername());
    }

    @Test
    @Order(4)
    void deleteByID() {
        administratorService.delete(admin2.getAdminId());
        System.out.println("Admin2 deleted successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("All Administrators: ");
        System.out.println(administratorService.getAll());
    }
}
