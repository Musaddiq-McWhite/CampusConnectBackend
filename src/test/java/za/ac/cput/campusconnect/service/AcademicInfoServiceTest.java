package za.ac.cput.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.AcademicInfo;
import za.ac.cput.factory.AcademicInfoFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AcademicInfoServiceTest {

    @Autowired
    private AcademicInfoService academicInfoService;
    private static AcademicInfo academicInfo = AcademicInfoFactory.createAcademicInfo("216273293", "Computer Science", "3rd Year", "CPUT");
    @Test
    void create() {
        AcademicInfo createdAcademicInfo = academicInfoService.create(academicInfo);
        assertNotNull(createdAcademicInfo);
        System.out.println("Created AcademicInfo: " + createdAcademicInfo);
    }
    @Test
    void read() {
        AcademicInfo readAcademicInfo = academicInfoService.read(academicInfo.getAcademicID());
        assertNotNull(readAcademicInfo);
        System.out.println("Read AcademicInfo: " + readAcademicInfo);
    }
    @Test
    void update() {
        AcademicInfo newAcademicInfo = new AcademicInfo.Builder().copyAcademicInfo(academicInfo).setAcademicID("2").buildAcademicInfo();
        AcademicInfo updatedAcademicInfo = academicInfoService.update(newAcademicInfo);
        assertNotNull(updatedAcademicInfo);
        System.out.println("Updated AcademicInfo: " + updatedAcademicInfo);
    }
    @Test
    void delete() {
        academicInfoService.delete(academicInfo.getAcademicID());
        AcademicInfo deletedAcademicInfo = academicInfoService.read(academicInfo.getAcademicID());
        assertNull(deletedAcademicInfo);
        System.out.println("AcademicInfo deleted successfully.");
    }

    @Test
    void getAllAcademicInfo() {
        List<AcademicInfo> academicInfos = academicInfoService.getAllAcademicInfo();

    }
}