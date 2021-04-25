package lsg.accounting.service;

import lsg.accounting.domain.Account;
import lsg.accounting.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(long accountId) {
        return this.accountRepository.findById(accountId).orElse(null);
    }

    public void deleteAccount(long accountId) {
        this.accountRepository.deleteById(accountId);
    }
}
