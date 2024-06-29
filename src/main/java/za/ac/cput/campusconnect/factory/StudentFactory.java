package za.ac.cput.factory;

import za.ac.cput.domain.Student;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Demographic;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.AcademicInfo;
import za.ac.cput.util.Helper;

public class StudentFactory {
    public static Student createStudent(String studentID, Name name, Demographic demographic, Contact contact, AcademicInfo academicInfo, String username, String password) {

        if (Helper.isNullOrEmpty(studentID) || Helper.isNullOrEmpty(username) ||
                 Helper.isNullOrEmpty(password))
            return null;

        return new Student.Builder()
                .setStudentID(studentID)
                .setName(name)
                .setDemographic(demographic)
                .setContact(contact)
                .setAcademicInfo(academicInfo)
                .setUsername(username)
                .setStudentPassword(password)
                .buildStudent();
    }
}
