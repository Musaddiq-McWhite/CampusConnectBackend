package za.ac.cput.campusconnect.factory;

import za.ac.cput.campusconnect.domain.Demographic;
import za.ac.cput.campusconnect.util.Helper;

public class DemographicFactory {
    public static Demographic buildDemographic(String nationality, String race, String gender, String dateOfBirth) {
        if (Helper.isNullOrEmpty(nationality) || Helper.isNullOrEmpty(race) || Helper.isNullOrEmpty(gender) || Helper.isNullOrEmpty(dateOfBirth)) {
            throw new IllegalArgumentException("All fields are required.");
        }

        return new Demographic.Builder()
                .setNationality(nationality)
                .setRace(race)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth)
                .buildDemographic();
    }
}
