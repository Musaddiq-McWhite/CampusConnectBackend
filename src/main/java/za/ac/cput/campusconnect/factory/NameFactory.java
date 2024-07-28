package za.ac.cput.campusconnect.factory;

import za.ac.cput.campusconnect.domain.Name;
import za.ac.cput.campusconnect.util.Helper;

public class NameFactory {
    public static Name buildName(String firstName, String middleName, String lastName) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("First name and last name are required.");
        }

        return new Name.Builder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .buildName();
    }
}
