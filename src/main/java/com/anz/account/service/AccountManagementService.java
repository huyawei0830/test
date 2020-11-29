package com.anz.account.service;

import com.anz.account.bo.Account;
import com.anz.account.bo.Transaction;
import com.anz.account.repository.IAccountRepository;
import com.anz.account.repository.ITransactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountManagementService {

    private IAccountRepository accountRepository;
    private ITransactionRepository transactionRepository;

    public AccountManagementService(IAccountRepository accountRepository,
                                    ITransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Account> getAccountsForUser(String userId) {
        return accountRepository.getAccountsForUser(userId);
    }

    public List<Transaction> getTransactionsForAccount(String accountNumber) {
        return transactionRepository.getTransactionsForAccount(accountNumber);
    }
}
