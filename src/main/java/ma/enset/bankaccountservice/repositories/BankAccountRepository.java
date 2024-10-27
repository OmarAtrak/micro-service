package ma.enset.bankaccountservice.repositories;

import ma.enset.bankaccountservice.entities.BankAccount;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ma.enset.bankaccountservice.enums.AccountType;


@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    BankAccount findOneById(String id);
    List<BankAccount> findByType(AccountType type);
}
