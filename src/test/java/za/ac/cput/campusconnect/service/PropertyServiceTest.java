package za.ac.cput.campusconnect.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.campusconnect.domain.Property;
import za.ac.cput.campusconnect.factory.PropertyFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class PropertyServiceTest {
    @Autowired
    private PropertyService propertyService;
    private static Property property1;
    private static Property property2;

    @Test
     void a_setup(){
        property1 = PropertyFactory.buildProperty(2181L, "Aphelele", "IvyProperty", "IvyProperties", 18, 18);
        assertNotNull(property1);
        System.out.println(property1);

        property2 = PropertyFactory.buildProperty(181L, "Joka", "JayProperty", "36 Cape Cape", 20, 20);
        assertNotNull(property2);
        System.out.println(property2);
    }
    @Test
    void b_create(){
        Property created1 = propertyService.create(property1);
        assertNotNull(created1);
        System.out.println(created1);

        Property created2 = propertyService.create(property2);
        assertNotNull(created2);
        System.out.println(created2);
    }
    @Test
    void c_read(){
        Property read = propertyService.read(property1.getPropertyID());
        assertNotNull(read);
        System.out.println(read);

    }
    @Test
    void d_update(){
        Property newProperty = new Property.Builder().copy(property2).setPropertyOwner("Aphelele Zimmy").build();
        Property updated= propertyService.update(newProperty);
        assertNotNull(updated);
        System.out.println(updated);
    }
    @Test
    void e_getall(){
        System.out.println(propertyService.getAll());
    }
}
