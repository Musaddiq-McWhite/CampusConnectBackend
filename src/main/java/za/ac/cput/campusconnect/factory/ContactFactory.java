package za.ac.cput.campusconnect.factory;
import za.ac.cput.campusconnect.domain.Contact;
import za.ac.cput.campusconnect.util.Helper;
public class ContactFactory {
    public static Contact buildContact(String phoneNumber, String email, String addressLine1, String addressLine2, String city, String postalCode) {
        if (Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(addressLine1) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(postalCode)) {
            throw new IllegalArgumentException("Phone number, email, address line 1, city, and postal code are required.");
        }
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