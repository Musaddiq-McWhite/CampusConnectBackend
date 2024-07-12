package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Demographic;
import za.ac.cput.factory.DemographicFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemographicServiceTest {

    @Autowired
    private DemographicService demographicService;

    private static Demographic demographic = DemographicFactory.createDemographic("South African","African", "Male", "14 October 1997");

    @Test
    void create() {
        Demographic createdDemographic = demographicService.create(demographic);
        assertNotNull(createdDemographic);
        System.out.println("Created Demographic: " + createdDemographic);
    }

    @Test
    void read() {
        Demographic readDemographic = demographicService.read(demographic.getGender());
        assertNotNull(readDemographic);
        System.out.println("Read Demographic: " + readDemographic);
    }

    @Test
    void update() {
        Demographic newDemographic = new Demographic.Builder().copyDemographic(demographic).setGender("Female").buildDemographic();
        Demographic updatedDemographic = demographicService.update(newDemographic);
        assertNotNull(updatedDemographic);
        System.out.println("Updated Demographic: " + updatedDemographic);
    }

    @Test
    void delete() {
        demographicService.delete(demographic.getGender());
        Demographic deletedDemographic = demographicService.read(demographic.getGender());
        assertNull(deletedDemographic);
        System.out.println("Demographic deleted successfully.");
    }

    @Test
    void getAllDemographics() {
        List<Demographic> demographics = demographicService.getAllDemographics();
        assertNotNull(demographics);
        assertFalse(demographics.isEmpty());
        System.out.println("All Demographics: " + demographics);
    }
}
