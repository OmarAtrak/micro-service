package ma.enset.bankaccountservice.services;

import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;

import java.util.*;

public interface BankAccountService {
    public BankAccountResponseDTO save(BankAccountRequestDTO bankAccountRequestDTO);
    public BankAccountResponseDTO update(String id, BankAccountRequestDTO bankAccountRequestDTO);
    public BankAccountResponseDTO get(String id);
    public List<BankAccountResponseDTO> getAll();
    public BankAccountResponseDTO delete(String id);
}
