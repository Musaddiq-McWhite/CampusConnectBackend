package za.ac.cput.campusconnect.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * FileName.java
 * Class:
 * Author:
 * Completion date:
 */
@Entity
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int adminId;
    String adminUsername;
    String adminPassword;

    public Administrator() {
    }

    public Administrator(Builder builder) {
        this.adminId = builder.adminId;
        this.adminUsername = builder.adminUsername;
        this.adminPassword =builder. adminPassword;

    }

    public int getAdminId() {
        return adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return adminId == that.adminId && Objects.equals(adminUsername, that.adminUsername) && Objects.equals(adminPassword, that.adminPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminUsername, adminPassword);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId=" + adminId +
                ", adminUsername='" + adminUsername + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
    public static class Builder{
        int adminId;
        String adminUsername;
        String adminPassword;

        public Builder setAdminId(int adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder setAdminUsername(String adminUsername) {
            this.adminUsername = adminUsername;
            return this;
        }

        public Builder setAdminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
            return this;
        }
        public Builder copy(Administrator administrator){
            this.adminId = administrator.adminId;
            this.adminUsername = administrator.adminUsername;
            this.adminPassword =administrator. adminPassword;
            return this;
        } public Administrator build(){return new Administrator(this);}
    }
}
