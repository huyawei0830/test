package com.anz.account.bo;

public enum AccountType {
    SAVINGS("Savings"), CURRENT("Current");

    AccountType(String typeName) {
        this.typeName = typeName;
    }

    private String typeName;

    private String getTypeName() {
        return typeName;
    }
}
