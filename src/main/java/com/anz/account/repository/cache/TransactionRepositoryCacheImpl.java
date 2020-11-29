package com.anz.account.repository.cache;

import com.anz.account.bo.Transaction;
import com.anz.account.repository.ITransactionRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class TransactionRepositoryCacheImpl implements ITransactionRepository {

    private Map<String, List<Transaction>> accountTransactionsMap;

    public TransactionRepositoryCacheImpl() {
        accountTransactionsMap = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            accountTransactionsMap.put("account-number-" + i, Arrays.asList(
                    Transaction.builder().accountNumber("account-number-" + i).amount(getRandomBigDecimal()).currency(Currency.getInstance("SGD")).valueDate(new GregorianCalendar(2018, 10, 15).getTime()).isCredit(true).transactionNarrative("").build(),
                    Transaction.builder().accountNumber("account-number-" + i).amount(getRandomBigDecimal()).currency(Currency.getInstance("AUD")).valueDate(new GregorianCalendar(2019, 10, 15).getTime()).isCredit(false).transactionNarrative("").build()
            ));
        }
    }

    private BigDecimal getRandomBigDecimal() {
        return BigDecimal.valueOf(Math.abs(new Random().nextFloat()*1000000));
    }

    public List<Transaction> getTransactionsForAccount(String accountNumber) {
        if (accountTransactionsMap.containsKey(accountNumber)) {
            return accountTransactionsMap.get(accountNumber);
        }
        return new ArrayList<>();
    }

}
