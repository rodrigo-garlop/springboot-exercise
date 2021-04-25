package lseg.accounting.repository;

import lseg.accounting.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository  extends CrudRepository<Account, Long> {
}
