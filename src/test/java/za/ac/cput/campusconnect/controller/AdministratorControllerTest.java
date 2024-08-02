package za.ac.cput.campusconnect.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.campusconnect.domain.Administrator;
import za.ac.cput.campusconnect.factory.AdministratorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdministratorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/administrator";
    private static Administrator administrator;

    @BeforeAll
    public static void setup() {
        administrator = new Administrator.Builder()
                .setAdminId(1)
                .setAdminUsername("adminUser")
                .setAdminPassword("adminPass")
                .build();
    }

    @Test
    void a_create() {
        String URL = BASE_URL + "/create";
        ResponseEntity<Administrator> postResponse = restTemplate.postForEntity(URL, administrator, Administrator.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Administrator adminSaved = postResponse.getBody();
        assertEquals(administrator.getAdminId(), adminSaved.getAdminId());
        System.out.println("Created Administrator: " + adminSaved);
    }

    @Test
    void b_read() {
        String URL = BASE_URL + "/read/" + administrator.getAdminId();
        ResponseEntity<Administrator> response = restTemplate.getForEntity(URL, Administrator.class);
        assertNotNull(response.getBody());
        System.out.println("Read Administrator: " + response.getBody());
        assertEquals(administrator.getAdminId(), response.getBody().getAdminId());
    }

    @Test
    void c_update() {
        String URL = BASE_URL + "/update";
        Administrator newAdmin = new Administrator.Builder().copy(administrator).setAdminUsername("updatedUser").build();
        ResponseEntity<Administrator> postResponse = restTemplate.postForEntity(URL, newAdmin, Administrator.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Administrator adminUpdated = postResponse.getBody();
        System.out.println("Updated Administrator: " + adminUpdated);
        assertEquals(newAdmin.getAdminId(), adminUpdated.getAdminId());
    }

    @Disabled
    @Test
    void d_delete() {
        String URL = BASE_URL + "/delete/" + administrator.getAdminId();
        restTemplate.delete(URL);
        System.out.println("Success: Deleted administrator");
    }

    @Test
    void e_getAll() {
        String URL = BASE_URL + "/getAll";
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
