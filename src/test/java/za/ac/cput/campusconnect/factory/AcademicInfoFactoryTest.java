package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.AcademicInfo;
import za.ac.cput.factory.AcademicInfoFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AcademicInfoFactoryTest {

    // Test case to verify successful AcademicInfo creation
    @Test
    public void testCreateAcademicInfo(){
        AcademicInfo academicInfo = AcademicInfoFactory.createAcademicInfo("216273293", "Computer Science", "2023", "CPUT");

        assertNotNull(academicInfo);  // Assert that the created AcademicInfo object is not null
        System.out.println(academicInfo);  // Print the created AcademicInfo object
    }

    // Test case to verify AcademicInfo creation with a failing condition
    @Test
    public void testCreateAcademicInfoWithFail(){
        AcademicInfo academicInfo = AcademicInfoFactory.createAcademicInfo("", "Computer Science", "2023", "CPUT");

        assertNull(academicInfo);  // Assert that the created AcademicInfo object is null
    }
}
