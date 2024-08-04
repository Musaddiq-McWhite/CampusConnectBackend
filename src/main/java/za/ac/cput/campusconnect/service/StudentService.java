/**
 * FileName StudentService.java
 * Class: StudentService
 * Author: Kabo Khudunyane
 * Completion date: 11 July 2024
 */
package za.ac.cput.campusconnect.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.campusconnect.domain.Student;
import za.ac.cput.campusconnect.repository.StudentRepository;
import java.util.List;
@Service
public class StudentService implements IService<Student, Long> {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Student read(Long studentID) {
        return studentRepository.findByStudentID(studentID);
    }
    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }
    public void delete(Long studentID) {
        studentRepository.deleteByStudentID(studentID);
    }
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
