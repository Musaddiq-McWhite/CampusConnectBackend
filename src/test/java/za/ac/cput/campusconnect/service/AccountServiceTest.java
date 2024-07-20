package za.ac.cput.campusconnect.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.campusconnect.domain.Account;
import za.ac.cput.campusconnect.factory.AccountFactory;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class);
public class AccountServiceTest {

        @Autowired
        private AccountService accountService;
        private static Account account1, account2;

        @Test
        @Order(1)
        void setup() {
            account1 = AccountFactory.buildAccount("219369151","Musaddiq","Musaddiq1234","Admin");
            assertNotNull(account1);
            System.out.println(account1);
            account2 = AccountFactory.buildAccount("171671362","McWhite","McWhite1234","Admin");
            assertNotNull(account2);
            System.out.println(account2);
        }

        @Test
        @Order(2)
        void create() {
            Account created1 = accountService.create(account1);
            assertNotNull(created1);
            System.out.println("Account created " + created1);
            Account created2 = accountService.create(account2);
            assertNotNull(created2);
            System.out.println("Account created " + created2);
        }

        @Test
        @Order(3)
        void read() {
            Account read = accountService.read(account1.getAccountNumber());
            assertNotNull(read);
            System.out.println(read);
        }

        @Test
        @Order(4)
        void update() {
            Account newAccount = new Account.Builder().copy(account2).setAccountNumber("171671362").build();
            Account updated = accountService.update(newAccount);
            assertNotNull(updated);
            System.out.println(updated);
        }

        @Test
        @Order(5)
        void getAll() {System.out.println(accountService.findAll());}
}
