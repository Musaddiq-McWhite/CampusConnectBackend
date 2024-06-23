package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Demographic {
    @Id
    private String demographicID;
    private String race;
    private String gender;
    private String dateOfBirth;
    private String nationality;

    protected Demographic() {}

    private Demographic(Builder builder) {
        this.demographicID = builder.demographicID;
        this.race = builder.race;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
        this.nationality = builder.nationality;
    }

    public String getDemographicID() {
        return demographicID;
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

    public String getNationality() {
        return nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demographic that = (Demographic) o;
        return Objects.equals(demographicID, that.demographicID) &&
                Objects.equals(race, that.race) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(nationality, that.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(demographicID, race, gender, dateOfBirth, nationality);
    }

    @Override
    public String toString() {
        return "Demographic{" +
                "demographicID='" + demographicID + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public static class Builder {
        private String demographicID;
        private String race;
        private String gender;
        private String dateOfBirth;
        private String nationality;

        public Builder setDemographicID(String demographicID) {
            this.demographicID = demographicID;
            return this;
        }

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
            this.demographicID = demographic.demographicID;
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
