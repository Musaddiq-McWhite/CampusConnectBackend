package za.ac.cput.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import za.ac.cput.CampusConnectApp;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ContextConfiguration(classes = CampusConnectApp.class)
class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    private static Name name = NameFactory.createName("Kabo", "Bobo", "Khudunyane");
    private static Demographic demographic = DemographicFactory.createDemographic("South African","African", "Male", "1990-01-01");
    private static Contact contact = ContactFactory.createContact("0658595712", "khudunyane64@gmail.com", "18 St Marks","District 6","Cape Town", "7441");
    private static AcademicInfo academicInfo = AcademicInfoFactory.createAcademicInfo("216273293", "Computer Science", "3rd Year", "CPUT");
    private static Student student = StudentFactory.createStudent("216273293", name, demographic, contact, academicInfo, "Kabo Khudunyane", "password123");
    @Test
    void create() {
        Student createdStudent = studentService.create(student);
        assertNotNull(createdStudent);
        System.out.println("Created Student: " + createdStudent);
    }
    @Test
    void read() {
        Student readStudent = studentService.read(student.getStudentID());
        assertNotNull(readStudent);
        System.out.println("Read Student: " + readStudent);
    }
    @Test
    void update() {
        Student newStudent = new Student.Builder().copyStudent(student).setStudentID("654321").buildStudent();
        Student updatedStudent = studentService.update(newStudent);
        assertNotNull(updatedStudent);
        System.out.println("Updated Student: " + updatedStudent);
    }
//    @Test
//    void delete() {
//        studentService.delete(student.getStudentID());
//        Student deletedStudent = studentService.read(student.getStudentID());
//        assertNull(deletedStudent);
//        System.out.println("Student deleted successfully.");
//    }
//    @Test
//    void getAllStudents() {
//        List<Student> students = studentService.getAllStudents();
//        assertNotNull(students);
//        assertFalse(students.isEmpty());
//        System.out.println("All Students: " + students);
//    }
}
