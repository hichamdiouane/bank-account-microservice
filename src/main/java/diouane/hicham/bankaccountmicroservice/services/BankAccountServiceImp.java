package diouane.hicham.bankaccountmicroservice.services;

import diouane.hicham.bankaccountmicroservice.dtos.BankAccountRequestDTO;
import diouane.hicham.bankaccountmicroservice.dtos.BankAccountResponseDTO;
import diouane.hicham.bankaccountmicroservice.entities.BankAccount;
import diouane.hicham.bankaccountmicroservice.mappers.BankAccountMapper;
import diouane.hicham.bankaccountmicroservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImp implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    public BankAccountServiceImp(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
    }


    public BankAccountResponseDTO createBankAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder().id(UUID.randomUUID().toString())
                .accountType(bankAccountDTO.getAccountType())
                .balance(bankAccountDTO.getBalance())
                .createdAt(new Date())
                .currency(bankAccountDTO.getCurrency())
                .build();
        this.bankAccountRepository.save(bankAccount);
        return bankAccountMapper.fromBankAccount(bankAccount);
    }

    public BankAccountResponseDTO getBankAccountById(String id) {
        return bankAccountMapper.fromBankAccount(this.bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Bank account not found")));
    }

    public List<BankAccountResponseDTO> getAllBankAccounts() {
        List<BankAccount> bankAccounts = this.bankAccountRepository.findAll();
        List<BankAccountResponseDTO> bankAccountResponseDTOS = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapper.fromBankAccount(bankAccount);
            bankAccountResponseDTOS.add(bankAccountResponseDTO);
        }
        return bankAccountResponseDTOS;
    }

    public BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = this.bankAccountRepository.findBankAccountById(id);
        if (bankAccount.getBalance() != null) bankAccount.setBalance(bankAccountDTO.getBalance());
        if (bankAccount.getCurrency() != null)  bankAccount.setCurrency(bankAccountDTO.getCurrency());
        if (bankAccount.getAccountType() != null)  bankAccount.setAccountType(bankAccountDTO.getAccountType());
        return bankAccountMapper.fromBankAccount(bankAccountRepository.save(bankAccount));
    }

    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }

}