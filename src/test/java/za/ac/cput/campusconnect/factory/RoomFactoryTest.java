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

        Property property = PropertyFactory.buildProperty(654321L, "Aphelele", "IvyProperty", "IvyProperties", 18, 18);
        Room room = RoomFactory.buildRoom(123L,property,69,true);
        assertNotNull(room);
        System.out.println(room);
    }
}