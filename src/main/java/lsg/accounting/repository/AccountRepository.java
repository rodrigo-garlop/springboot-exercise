package lsg.accounting.repository;

import lsg.accounting.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository  extends CrudRepository<Account, Long> {
}
