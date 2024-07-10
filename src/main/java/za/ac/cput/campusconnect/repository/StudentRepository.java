package za.ac.cput.campusconnect.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Student;

import java.util.List;
/**
 * FileName StudentRepository.java
 * Interface: StudentRepository
 * Author: Kabo Khudunyane
 * Completion date: 10 July 2024
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByStudentID(String studentID);
    void deleteByStudentID(String studentID);
    List<Student> findAll();
}
