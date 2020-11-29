package com.anz.account.bo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

@Data
@Builder
public class Account {

    private String userId;
    private String accountNumber;
    private String accountName;
    private AccountType accountType;
    private Date balanceDate;
    private Currency currency;
    private BigDecimal openingAvailableBalance;

}
