package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Student;
import za.ac.cput.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/read/{studentID}")
    public Student read(@PathVariable String studentID) {
        return studentService.read(studentID);
    }

    @PutMapping("/update")
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{studentID}")
    public void delete(@PathVariable String studentID) {
        studentService.delete(studentID);
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }
}
