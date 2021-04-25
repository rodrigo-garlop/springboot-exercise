package lsg.accounting.service;

import lsg.accounting.domain.Account;
import lsg.accounting.exception.AccountNotFoundException;
import lsg.accounting.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        List<Account> accounts = new LinkedList<>();
        this.accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public Account getAccount(long accountId) throws AccountNotFoundException {
        return this.accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);
    }

    public void deleteAccount(long accountId) throws AccountNotFoundException {
        Account accountToDelete = this.accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);
        this.accountRepository.deleteById(accountId);
    }
}
