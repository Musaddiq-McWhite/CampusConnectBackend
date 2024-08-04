package za.ac.cput.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.campusconnect.domain.Account;

import java.util.List;
import java.util.Set;

/**
 * AccountRepository.java
 * Interface: AccountRepository
 * Author: Musaddiq McWhite (219369151 - Cowboys24)
 * Completion date:
 */


public interface AccountRepository extends JpaRepository<Account, Long> {

        Account findAccountByAccountNumber(Long accountNumber);
        Set<Account> findAllByUserType(String userType);
        void deleteAccountByAccountNumber(Long accountNumber);
        List<Account> findAll();
}
