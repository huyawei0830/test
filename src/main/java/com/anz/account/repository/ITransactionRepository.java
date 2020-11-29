package com.anz.account.repository;

import com.anz.account.bo.Transaction;

import java.util.List;

public interface ITransactionRepository {

    List<Transaction> getTransactionsForAccount(String accountNumber);

}
