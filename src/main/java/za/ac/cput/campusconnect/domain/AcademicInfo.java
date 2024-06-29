package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class AcademicInfo {
    @Id
    private String academicID;
    private String academicInstitution;
    private String academicCourse;
    private String academicYear;
    protected AcademicInfo() {}
    private AcademicInfo(Builder builder) {
        this.academicID = builder.academicID;
        this.academicInstitution = builder.academicInstitution;
        this.academicCourse = builder.academicCourse;
        this.academicYear = builder.academicYear;

    }
    public String getAcademicID() {
        return academicID;
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
        return Objects.equals(academicID, that.academicID) &&
                Objects.equals(academicInstitution, that.academicInstitution) &&
                Objects.equals(academicCourse, that.academicCourse) &&
                Objects.equals(academicYear, that.academicYear);

    }

    @Override
    public int hashCode() {
        return Objects.hash(academicID, academicCourse, academicYear, academicInstitution);
    }

    @Override
    public String toString() {
        return "AcademicInfo{" +
                "academicID='" + academicID + '\'' +
                ", academicInstitution='" + academicInstitution + '\'' +
                ", academicCourse='" + academicCourse + '\'' +
                ", academicYear='" + academicYear + '\'' +
                '}';
    }

    public static class Builder {
        private String academicID;
        private String academicInstitution;
        private String academicCourse;
        private String academicYear;


        public Builder setAcademicID(String academicID) {
            this.academicID = academicID;
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
            this.academicID = academicInfo.academicID;
            this.academicCourse = academicInfo.academicCourse;
            this.academicYear = academicInfo.academicYear;
            this.academicInstitution = academicInfo.academicInstitution;
            return this;
        }
        public AcademicInfo buildAcademicInfo() {
            return new AcademicInfo(this);
        }
    }
}