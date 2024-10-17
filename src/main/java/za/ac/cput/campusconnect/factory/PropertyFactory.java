package za.ac.cput.campusconnect.factory;

import za.ac.cput.campusconnect.domain.Business;
import za.ac.cput.campusconnect.domain.Property;
import za.ac.cput.campusconnect.util.Helper;

/**
 * FileName.java
 * Class:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */

public class PropertyFactory {
    public static Property buildProperty(Business business, String propertyName,
                                         String propertyAddress,int maleRoom, int femaleRoom){
        if(Helper.isNullOrEmpty(business) || Helper.isNullOrEmpty(propertyName)||
                Helper.isNullOrEmpty(propertyAddress)|| Helper.isNullOrEmpty(maleRoom)|| Helper.isNullOrEmpty(femaleRoom)){
            return null;
        }
        return new Property.Builder()
                .setBusiness(business)
                .setPropertyName(propertyName)
                .setPropertyAddress(propertyAddress)
                .setMaleRoom(maleRoom)
                .setFemaleRoom(femaleRoom)
                .build();
    }
}