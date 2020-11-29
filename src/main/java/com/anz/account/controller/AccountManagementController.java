package com.anz.account.controller;

import com.anz.account.bo.Account;
import com.anz.account.bo.Transaction;
import com.anz.account.service.AccountManagementService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AccountManagementController {

    private AccountManagementService accountManagementService;

    public AccountManagementController(AccountManagementService accountManagementService) {
        this.accountManagementService = accountManagementService;
    }

    @RequestMapping("/")
    public List<String> index() {
        return Arrays.asList(
                "Get account information: /account/{userId} ({userId} can be from user-id-1 to user-id-100)",
                "Get transaction information: /transaction/{accountNumber} ({accountNumber} can be from account-number-1 to account-number-100)"
        );
    }

    @RequestMapping("/account/{userId}")
    public List<Account> getAccounts(@PathVariable("userId") String userId) {
        return accountManagementService.getAccountsForUser(userId);
    }

    @RequestMapping("/transaction/{accountNumber}")
    public List<Transaction> getTranctions(@PathVariable("accountNumber") String accountNumber) {
        return accountManagementService.getTransactionsForAccount(accountNumber);
    }

}
