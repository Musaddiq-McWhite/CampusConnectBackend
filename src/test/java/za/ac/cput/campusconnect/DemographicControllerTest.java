package za.ac.cput.campusconnect.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import za.ac.cput.domain.Demographic;
import za.ac.cput.factory.DemographicFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class DemographicControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:3306/group19-capstone-project/demographics";
    private Demographic demographic = DemographicFactory.createDemographic("race", "gender");

    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Demographic> postResponse = restTemplate.postForEntity(url, demographic, Demographic.class);
        assertNotNull(postResponse);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());

        Demographic savedDemographic = postResponse.getBody();
        assertNotNull(savedDemographic);
        assertEquals(demographic.getRace(), savedDemographic.getRace());
        System.out.println("Saved demographic: " + savedDemographic);
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/" + demographic.getRace();
        ResponseEntity<Demographic> response = restTemplate.getForEntity(url, Demographic.class);
        assertNotNull(response.getBody());
        assertEquals(demographic.getRace(), response.getBody().getRace());
        System.out.println("Read demographic: " + response.getBody());
    }

    @Test
    void update() {
        Demographic updatedDemographic = new Demographic.Builder()
                .copy(demographic)
                .setGender("Updated Gender")
                .build();

        String url = BASE_URL + "/update";
        restTemplate.put(url, updatedDemographic);

        ResponseEntity<Demographic> response = restTemplate.getForEntity(BASE_URL + "/read/" + demographic.getRace(), Demographic.class);
        assertNotNull(response.getBody());
        assertEquals("Updated Gender", response.getBody().getGender());
        System.out.println("Updated demographic: " + response.getBody());
    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete/" + demographic.getRace();
        restTemplate.delete(url);

        ResponseEntity<Demographic> response = restTemplate.getForEntity(BASE_URL + "/read/" + demographic.getRace(), Demographic.class);
        assertNull(response.getBody());
        System.out.println("Demographic deleted successfully.");
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Demographic[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Demographic[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        for (Demographic d : response.getBody()) {
            System.out.println(d);
        }
    }
}
