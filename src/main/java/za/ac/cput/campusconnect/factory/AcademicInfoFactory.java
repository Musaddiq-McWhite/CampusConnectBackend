/**
 * FileName AcademicInfoFactory.java
 * Class: AcademicInfoFactory
 * Author: Kabo Khundunyane
 * Completion date: 9 July 2024
 */
package za.ac.cput.campusconnect.factory;
import za.ac.cput.campusconnect.domain.AcademicInfo;
import za.ac.cput.campusconnect.util.Helper;
public class AcademicInfoFactory {
    public static AcademicInfo buildAcademicInfo(String studentNumber, String course, String year, String institution) {

        if (Helper.isNullOrEmpty(studentNumber) || Helper.isNullOrEmpty(course) || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(institution))
            return null;

        return new AcademicInfo.Builder()
                .setStudentNumber(studentNumber)
                .setAcademicInstitution(institution)
                .setAcademicCourse(course)
                .setAcademicYear(year)
                .buildAcademicInfo();
    }
}