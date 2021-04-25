package lsg.accounting.service;

import lsg.accounting.domain.Account;
import lsg.accounting.domain.User;
import lsg.accounting.exception.UserNotFoundException;
import lsg.accounting.repository.AccountRepository;
import lsg.accounting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public UserService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public List<User> getUsers() {
        List<User> users = new LinkedList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(long userId) throws UserNotFoundException {
        return this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public Account addAccount(long userId, Account account) throws UserNotFoundException {
        User userToAddAccount = this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        account.setUser(userToAddAccount);
        return this.accountRepository.save(account);
    }

}
