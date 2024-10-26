package ma.enset.bankaccountservice.web;

import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/bank-accounts/")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("index")
    public List<BankAccount> index() {
        return this.bankAccountRepository.findAll();
    }

    @GetMapping("{id}")
    public BankAccount get(@PathVariable String id) {
        return this.bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s Not Found", id)));
    }

    @PostMapping("save")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        if(bankAccount.getId() != null) {
            bankAccount.setId(UUID.randomUUID().toString());
        }
        return this.bankAccountRepository.save(bankAccount);
    }

    @PutMapping("update/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = this.bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s Not Found", id)));
        if(bankAccount.getBalance() != null) {
            account.setBalance(bankAccount.getBalance());
        }
        if(bankAccount.getBalance() != null) {
            account.setType(bankAccount.getType());
        }
        if(bankAccount.getBalance() != null) {
            account.setCurrency(bankAccount.getCurrency());
        }
        return this.bankAccountRepository.save(account);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        this.bankAccountRepository.deleteById(id);
    }
}