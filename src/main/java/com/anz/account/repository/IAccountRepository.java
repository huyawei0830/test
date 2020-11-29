package com.anz.account.repository;

import com.anz.account.bo.Account;

import java.util.List;

public interface IAccountRepository {

    List<Account> getAccountsForUser(String userId);

}
