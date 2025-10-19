package diouane.hicham.bankaccountmicroservice.repositories;

import diouane.hicham.bankaccountmicroservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    BankAccount findBankAccountById(String id);
}