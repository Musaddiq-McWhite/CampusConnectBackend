package za.ac.cput.factory;
import za.ac.cput.domain.AcademicInfo;
import za.ac.cput.util.Helper;
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