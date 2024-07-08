package ru.vchavkin.javams.account_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vchavkin.javams.account_service.entity.Account;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
