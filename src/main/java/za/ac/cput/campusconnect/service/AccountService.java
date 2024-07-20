package za.ac.cput.campusconnect.service;

/**
 * AccountService.java
 * Class:AccountService
 * Author:Musaddiq McWhite (cowboys24 - 219369151)
 * Completion date:
 */

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.campusconnect.domain.Account;
import za.ac.cput.campusconnect.repository.AccountRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountService implements IService<Account, String> {

    private final AccountRepository repository;

    @Autowired
    AccountService(AccountRepository repository) {this.repository = repository;}

    @Override
    public Account create(Account account) {return repository.save(account);}

    @Override
    public Account read(String accountNumber) {return repository.findAccountByAccountNumber(accountNumber);}

    @Override
    public Account update(Account account) {return repository.save(account);}

    public void delete(String accountNumber) {repository.deleteAccountByAccountNumber(accountNumber);};

    public Set<Account> findAll(String userType) {return repository.findAllByUserType(userType);}

    public Set<Account> findAll() {return repository.findAll().stream().collect(Collectors.toSet());}

}