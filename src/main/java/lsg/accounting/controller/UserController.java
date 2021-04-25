package lsg.accounting.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lsg.accounting.domain.Account;
import lsg.accounting.domain.User;
import lsg.accounting.exception.UserNotFoundException;
import lsg.accounting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    @ApiOperation("Get users list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users list")}
    )
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    @ApiOperation("Get user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found") }
            )
    public ResponseEntity<User> getUser(@PathVariable long userId) {
        try {
            return new ResponseEntity<>(this.userService.getUser(userId), HttpStatus.OK);

        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @PostMapping("/{userId}/account")
    @ApiOperation(value = "Add account to existing user", notes = "accountId value is ignored")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account added"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "User not found") }
    )
    public ResponseEntity<Account> addAccount(@PathVariable long userId, @Valid @RequestBody Account account) {
        try {
            Account accountSaved  = userService.addAccount(userId, account);
            return new ResponseEntity<>(accountSaved, HttpStatus.CREATED);

        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

}

/*
Links:


https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
https://dzone.com/articles/spring-boot-and-swagger-documenting-restful-servic
https://www.springboottutorial.com/spring-boot-swagger-documentation-for-rest-services

http://localhost:8080/h2-console/
http://localhost:8080/swagger-ui/index.html

 */
