package za.ac.cput.campusconnect.controller;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.campusconnect.domain.Account;
import za.ac.cput.campusconnect.factory.AccountFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "/account";
    private Account account;

    @BeforeEach
    void setUp() {
        account = AccountFactory.buildAccount(123L,"Username","Password","Admin");
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Account> postResponse = restTemplate.postForEntity(url, account, Account.class);
        assertNotNull(postResponse);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
        Account savedAccount = postResponse.getBody();
        assertNotNull(savedAccount);
        assertEquals(account.getAccountNumber(),savedAccount.getAccountNumber());
        System.out.println("Saved Administrator: " + savedAccount);
    }


    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + account.getAccountNumber();
        ResponseEntity<Account> response = restTemplate.getForEntity(url, Account.class);
        assertNotNull(response.getBody());
        assertEquals(account.getAccountNumber(),response.getBody().getAccountNumber());
        System.out.println("Read Account: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        Account updatedAccount = new Account.Builder().copy(account).setUsername("Admin").build();
        String url = BASE_URL + "/update";
        restTemplate.put(url, updatedAccount);
        ResponseEntity<Account> response = restTemplate.getForEntity(BASE_URL + "/read/" + account.getAccountNumber(), Account.class);
        assertNotNull(response.getBody());
        assertEquals("Admin", response.getBody().getUsername());
        System.out.println("Updated Account: " + response.getBody());
    }

    @Disabled
    @Test
    @Order(4)
    void delete() {
        String URL = BASE_URL + "/delete/" + account.getAccountNumber();
        System.out.println("URL: " + URL);
        restTemplate.delete(URL);
        ResponseEntity<Account> response = restTemplate.getForEntity(BASE_URL + "/read/" + account.getAccountNumber(), Account.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Success: Deleted account");
    }

    @Test
    @Order(5)
    void getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Account[]> response = restTemplate.getForEntity(url, Account[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("All Accounts: " + Arrays.toString(response.getBody()));
    }
}
