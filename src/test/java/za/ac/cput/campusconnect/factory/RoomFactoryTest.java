package za.ac.cput.campusconnect.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.campusconnect.domain.Property;
import za.ac.cput.campusconnect.domain.Room;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoomFactoryTest {
    @Test
    @Order(1)
    void testBuildTheatre(){

        Property property = PropertyFactory.buildProperty( BusinessFactory.buildBusiness("Test Business","This is a business made for testing","123456780","business@gmail.com","1, Test Drive, Test Area","","Test Town","1234"), "IvyProperty", "IvyProperties", 18, 18);
        Room room = RoomFactory.buildRoom(property,69,true);
        assertNotNull(room);
        System.out.println(room);
    }
}