package za.ac.cput.campusconnect.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.AcademicInfo;
import za.ac.cput.repository.AcademicInfoRepository;
import java.util.List;
/**
 * FileName AcademicInfoService.java
 * Class: AcademicInfoService
 * Author: Kabo Khudunyane
 * Completion date: 11 July 2024
 */

@Service
public class AcademicInfoService implements IService<AcademicInfo, String> {
    private final AcademicInfoRepository academicInfoRepository;
    @Autowired
    public AcademicInfoService(AcademicInfoRepository academicInfoRepository) {
        this.academicInfoRepository = academicInfoRepository;
    }
    @Override
    public AcademicInfo create(AcademicInfo academicInfo) {
        return academicInfoRepository.save(academicInfo);
    }
    @Override
    public AcademicInfo read(String academicID) {
        return academicInfoRepository.findByAcademicID(academicID);
    }
    @Override
    public AcademicInfo update(AcademicInfo academicInfo) {
        return academicInfoRepository.save(academicInfo);
    }
    public void delete(String academicID) {
        academicInfoRepository.deleteByAcademicID(academicID);
    }
    public List<AcademicInfo> getAllAcademicInfo() {
        return academicInfoRepository.findAll();
    }
}
