package za.ac.cput.campusconnect.factory;
import za.ac.cput.domain.AcademicInfo;
import za.ac.cput.util.Helper;

/**
 * FileName AcademicInfoFactory.java
 * Class: AcademicInfoFactory
 * Author: Kabo Khundunyane
 * Completion date: 9 July 2024
 */

public class AcademicInfoFactory {
    public static AcademicInfo createAcademicInfo(String academicID, String course, String year, String institution) {

        if (Helper.isNullOrEmpty(academicID) || Helper.isNullOrEmpty(course) || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(institution))
            return null;

        return new AcademicInfo.Builder()
                .setAcademicID(academicID)
                .setAcademicInstitution(institution)
                .setAcademicCourse(course)
                .setAcademicYear(year)
                .buildAcademicInfo();
    }
}
