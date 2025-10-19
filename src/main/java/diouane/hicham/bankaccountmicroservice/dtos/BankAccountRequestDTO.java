package diouane.hicham.bankaccountmicroservice.dtos;

import diouane.hicham.bankaccountmicroservice.enums.AccountType;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType accountType;
}