package com.anz.account.repository.cache;

import com.anz.account.bo.Account;
import com.anz.account.bo.AccountType;
import com.anz.account.repository.IAccountRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class AccountRepositoryCacheImpl implements IAccountRepository {

    private Map<String, List<Account>> userAccountsMap;

    public AccountRepositoryCacheImpl() {
        userAccountsMap = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            userAccountsMap.put("user-id-" + i, Arrays.asList(
                    Account.builder().userId("user-id-" + i).accountName("SGSavings" + getRandom(4)).accountNumber(getRandom(10)).accountType(AccountType.SAVINGS).currency(Currency.getInstance("SGD")).balanceDate(new GregorianCalendar(2018, 10, 15).getTime()).openingAvailableBalance(getRandomBigDecimal()).build(),
                    Account.builder().userId("user-id-" + i).accountName("AUSavings" + getRandom(4)).accountNumber(getRandom(10)).accountType(AccountType.SAVINGS).currency(Currency.getInstance("AUD")).balanceDate(new GregorianCalendar(2018, 9, 10).getTime()).openingAvailableBalance(getRandomBigDecimal()).build(),
                    Account.builder().userId("user-id-" + i).accountName("SGCurrent" + getRandom(4)).accountNumber(getRandom(10)).accountType(AccountType.CURRENT).currency(Currency.getInstance("SGD")).balanceDate(new GregorianCalendar(2018, 7, 1).getTime()).openingAvailableBalance(getRandomBigDecimal()).build()
            ));
        }
    }

    private String getRandom(int digit) {
        return String.valueOf(Math.abs(new Random().nextLong())).substring(0, digit);
    }

    private BigDecimal getRandomBigDecimal() {
        return BigDecimal.valueOf(Math.abs(new Random().nextFloat()*1000000));
    }

    public List<Account> getAccountsForUser(String userId) {
        if (userAccountsMap.containsKey(userId)) {
            return userAccountsMap.get(userId);
        }
        return new ArrayList<>();
    }

}
