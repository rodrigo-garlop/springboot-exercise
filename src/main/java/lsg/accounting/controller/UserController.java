package lsg.accounting.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lsg.accounting.domain.Account;
import lsg.accounting.domain.User;
import lsg.accounting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    @ApiOperation("Get user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User found"),
            @ApiResponse(code = 404, message = "User not found") }
            )
    public ResponseEntity<User> getUser(@PathVariable long userId) {
        User userSearched = this.userService.getUser(userId);
        if (userSearched == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        return new ResponseEntity<>(userSearched, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation("Create new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User created"),
            @ApiResponse(code = 404, message = "User not found") }
    )
    public ResponseEntity<Long> saveUser(@RequestBody User user) {
        User userSaved = userService.saveUser(user);
        return new ResponseEntity<>(userSaved.getUserId(), HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/account")
    public ResponseEntity<Long> addAccount(@PathVariable long userId, @RequestBody Account account) {
        Account accountSaved = userService.addAccount(userId, account);
        return new ResponseEntity<>(accountSaved.getAccountId(), HttpStatus.CREATED);
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
