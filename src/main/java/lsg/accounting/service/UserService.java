package lsg.accounting.service;

import lsg.accounting.domain.Account;
import lsg.accounting.domain.User;
import lsg.accounting.repository.AccountRepository;
import lsg.accounting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public UserService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public User getUser(long userId) {
        return this.userRepository.findById(userId).orElse(null);
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public Account addAccount(long userId, Account account) {
        Optional<User> userToAddAccount = this.userRepository.findById(userId);
        if (userToAddAccount.isEmpty())
            return null;

        account.setUser(userToAddAccount.get());
        return this.accountRepository.save(account);
    }

}
