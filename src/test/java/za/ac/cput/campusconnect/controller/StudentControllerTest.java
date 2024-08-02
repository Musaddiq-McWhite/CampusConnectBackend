package za.ac.cput.campusconnect.controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import za.ac.cput.campusconnect.domain.*;
import za.ac.cput.campusconnect.factory.StudentFactory;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class StudentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "/students";
    private Student student;
    @BeforeEach
    void setUp() {
        student = StudentFactory.buildStudent(
                new Name.Builder().setFirstName("Kabo").setMiddleName("kb").setLastName("Khudunyane").buildName(),
                new Demographic.Builder().setNationality("South African").setRace("African").setGender("Male").setDateOfBirth("14 October 1997").buildDemographic(),
                new Contact.Builder().setPhoneNumber("0658595712").setEmail("khudnyane64@gmail.com").setAddressLine1("18 St Marks Street").setAddressLine2("District Six").setCity("Cape Town").setPostalCode("7441").buildContact(),
                new AcademicInfo.Builder().setStudentNumber("216273293").setAcademicInstitution("CPUT").setAcademicCourse("Computer Science").setAcademicYear("2023").buildAcademicInfo(),
                "Kabo Khudunyane",
                "password123"
        );
    }
    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Student> postResponse = restTemplate.postForEntity(url, student, Student.class);
        assertNotNull(postResponse);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
        Student savedStudent = postResponse.getBody();
        assertNotNull(savedStudent);
        assertEquals(student.getUsername(), savedStudent.getUsername());
        System.out.println("Saved student: " + savedStudent);
    }
    @Test
    void read() {
        String url = BASE_URL + "/read/" + student.getStudentID();
        ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class);
        assertNotNull(response.getBody());
        assertEquals(student.getStudentID(), response.getBody().getStudentID());
        System.out.println("Read student: " + response.getBody());
    }
    @Test
    void update() {
        Student updatedStudent = new Student.Builder()
                .copyStudent(student)
                .setUsername("Updated Username")
                .buildStudent();
        String url = BASE_URL + "/update";
        restTemplate.put(url, updatedStudent);
        ResponseEntity<Student> response = restTemplate.getForEntity(BASE_URL + "/read/" + student.getStudentID(), Student.class);
        assertNotNull(response.getBody());
        assertEquals("Updated Username", response.getBody().getUsername());
        System.out.println("Updated student: " + response.getBody());
    }
    @Test
    void delete() {
        String url = BASE_URL + "/delete/" + student.getStudentID();
        restTemplate.delete(url);
        ResponseEntity<Student> response = restTemplate.getForEntity(BASE_URL + "/read/" + student.getStudentID(), Student.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode()); // Expecting NOT_FOUND for deleted student
        System.out.println("Student deleted successfully.");
    }
    @Test
    void getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Student[]> response = restTemplate.getForEntity(url, Student[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("All students: " + response.getBody());
    }
}