package diouane.hicham.bankaccountmicroservice.services;

import diouane.hicham.bankaccountmicroservice.dtos.BankAccountRequestDTO;
import diouane.hicham.bankaccountmicroservice.dtos.BankAccountResponseDTO;

import java.util.List;

public interface BankAccountService {
    public BankAccountResponseDTO createBankAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponseDTO getBankAccountById(String id);
    public List<BankAccountResponseDTO> getAllBankAccounts();
    public BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccountDTO);
    public void deleteBankAccount(String id);
}
