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

public class BusinessFactory {
    public static Business buildBusiness( String businessID, String businessName,String description,
                                          String contactID,int phoneNumber,String emailAddress, int emergencyContact) {
        if (Helper.isNullOrEmpty(businessID) || Helper.isNullOrEmpty(businessName) ||
                Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(contactID) ||Helper.isNullOrEmpty(phoneNumber)
        || Helper.isNullOrEmpty(emailAddress) || Helper.isNullOrEmpty(emergencyContact)) {
            return null;
        }
        Contact contact = ContactFactory.buildContact(contactID,phoneNumber,emailAddress,emergencyContact);
        if (contact == null) {
           return null;
        }
        return new Business.Builder().setBusinessID(businessID)
                .setBusinessName(businessName)
                .setContact(contact)
                .setDescription(description)
                .build();
    }

}

