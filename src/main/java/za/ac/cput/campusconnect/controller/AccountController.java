package za.ac.cput.campusconnect.controller;

/**
 * AccountController.java
 * Class:AccountController
 * Author: Musaddiq McWhite (219369151 - Cowboys24)
 * Completion date:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.campusconnect.domain.Account;
import za.ac.cput.campusconnect.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Account account) {
        Account newAccount = accountService.create(account);
        if (newAccount == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @GetMapping("/read/{accountNumber}")
    public ResponseEntity<?> read(@PathVariable Long accountNumber) {
        Account account = accountService.read(accountNumber);
        if (account == null) {
            return ResponseEntity.badRequest().body("Account with Account Number: " + accountNumber + " does not exist");
        }
        return ResponseEntity.ok(account);
    }

    @GetMapping("getAll")
    public List<Account> getAll() {return accountService.getAll();}

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Account account) {
        Account updatedAccount = accountService.create(account);
        if (updatedAccount == null) {
            return ResponseEntity.badRequest().body("Error updating account. Please try again later");
        }
        return ResponseEntity.ok(updatedAccount);
    }

}
