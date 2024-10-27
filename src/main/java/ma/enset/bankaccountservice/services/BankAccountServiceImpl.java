package ma.enset.bankaccountservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankaccountservice.entities.BankAccount;
import ma.enset.bankaccountservice.mappers.BankAccountMapper;
import ma.enset.bankaccountservice.repositories.BankAccountRepository;

import java.util.*;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    public BankAccountRepository bankAccountRepository;
    @Autowired
    public BankAccountMapper bankAccountMapper;

    @Override
    public BankAccountResponseDTO save(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = this.bankAccountMapper.fromBankAccountRequestDTOToBankAccount(bankAccountRequestDTO);
        BankAccount savedBankAccount = this.bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = this.bankAccountMapper.fromBankAccountToBankAccountResponseDTO(savedBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO update(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccountResponseDTO bankAccountResponseDTO = this.get(id);
        if (bankAccountResponseDTO != null) {
            BankAccount bankAccount = new BankAccount();
            if(bankAccountRequestDTO.getBalance() != null) {
                bankAccount.setBalance(bankAccount.getBalance());
            }
            if(bankAccountRequestDTO.getBalance() != null) {
                bankAccount.setType(bankAccount.getType());
            }
            if(bankAccountRequestDTO.getBalance() != null) {
                bankAccount.setCurrency(bankAccount.getCurrency());
            }
            BankAccount savedBankAccount = this.bankAccountRepository.save(bankAccount);
            bankAccountResponseDTO = this.bankAccountMapper.fromBankAccountToBankAccountResponseDTO(savedBankAccount);
            return bankAccountResponseDTO;
        }
        return null;
    }

    @Override
    public BankAccountResponseDTO get(String id) {
        BankAccount bankAccount = this.bankAccountRepository.findOneById(id);
        if(bankAccount != null) {
            BankAccountResponseDTO bankAccountResponseDTO = this.bankAccountMapper.fromBankAccountToBankAccountResponseDTO(bankAccount);
            return bankAccountResponseDTO;
        }
        return null;
    }

    @Override
    public List<BankAccountResponseDTO> getAll() {
        List<BankAccount> bankAccounts = this.bankAccountRepository.findAll();
        List<BankAccountResponseDTO> bankAccountResponseDTOs = bankAccounts.stream().map(bankAccount -> this.bankAccountMapper.fromBankAccountToBankAccountResponseDTO(bankAccount)).toList();
        return bankAccountResponseDTOs;
    }

    @Override
    public BankAccountResponseDTO delete(String id) {
        BankAccountResponseDTO bankAccountResponseDTO = this.get(id);
        if (bankAccountResponseDTO != null) {
            this.bankAccountRepository.deleteById(id);
            return bankAccountResponseDTO;
        }
        return null;
    }
    
}
