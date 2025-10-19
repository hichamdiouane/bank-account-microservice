package diouane.hicham.bankaccountmicroservice.web;

import diouane.hicham.bankaccountmicroservice.dtos.BankAccountRequestDTO;
import diouane.hicham.bankaccountmicroservice.dtos.BankAccountResponseDTO;
import diouane.hicham.bankaccountmicroservice.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    BankAccountService bankAccountService;

    public AccountRestController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccountResponseDTO bankAccount(@PathVariable String id) {
        return this.bankAccountService.getBankAccountById(id);
    }

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccounts() {
        return this.bankAccountService.getAllBankAccounts();
    }

    @PostMapping("/bankAccount")
    public BankAccountResponseDTO createBankAccount(@RequestBody BankAccountRequestDTO bankAccountDTO) {
        return bankAccountService.createBankAccount(bankAccountDTO);
    }

    @PutMapping("/bankAccount/{id}")
    public BankAccountResponseDTO updateBankAccount(@PathVariable String id, @RequestBody BankAccountRequestDTO bankAccountDTO) {
        return bankAccountService.updateBankAccount(id, bankAccountDTO);
    }

    @DeleteMapping("/bankAccount/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountService.deleteBankAccount(id);
    }
}