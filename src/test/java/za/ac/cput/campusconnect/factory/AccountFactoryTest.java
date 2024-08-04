package za.ac.cput.campusconnect.factory;

/**
 * AccountFactoryTest.java
 * Class: AccountFactory
 * Author: Musaddiq McWhite (219369151)
 * Completion date: 25 June 2024
 */

import org.junit.jupiter.api.*;
import za.ac.cput.campusconnect.domain.Account;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountFactoryTest {

    @Test
    @Order(1)
    void testBuildAccount(){
        Account account = AccountFactory.buildAccount(219369151L,"RealMusaddiq", "Musaddiq219", "Admin");
        assertNotNull(account);
        System.out.println(account);
    }

    @Test
    @Disabled
    @Order(2)
    void testFail(){
        Account account = AccountFactory.buildAccount(123456L, "RealMusaddiq", "Musaddiq123", "Student");
        assertNotNull(account);
        System.out.println(account);
    }

}
