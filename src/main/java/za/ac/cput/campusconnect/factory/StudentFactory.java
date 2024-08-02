package za.ac.cput.campusconnect.factory;
import za.ac.cput.campusconnect.domain.Student;
import za.ac.cput.campusconnect.domain.Name;
import za.ac.cput.campusconnect.domain.Demographic;
import za.ac.cput.campusconnect.domain.Contact;
import za.ac.cput.campusconnect.domain.AcademicInfo;
import za.ac.cput.campusconnect.util.Helper;
public class StudentFactory {
    public static Student buildStudent(Name name, Demographic demographic, Contact contact, AcademicInfo academicInfo, String username, String studentPassword) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(demographic) || Helper.isNullOrEmpty(contact) ||
                Helper.isNullOrEmpty(academicInfo) || Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(studentPassword)) {
            throw new IllegalArgumentException("All fields are required.");
        }
        return new Student.Builder()
                .setName(name)
                .setDemographic(demographic)
                .setContact(contact)
                .setAcademicInfo(academicInfo)
                .setUsername(username)
                .setStudentPassword(studentPassword)
                .buildStudent();
    }
}