package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Demographic;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.AcademicInfo;
import za.ac.cput.factory.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
public class StudentFactoryTest {
    // Create a Name object for testing
    Name name = NameFactory.createName("Kabo", "Bobo", "Khudunyane");
    // Create a Demographic object for testing
    Demographic demographic = DemographicFactory.createDemographic("South African","African","Male","14 October 1997");
    // Create a Contact object for testing
    Contact contact = ContactFactory.createContact("0658595712", "khudnyane64@gmail.com", "18 St Marks Street", "District Six", "Cape town", "7441");
    // Create an AcademicInfo object for testing
    AcademicInfo academicInfo = AcademicInfoFactory.createAcademicInfo("216273293", "Computer Science", "2023", "CPUT");
    // Test case to verify successful Student creation
    @Test
    public void testCreateStudent(){
        Student student = StudentFactory.createStudent("0001", name, demographic, contact, academicInfo, "Kabo Khudunyane", "password123");
        assertNotNull(student);  // Assert that the created Student object is not null
        System.out.println(student);  // Print the created Student object
    }
    // Test case to verify Student creation with a failing condition
    @Test
    public void testCreateStudentWithFail(){
        Student student = StudentFactory.createStudent("0001", name, demographic, contact, academicInfo, "", "password123");
        assertNull(student);  // Assert that the created Student object has null
    }
}