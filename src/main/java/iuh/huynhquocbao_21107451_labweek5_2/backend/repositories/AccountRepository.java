package iuh.huynhquocbao_21107451_labweek5_2.backend.repositories;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByUserName(String username);
}