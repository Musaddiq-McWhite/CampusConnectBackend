/**
 * FileName StudentRepository.java
 * Interface: StudentRepository
 * Author: Kabo Khudunyane
 * Completion date: 10 July 2024
 */
package za.ac.cput.campusconnect.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.campusconnect.domain.Student;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByStudentID(Long studentID);
    void deleteByStudentID(Long studentID);
    List<Student> findAll();
}