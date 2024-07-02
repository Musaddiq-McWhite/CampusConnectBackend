package za.ac.cput.campusconnect.util;

import java.util.UUID;

/**
 * Helper.java - Do not modify
 */

public class Helper {

    public static boolean isNullOrEmpty(Object obj) {
        return obj == null || obj.toString().isEmpty() || obj == "";
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

}
