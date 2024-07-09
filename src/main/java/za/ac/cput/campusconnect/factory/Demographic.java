package za.ac.cput.campusconnect.factory;
import za.ac.cput.domain.Demographic;
import za.ac.cput.util.Helper;

public class DemographicFactory {
    public static Demographic createDemographic(String nationality, String race, String gender, String dob) {

        if (Helper.isNullOrEmpty(race) || Helper.isNullOrEmpty(gender) || Helper.isNullOrEmpty(dob))
            return null;

        return new Demographic.Builder()
                .setNationality(nationality)
                .setRace(race)
                .setGender(gender)
                .setDateOfBirth(dob)
                .buildDemographic();
    }
}
