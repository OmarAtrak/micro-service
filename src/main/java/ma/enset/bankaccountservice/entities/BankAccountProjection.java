package ma.enset.bankaccountservice.entities;

import org.springframework.data.rest.core.config.Projection;

import ma.enset.bankaccountservice.enums.AccountType;

@Projection(types = BankAccount.class, name = "p1")
public interface BankAccountProjection {
    public String getId();
    public AccountType getType();
    public Double getDouble();
}
