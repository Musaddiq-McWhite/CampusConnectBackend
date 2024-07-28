package za.ac.cput.campusconnect.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class StudentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:3306/group19-capstone-project/students";
    private Student student = StudentFactory.createStudent("studentID", "firstName", "lastName", "email", "phoneNumber");

    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Student> postResponse = restTemplate.postForEntity(url, student, Student.class);
        assertNotNull(postResponse);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());

        Student savedStudent = postResponse.getBody();
        assertNotNull(savedStudent);
        assertEquals(student.getStudentID(), savedStudent.getStudentID());
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
                .copy(student)
                .setLastName("Updated LastName")
                .build();

        String url = BASE_URL + "/update";
        restTemplate.put(url, updatedStudent);

        ResponseEntity<Student> response = restTemplate.getForEntity(BASE_URL + "/read/" + student.getStudentID(), Student.class);
        assertNotNull(response.getBody());
        assertEquals("Updated LastName", response.getBody().getLastName());
        System.out.println("Updated student: " + response.getBody());
    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete/" + student.getStudentID();
        restTemplate.delete(url);

        ResponseEntity<Student> response = restTemplate.getForEntity(BASE_URL + "/read/" + student.getStudentID(), Student.class);
        assertNull(response.getBody());
        System.out.println("Student deleted successfully.");
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity
