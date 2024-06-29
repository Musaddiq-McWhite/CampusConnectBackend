package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.AcademicInfo;
import java.util.List;
@Repository
public interface AcademicInfoRepository extends JpaRepository<AcademicInfo, String> {
    AcademicInfo findByAcademicID(String academicID);
    void deleteByAcademicID(String academicID);
    List<AcademicInfo> findAllAcademicInfo();
}