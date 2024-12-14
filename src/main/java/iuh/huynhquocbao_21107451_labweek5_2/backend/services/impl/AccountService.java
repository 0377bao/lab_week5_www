package iuh.huynhquocbao_21107451_labweek5_2.backend.services.impl;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Account;
import iuh.huynhquocbao_21107451_labweek5_2.backend.repositories.AccountRepository;
import iuh.huynhquocbao_21107451_labweek5_2.backend.services.IAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccount {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findAccountByUserName(String username) {
        return accountRepository.findAccountByUserName(username);
    }

}
