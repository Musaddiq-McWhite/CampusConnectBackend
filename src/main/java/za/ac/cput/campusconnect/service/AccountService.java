package za.ac.cput.campusconnect.service;

/**
 * AccountService.java
 * Class:AccountService
 * Author:Musaddiq McWhite (cowboys24 - 219369151)
 * Completion date:
 */

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.campusconnect.domain.Account;
import za.ac.cput.campusconnect.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService implements IService<Account, Long> {

    private final AccountRepository repository;

    @Autowired
    AccountService(AccountRepository repository) {this.repository = repository;}

    @Override
    public Account create(Account account) {return repository.save(account);}

    @Override
    public Account read(Long accountNumber) {return repository.findAccountByAccountNumber(accountNumber);}

    @Override
    public Account update(Account account) {return repository.save(account);}

    public void delete(Long accountNumber) {repository.deleteById(accountNumber);}

    public List<Account> getAll() {return repository.findAll();}

}