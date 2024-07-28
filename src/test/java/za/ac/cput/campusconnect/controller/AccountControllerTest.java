package za.ac.cput.campusconnect.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import za.ac.cput.campusconnect.domain.Account;
import za.ac.cput.campusconnect.service.AccountService;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AccountControllerTest {

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
    }
}
