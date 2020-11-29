package com.anz.account.repository.db;

import com.anz.account.bo.Account;
import com.anz.account.repository.IAccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryDbImpl implements IAccountRepository {

    public List<Account> getAccountsForUser(String userId) {
        //TODO: to implement with the corresponding db
        return new ArrayList<>();
    }
}
