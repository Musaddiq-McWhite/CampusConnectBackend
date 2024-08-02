package za.ac.cput.campusconnect.factory;

import za.ac.cput.campusconnect.domain.Account;
import za.ac.cput.campusconnect.util.Helper;

/**
 * AccountFactory.java
 * Class: AccountFactory
 * Author: Musaddiq McWhite (219369151)
 * Completion date: 24 June 2024
 */

public class AccountFactory {
    public static Account buildAccount(Long accountNumber, String username, String password, String userType) {
        if (Helper.isNullOrEmpty(accountNumber) || Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(userType))
            return null;
        return new Account.Builder().setAccountNumber(accountNumber).setUsername(username).setPassword(password).setUserType(userType).build();
    }

//    public static Account buildAccount(String username, String password, String userType) {
//        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(userType))
//            return null;
//        String accountNumber = Helper.generateId();
//        return new Account.Builder().setAccountNumber(accountNumber).setUsername(username).setPassword(password).setUserType(userType).build();
//    }

}