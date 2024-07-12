package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.NameFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NameServiceTest {

    @Autowired
    private NameService nameService;

    private static Name name = NameFactory.createName("Kabo", "Bobo", "Khudunyane");

    @Test
    void create() {
        Name createdName = nameService.create(name);
        assertNotNull(createdName);
        System.out.println("Created Name: " + createdName);
    }

    @Test
    void read() {
        Name readName = nameService.read(name.getFirstName());
        assertNotNull(readName);
        System.out.println("Read Name: " + readName);
    }

    @Test
    void update() {
        Name newName = new Name.Builder().copyName(name).setFirstName("Jane").buildName();
        Name updatedName = nameService.update(newName);
        assertNotNull(updatedName);
        System.out.println("Updated Name: " + updatedName);
    }

    @Test
    void delete() {
        nameService.delete(name.getFirstName());
        Name deletedName = nameService.read(name.getFirstName());
        assertNull(deletedName);
        System.out.println("Name deleted successfully.");
    }

    @Test
    void getAllnames() {
        List<Name> names = nameService.getAllNames();
        assertNotNull(names);
        assertFalse(names.isEmpty());
        System.out.println("All Names: " + names);
    }
}
