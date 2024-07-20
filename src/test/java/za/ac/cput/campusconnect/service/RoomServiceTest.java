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
        contact = ContactFactory.createContact("12345678","test@email.com","1 test road","Test area","Test Town","80085");
        business = BusinessFactory.buildBusiness("123","Test Business","Business made for testing purposes",contact.getPhoneNumber(),contact.getEmail(),contact.getAddressLine1(),contact.getAddressLine2(),contact.getCity(),contact.getPostalCode());
        property = PropertyFactory.buildProperty("123", business.getBusinessName(),"Test Residency", contact.getAddressLine1() + ", " + contact.getAddressLine2() + ", " + contact.getCity(),15,15);
        room1 = RoomFactory.buildRoom("123",property,1,false);
        assertNotNull(room1);
        System.out.println(room1);
        room2 = RoomFactory.buildRoom("321",property,2,false);
        assertNotNull(room2);
        System.out.println(room2);
    }

    @Test
    @Order(2)
    void save() {
        Room saved1 = roomService.save(room1);
        assertNotNull(saved1);
        System.out.println(saved1);
        Room saved2 = roomService.save(room2);
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
        roomService.deleteByID(room2.getRoomID());
        System.out.println("Room 2 deleted successfully");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(roomService.getAll());
    }
}