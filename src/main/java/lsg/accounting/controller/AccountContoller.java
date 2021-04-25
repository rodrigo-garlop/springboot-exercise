package lsg.accounting.controller;

import lsg.accounting.domain.Account;
import lsg.accounting.domain.User;
import lsg.accounting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountContoller {

    private final AccountService accountService;

    @Autowired
    public AccountContoller(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable long accountId) {
        Account accountSearched = this.accountService.getAccount(accountId);
        if (accountSearched == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(accountSearched, HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable long accountId) {
        this.accountService.deleteAccount(accountId);
        return new ResponseEntity<>("account deleted", HttpStatus.OK);
    }

}
