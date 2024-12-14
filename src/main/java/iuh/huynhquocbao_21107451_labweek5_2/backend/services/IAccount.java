package iuh.huynhquocbao_21107451_labweek5_2.backend.services;

import iuh.huynhquocbao_21107451_labweek5_2.backend.models.Account;

public interface IAccount {
    public void save(Account account);
    public Account findAccountByUserName(String username);
}
