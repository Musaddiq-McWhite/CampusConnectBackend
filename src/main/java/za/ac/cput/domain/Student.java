package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
public class Student {
    @Id
    private String studentID;
    @OneToOne
    private Name name;
    @OneToOne
    private Demographic demographic;
    @OneToOne
    private Contact contact;
    @OneToOne
    private AcademicInfo academicInfo;
    private String username;
    private String studentPassword;

    protected Student() {}

    private Student(Builder builder) {
        this.studentID = builder.studentID;
        this.name = builder.name;
        this.demographic = builder.demographic;
        this.contact = builder.contact;
        this.academicInfo = builder.academicInfo;
        this.username = builder.username;
        this.studentPassword = builder.studentPassword;
    }

    public String getStudentID() {
        return studentID;
    }

    public Name getName() {
        return name;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public Contact getContact() {
        return contact;
    }

    public AcademicInfo getAcademicInfo() {
        return academicInfo;
    }

    public String getUsername() {
        return username;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentID, student.studentID) &&
                Objects.equals(name, student.name) &&
                Objects.equals(demographic, student.demographic) &&
                Objects.equals(contact, student.contact) &&
                Objects.equals(academicInfo, student.academicInfo) &&
                Objects.equals(username, student.username) &&
                Objects.equals(studentPassword, student.studentPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, name, demographic, contact, academicInfo, username, studentPassword);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name=" + name +
                ", demographic=" + demographic +
                ", contact=" + contact +
                ", academicInfo=" + academicInfo +
                ", username='" + username + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                '}';
    }

    public static class Builder {
        private String studentID;
        private Name name;
        private Demographic demographic;
        private Contact contact;
        private AcademicInfo academicInfo;
        private String username;
        private String studentPassword;
        public Builder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }
        public Builder setName(Name name) {
            this.name = name;
            return this;
        }
        public Builder setDemographic(Demographic demographic) {
            this.demographic = demographic;
            return this;
        }
        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }
        public Builder setAcademicInfo(AcademicInfo academicInfo) {
            this.academicInfo = academicInfo;
            return this;
        }
        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }
        public Builder setStudentPassword(String studentPassword) {
            this.studentPassword = studentPassword;
            return this;
        }

        public String getStudentID() {
            return studentID;
        }

        public Name getName() {
            return name;
        }

        public Demographic getDemographic() {
            return demographic;
        }

        public Contact getContact() {
            return contact;
        }

        public AcademicInfo getAcademicInfo() {
            return academicInfo;
        }

        public String getUsername() {
            return username;
        }

        public String getStudentPassword() {
            return studentPassword;
        }

        public Builder copyStudent(Student student) {
            this.studentID = student.studentID;
            this.name = student.name;
            this.demographic = student.demographic;
            this.contact = student.contact;
            this.academicInfo = student.academicInfo;
            this.username = student.username;
            this.studentPassword = student.studentPassword;
            return this;
        }
        public Student buildStudent() {
            return new Student(this);
        }
    }
}