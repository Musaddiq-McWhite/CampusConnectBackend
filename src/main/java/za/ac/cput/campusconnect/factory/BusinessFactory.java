package za.ac.cput.campusconnect.factory;
import za.ac.cput.campusconnect.domain.Business;
import za.ac.cput.campusconnect.domain.Contact;
import za.ac.cput.campusconnect.util.Helper;


/**
 * FileName.java
 * Class:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */

public class BusinessFactory { public static Business buildBusiness(String businessID, String businessName, String description,
                                                                    String phoneNumber, String email, String addressLine1, String addressLine2,
                                                                    String city, String postalCode) {
        if (Helper.isNullOrEmpty(businessID) || Helper.isNullOrEmpty(businessName) ||
                Helper.isNullOrEmpty(description) ||Helper.isNullOrEmpty(phoneNumber)||Helper.isNullOrEmpty(email)||
                Helper.isNullOrEmpty(addressLine1) || Helper.isNullOrEmpty(addressLine2)|| Helper.isNullOrEmpty(city)||Helper.isNullOrEmpty(postalCode)) {
            return null;
        }
        Contact contact = ContactFactory.createContact(phoneNumber,email,addressLine1, addressLine2,  city, postalCode);
        if (contact == null) {
            return null;
        }return new Business.Builder().setBusinessID(businessID)
                .setBusinessName(businessName)
                .setContact(contact)
                .setDescription(description)
                .build();
    }}
