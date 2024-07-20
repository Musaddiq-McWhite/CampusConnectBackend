package za.ac.cput.campusconnect.factory;


import za.ac.cput.campusconnect.domain.Administrator;
import za.ac.cput.campusconnect.util.Helper;

/**
 * FileName.java
 * Class:
 * Author:
 * Completion date:
 */

public class AdministratorFactory {
    public static Administrator buildAdministrator(int adminId, String adminUsername, String adminPassword) {
        if (Helper.isNullOrEmpty(adminId) || Helper.isNullOrEmpty(adminUsername) || Helper.isNullOrEmpty(adminPassword) )
            return null;
        return new Administrator.Builder().setAdminId(adminId).setAdminUsername(adminUsername).setAdminPassword(adminPassword).build();
    }
}
