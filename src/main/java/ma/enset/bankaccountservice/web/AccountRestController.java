package ma.enset.bankaccountservice.web;

import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankaccountservice.services.BankAccountService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/bank-accounts/")
public class AccountRestController {
    private BankAccountService bankAccountService;

    public AccountRestController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("index")
    public List<BankAccountResponseDTO> index() {
        return this.bankAccountService.getAll();
    }

    @GetMapping("{id}")
    public BankAccountResponseDTO get(@PathVariable String id) {
        return this.bankAccountService.get(id);
    }

    @PostMapping("save")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
        return this.bankAccountService.save(bankAccountRequestDTO);
    }

    @PutMapping("update/{id}")
    public BankAccountResponseDTO update(@PathVariable String id, @RequestBody BankAccountRequestDTO bankAccount) {
        return this.bankAccountService.update(id, bankAccount);
    }

    @DeleteMapping("/delete/{id}")
    public BankAccountResponseDTO delete(@PathVariable String id) {
        return this.bankAccountService.delete(id);
    }
}