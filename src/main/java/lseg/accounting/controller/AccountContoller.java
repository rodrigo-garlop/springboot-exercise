package lseg.accounting.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lseg.accounting.domain.Account;
import lseg.accounting.exception.AccountNotFoundException;
import lseg.accounting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountContoller {

    private final AccountService accountService;

    @Autowired
    public AccountContoller(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("")
    @ApiOperation("Get accounts list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users list")}
    )
    public ResponseEntity<List<Account>> getAccounts() {
        return new ResponseEntity<>(this.accountService.getAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    @ApiOperation("Get account by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account found"),
            @ApiResponse(code = 404, message = "Account not found") }
    )
    public ResponseEntity<Account> getAccount(@PathVariable long accountId) {
        try {
            return new ResponseEntity<>(this.accountService.getAccount(accountId), HttpStatus.OK);

        } catch (AccountNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
    }

    @DeleteMapping("/{accountId}")
    @ApiOperation("Delete account by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account deleted"),
            @ApiResponse(code = 404, message = "Account not found") }
    )
    public ResponseEntity<Void> deleteAccount(@PathVariable long accountId) {
        try {
            this.accountService.deleteAccount(accountId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AccountNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
    }

}
