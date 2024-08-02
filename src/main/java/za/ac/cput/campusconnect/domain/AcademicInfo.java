/**
 * FileName: AcademicInfo.java
 * Class: AcademicInfo
 * Author: Kabo Khundunyane
 * Completion date: 9 July 2024
 */
package za.ac.cput.campusconnect.domain;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class AcademicInfo implements Serializable {
    private String studentNumber;
    private String academicInstitution;
    private String academicCourse;
    private String academicYear;
    protected AcademicInfo() {}
    private AcademicInfo(Builder builder) {
        this.studentNumber = builder.studentNumber;
        this.academicInstitution = builder.academicInstitution;
        this.academicCourse = builder.academicCourse;
        this.academicYear = builder.academicYear;
    }
    public String getStudentNumber() {
        return studentNumber;
    }
    public String getAcademicInstitution() {
        return academicInstitution;
    }
    public String getAcademicCourse() {
        return academicCourse;
    }
    public String getAcademicYear() {
        return academicYear;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicInfo that = (AcademicInfo) o;
        return Objects.equals(studentNumber, that.studentNumber) &&
                Objects.equals(academicInstitution, that.academicInstitution) &&
                Objects.equals(academicCourse, that.academicCourse) &&
                Objects.equals(academicYear, that.academicYear);
    }
    @Override
    public int hashCode() {
        return Objects.hash(studentNumber, academicInstitution, academicCourse, academicYear);
    }
    @Override
    public String toString() {
        return "AcademicInfo{" +
                "studentNumber='" + studentNumber + '\'' +
                ", academicInstitution='" + academicInstitution + '\'' +
                ", academicCourse='" + academicCourse + '\'' +
                ", academicYear='" + academicYear + '\'' +
                '}';
    }
    public static class Builder {
        private String studentNumber;
        private String academicInstitution;
        private String academicCourse;
        private String academicYear;
        public Builder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }
        public Builder setAcademicInstitution(String academicInstitution) {
            this.academicInstitution = academicInstitution;
            return this;
        }
        public Builder setAcademicCourse(String academicCourse) {
            this.academicCourse = academicCourse;
            return this;
        }
        public Builder setAcademicYear(String academicYear) {
            this.academicYear = academicYear;
            return this;
        }
        public Builder copyAcademicInfo(AcademicInfo academicInfo) {
            this.studentNumber = academicInfo.studentNumber;
            this.academicInstitution = academicInfo.academicInstitution;
            this.academicCourse = academicInfo.academicCourse;
            this.academicYear = academicInfo.academicYear;
            return this;
        }
        public AcademicInfo buildAcademicInfo() {
            return new AcademicInfo(this);
        }
    }
}