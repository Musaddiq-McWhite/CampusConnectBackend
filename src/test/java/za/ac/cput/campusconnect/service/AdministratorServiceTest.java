package za.ac.cput.campusconnect.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.campusconnect.domain.Administrator;
import za.ac.cput.campusconnect.factory.AdministratorFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdministratorServiceTest {

    private Administrator admin1;
    private Administrator admin2;
    private Administrator admin3;

    @Autowired
    private AdministratorService service;

    @BeforeEach
    void setUp() {
        admin1 = AdministratorFactory.buildAdministrator(1, "shirly", "password1");
        admin2 = AdministratorFactory.buildAdministrator(2, "rendani", "password2");
        admin3 = AdministratorFactory.buildAdministrator(3, "tendani", "password3");
    }

    @Test
    void create() {
        Administrator createdAdmin1 = service.create(admin1);
        assertNotNull(createdAdmin1);
        System.out.println(createdAdmin1);

        Administrator createdAdmin2 = service.create(admin2);
        assertNotNull(createdAdmin2);
        System.out.println(createdAdmin2);

        Administrator createdAdmin3 = service.create(admin3);
        assertNotNull(createdAdmin3);
        System.out.println(createdAdmin3);
    }

    @Test
    void read() {
        Administrator readAdmin1 = service.read(admin1.getAdminId());
        assertNotNull(readAdmin1);
        System.out.println(readAdmin1);
    }

    @Test
    void update() {
        Administrator updateObject = new Administrator.Builder().copy(admin2)
                .setAdminPassword("newPassword")
                .build();

        Administrator updatedAdmin = service.update(updateObject);
        assertNotNull(updatedAdmin);
        System.out.println(updatedAdmin);
    }

    @Test
    void getAll() {
        assertNotNull(service.getAll());
        service.getAll().forEach(System.out::println);
    }
}
