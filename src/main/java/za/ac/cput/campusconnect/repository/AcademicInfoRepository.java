package za.ac.cput.campusconnect.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.AcademicInfo;
import java.util.List;
/**
 * FileName AcademicInfoRepository.java
 * Interface: AdacemicInfoRepository
 * Author: Kabo Khudunyane
 * Completion date: 10 July 2024
 */


@Repository
public interface AcademicInfoRepository extends JpaRepository<AcademicInfo, String> {
    AcademicInfo findByAcademicID(String academicID);
    void deleteByAcademicID(String academicID);
    List<AcademicInfo> findAll();
}
