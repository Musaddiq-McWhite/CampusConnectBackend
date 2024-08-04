package za.ac.cput.campusconnect.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.campusconnect.domain.Business;
import za.ac.cput.campusconnect.domain.Contact;
import za.ac.cput.campusconnect.domain.Property;
import za.ac.cput.campusconnect.domain.Room;
import za.ac.cput.campusconnect.factory.BusinessFactory;
import za.ac.cput.campusconnect.factory.ContactFactory;
import za.ac.cput.campusconnect.factory.PropertyFactory;
import za.ac.cput.campusconnect.factory.RoomFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoomServiceTest {
    @Autowired
    private RoomService roomService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private BusinessService businessService;

    private static Room room1,room2;
    private static Property property;
    private static Business business;
    private static Contact contact;

    @Test
    @Order(1)
    void setUp() {
        contact = ContactFactory.buildContact("1234567890", "john@example.com", "123 Main St", "", "Springfield", "12345");
        business = BusinessFactory.buildBusiness(30260L, "IvyProperties", "student accomodation", "0218130260", "apelelejoka@gmail.com", "13 Ntlazane Street", "Khayelitsha","Cape Town","7784");
        property = PropertyFactory.buildProperty(2181L, "Aphelele", "IvyProperty", "IvyProperties", 18, 18);
        room1 = RoomFactory.buildRoom(123L,property,1,false);
        assertNotNull(room1);
        System.out.println(room1);
        room2 = RoomFactory.buildRoom(321L,property,2,false);
        assertNotNull(room2);
        System.out.println(room2);
    }

    @Test
    @Order(2)
    void save() {
        Property created1 = propertyService.create(property);
        assertNotNull(created1);
        System.out.println(created1);
        Room saved1 = roomService.create(room1);
        assertNotNull(saved1);
        System.out.println(saved1);
        Room saved2 = roomService.create(room2);
        assertNotNull(saved2);
        System.out.println(saved2);
    }

    @Test
    @Order(3)
    void read() {
        Room read = roomService.read(room1.getRoomID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(5)
    void deleteByID() {
        roomService.delete(room2.getRoomID());
        System.out.println("Room 2 deleted successfully");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(roomService.getAll());
    }
}