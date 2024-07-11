package za.ac.cput.campusconnect.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
@Entity
@Table(name = "Demographic")
public class Demographic {
    @Id
    private String nationality;
    private String race;
    private String gender;
    private String dateOfBirth;


    protected Demographic() {}

    private Demographic(Builder builder) {
        this.nationality = builder.nationality;
        this.race = builder.race;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }
    public String getRace() {
        return race;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demographic that = (Demographic) o;

        return Objects.equals(nationality, that.nationality) &&
                Objects.equals(race, that.race) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(dateOfBirth, that.dateOfBirth)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationality, race, gender, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Demographic{" +
                ", nationality='" + nationality + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public static class Builder {
        private String nationality;
        private String race;
        private String gender;
        private String dateOfBirth;



        public Builder setRace(String race) {
            this.race = race;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Builder copyDemographic(Demographic demographic) {
            this.race = demographic.race;
            this.gender = demographic.gender;
            this.dateOfBirth = demographic.dateOfBirth;
            this.nationality = demographic.nationality;
            return this;
        }

        public Demographic buildDemographic() {
            return new Demographic(this);
        }
    }
}
