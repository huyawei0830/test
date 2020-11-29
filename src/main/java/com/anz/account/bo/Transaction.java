package com.anz.account.bo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

@Data
@Builder
public class Transaction {

    private String accountNumber;
    private Date valueDate;
    private Currency currency;
    private boolean isCredit;
    private BigDecimal amount;
    private String transactionNarrative;

}
