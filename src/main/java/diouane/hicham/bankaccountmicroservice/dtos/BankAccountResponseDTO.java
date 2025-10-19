package diouane.hicham.bankaccountmicroservice.dtos;

import diouane.hicham.bankaccountmicroservice.enums.AccountType;
import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BankAccountResponseDTO {
    private Double balance;
    private String currency;
    private String id;
    private Date createdAt;
    private AccountType accountType;
}