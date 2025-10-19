package diouane.hicham.bankaccountmicroservice.entities;

import diouane.hicham.bankaccountmicroservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = { BankAccount.class }, name = "p")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
