package za.ac.cput.campusconnect.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.campusconnect.domain.AcademicInfo;
import za.ac.cput.campusconnect.factory.AcademicInfoFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
public class AcademicInfoFactoryTest {
    @Test
    public void testCreateAcademicInfo(){
        AcademicInfo academicInfo = AcademicInfoFactory.buildAcademicInfo("216273293", "Computer Science", "2023", "CPUT");
        assertNotNull(academicInfo);
        System.out.println(academicInfo);
    }
    @Test
    public void testCreateAcademicInfoWithFail(){
        AcademicInfo academicInfo = AcademicInfoFactory.buildAcademicInfo("", "Computer Science", "2023", "CPUT");
        assertNull(academicInfo);
        System.out.println(academicInfo);
    }
}