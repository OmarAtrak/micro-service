package ma.enset.bankaccountservice.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import ma.enset.bankaccountservice.dto.BankAccountRequestDTO;
import ma.enset.bankaccountservice.dto.BankAccountResponseDTO;
import ma.enset.bankaccountservice.entities.BankAccount;

@Component
public class BankAccountMapper {
    public BankAccountResponseDTO fromBankAccountToBankAccountResponseDTO(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccount fromBankAccountRequestDTOToBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        return bankAccount;
    }
}
