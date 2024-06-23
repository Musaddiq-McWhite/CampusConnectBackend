package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {
    public static Contact createContact(String phoneNumber, String email, String addressLine1, String addressLine2, String city, String postalCode) {

        if (Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(addressLine1) ||
                Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(postalCode))
            return null;

        return new Contact.Builder()
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setAddressLine1(addressLine1)
                .setAddressLine2(addressLine2)
                .setCity(city)
                .setPostalCode(postalCode)
                .buildContact();
    }
}
