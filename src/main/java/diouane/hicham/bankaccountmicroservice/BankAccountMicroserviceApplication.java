package diouane.hicham.bankaccountmicroservice;

import diouane.hicham.bankaccountmicroservice.entities.BankAccount;
import diouane.hicham.bankaccountmicroservice.enums.AccountType;
import diouane.hicham.bankaccountmicroservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountMicroserviceApplication.class, args);
    }

    //@Bean
    CommandLineRunner init(BankAccountRepository bankAccountRepository) {
        return args -> {
            for (int i = 0; i < 5; i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .createdAt(new Date())
                        .balance(1000 + Math.random() * 99000) // Generates a balance between 1000 and 100,000
                        .currency("MAD")
                        .build();
                bankAccountRepository.save(bankAccount);
            }
        };
    }
}