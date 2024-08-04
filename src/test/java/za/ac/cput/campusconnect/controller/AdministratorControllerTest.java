package za.ac.cput.campusconnect.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.campusconnect.factory.AdministratorFactory;
import za.ac.cput.campusconnect.domain.Administrator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdministratorControllerTest {
    private final String BASE_URL = "http://localhost:8080/CampusConnectBackend/administrator";
    private static Administrator admin1;
    private static Administrator admin2;

    @Autowired
    private TestRestTemplate restTemplate;

    Administrator responsebody;
    Administrator responsebody2;

    @BeforeAll
    static void a_setUp() {
        admin1 = AdministratorFactory.buildAdministrator(1, "shirly", "password1");
        System.out.println(admin1);

        admin2 = AdministratorFactory.buildAdministrator(2, "rendani", "password2");
        System.out.println(admin2);
    }

    @Test
    @Order(1)
    void b_create() {
        String createURL = BASE_URL + "/create";
        System.out.println(createURL);

        ResponseEntity<Administrator> response = restTemplate.postForEntity(createURL, admin1, Administrator.class);
        assertNotNull(response);
        System.out.println("Response: " + response);

        responsebody = response.getBody();
        assertNotNull(responsebody);
        System.out.println("Object Returned by JPa after posting admin1: " + responsebody);

        ResponseEntity<Administrator> response2 = restTemplate.postForEntity(createURL, admin2, Administrator.class);
        assertNotNull(response2);

        responsebody2 = response2.getBody();
        assertNotNull(responsebody2);
    }

    @Test
    @Order(2)
    void b_read() {
        String readURL = BASE_URL + "/read/" + responsebody.getAdminId();
        System.out.println("URL: " + readURL);

        ResponseEntity<Administrator> response = restTemplate.getForEntity(readURL, Administrator.class);
        assertNotNull(response);

        Administrator readAdministrator = response.getBody();
        assertEquals(readAdministrator.getAdminId(), responsebody.getAdminId());
        System.out.println("Read Administrator: " + readAdministrator);
    }

    @Test
    @Order(3)
    void d_update() {
        String updateURL = BASE_URL + "/update";
        System.out.println(updateURL);

        Administrator updatedAdmin = new Administrator.Builder().copy(responsebody2)
                .setAdminPassword("newPassword")
                .build();

        ResponseEntity<Administrator> response = restTemplate.postForEntity(updateURL, updatedAdmin, Administrator.class);
        assertNotNull(response);
        assertNotNull(response.getBody());

        Administrator newAdmin = response.getBody();
        assertEquals(newAdmin.getAdminId(), responsebody2.getAdminId());
        System.out.println("Updated Administrator: " + newAdmin);
    }

    @Test
    @Order(4)
    void e_getAll() {
        String getAllURL = BASE_URL + "/getAll";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getAllURL, HttpMethod.GET, entity, String.class);

        System.out.println("All Administrators: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
