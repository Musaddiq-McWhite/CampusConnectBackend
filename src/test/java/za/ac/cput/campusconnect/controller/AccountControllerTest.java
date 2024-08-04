package za.ac.cput.campusconnect.controller;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import za.ac.cput.campusconnect.domain.Account;

import za.ac.cput.campusconnect.factory.AccountFactory;


import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Account[]> response = restTemplate.getForEntity(url, Account[].class);
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("All Accounts: " + Arrays.toString(response.getBody()));
    }
/*
    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController)
                .setControllerAdvice(new ResponseEntityExceptionHandler())
                .build();
    }

    @Test
    public void testCreateAccountSuccess() throws Exception {
        Account account = new Account();
        account.setAccountNumber("123456");
        when(accountService.create(any(Account.class))).thenReturn(account);

        mockMvc.perform(post("/Account/create")
                        .contentType("application/json")
                        .content("{\"accountNumber\": \"123456\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.accountNumber").value("123456"));

        verify(accountService, times(1)).create(any(Account.class));
    }

    @Test
    public void testCreateAccountFailure() throws Exception {
        when(accountService.create(any(Account.class))).thenReturn(null);

        mockMvc.perform(post("/Account/create")
                        .contentType("application/json")
                        .content("{\"accountNumber\": \"123456\"}"))
                .andExpect(status().isBadRequest());

        verify(accountService, times(1)).create(any(Account.class));
    }

    @Test
    public void testReadAccountSuccess() throws Exception {
        Account account = new Account();
        account.setAccountNumber("123456");
        when(accountService.read(anyString())).thenReturn(account);

        mockMvc.perform(get("/Account/read/123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("123456"));

        verify(accountService, times(1)).read(anyString());
    }

    @Test
    public void testReadAccountNotFound() throws Exception {
        when(accountService.read(anyString())).thenReturn(null);

        mockMvc.perform(get("/Account/read/123456"))
                .andExpect(status().isNotFound());

        verify(accountService, times(1)).read(anyString());
    }

    @Test
    public void testGetAllAccounts() throws Exception {
        Set<Account> accounts = new HashSet<>();
        Account account = new Account();
        account.setAccountNumber("123456");
        accounts.add(account);
        when(accountService.findAll()).thenReturn(accounts);

        mockMvc.perform(get("/Account/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].accountNumber").value("123456"));

        verify(accountService, times(1)).findAll();
    }

    @Test
    public void testUpdateAccountSuccess() throws Exception {
        Account account = new Account();
        account.setAccountNumber("123456");
        when(accountService.update(any(Account.class))).thenReturn(account);

        mockMvc.perform(post("/Account/update")
                        .contentType("application/json")
                        .content("{\"accountNumber\": \"123456\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("123456"));

        verify(accountService, times(1)).update(any(Account.class));
    }

    @Test
    public void testUpdateAccountFailure() throws Exception {
        when(accountService.update(any(Account.class))).thenReturn(null);

        mockMvc.perform(post("/Account/update")
                        .contentType("application/json")
                        .content("{\"accountNumber\": \"123456\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Error updating account. Please try again later"));

        verify(accountService, times(1)).update(any(Account.class));
    } */
}
