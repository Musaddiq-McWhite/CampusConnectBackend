package za.ac.cput.campusconnect.factory;

/**
 * AccountFactoryTest.java
 * Class: AccountFactory
 * Author: Musaddiq McWhite (219369151)
 * Completion date: 25 June 2024
 */

import za.ac.cput.campusconnect.domain.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountFactoryTest {

    @Test
    @Order(1)
    void testBuildAccount(){
        Account account = AccountFactory.buildAccount("219369151","RealMusaddiq", "Musaddiq219", "Admin");
        assertNotNull(account);
        System.out.println(account);
    }

    @Test
    @Order(2)
    void testFail(){
        Account account = AccountFactory.buildAccount("", "RealMusaddiq", "Musaddiq123", "Admin");
        assertNotNull(account);
        System.out.println(account);
    }

}
