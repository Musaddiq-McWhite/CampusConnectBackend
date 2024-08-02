package za.ac.cput.campusconnect.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.campusconnect.domain.*;
import static org.junit.jupiter.api.Assertions.*;
public class StudentFactoryTest {
    Name name = NameFactory.buildName("Kabo", "kb", "Khudunyane");
    Demographic demographic = DemographicFactory.buildDemographic("South African", "African", "Male", "14 October 1997");
    Contact contact = ContactFactory.buildContact("0658595712", "khudnyane64@gmail.com", "18 St Marks Street", "District Six", "Cape Town", "7441");
    AcademicInfo academicInfo = AcademicInfoFactory.buildAcademicInfo("216273293", "Computer Science", "2023", "CPUT");
    @Test
    public void testCreateStudent() {
        Student student = StudentFactory.buildStudent(name, demographic, contact, academicInfo, "Kabo Khudunyane", "password123");
        assertNotNull(student);
        System.out.println(student);
    }
    @Test
    public void testCreateStudentWithFail() {
        Student student = StudentFactory.buildStudent(name, demographic, contact, academicInfo, "", "password123");
        assertNull(student);
        System.out.println(student);
    }
}