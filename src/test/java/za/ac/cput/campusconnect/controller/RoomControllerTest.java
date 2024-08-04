package za.ac.cput.campusconnect.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.campusconnect.domain.*;
import za.ac.cput.campusconnect.factory.RoomFactory;
import za.ac.cput.campusconnect.factory.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoomControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "/room";
    private Room room;

    @BeforeEach
    void setUp() {
        room = RoomFactory.buildRoom(123456L, new Property.Builder().setPropertyID(7864168L).setPropertyOwner("Aphelele").setPropertyName("IvyProperty").setPropertyAddress("IvyProperties").setMaleRoom(18).setFemaleRoom(18).build(), 69, true);
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, room, Room.class);
        assertNotNull(postResponse);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
        Room savedRoom = postResponse.getBody();
        assertNotNull(savedRoom);
        assertEquals(room.getRoomID(),savedRoom.getRoomID());
        System.out.println("Saved Room: " + savedRoom);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + room.getRoomID();
        ResponseEntity<Room> response = restTemplate.getForEntity(url, Room.class);
        assertNotNull(response.getBody());
        assertEquals(room.getRoomID(),response.getBody().getRoomID());
        System.out.println("Read room: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        Room updatedRoom = new Room.Builder()
                .copy(room)
                .setRoomNumber(420)
                .build();
        String url = BASE_URL + "/update";
        restTemplate.put(url, updatedRoom);
        ResponseEntity<Room> response = restTemplate.getForEntity(BASE_URL + "/read/" + room.getRoomID(), Room.class);
        assertNotNull(response.getBody());
        assertEquals(420, response.getBody().getRoomNumber());
        System.out.println("Updated room: " + response.getBody());
    }
    /*
    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + room.getRoomID();
        restTemplate.delete(url);
        ResponseEntity<Room> response = restTemplate.getForEntity(BASE_URL + "/read/" + room.getRoomID(), Room.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Room deleted successfully.");
    }
    */
    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Room[]> response = restTemplate.getForEntity(url, Room[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("All rooms: " + Arrays.toString(response.getBody()));
    }
}
