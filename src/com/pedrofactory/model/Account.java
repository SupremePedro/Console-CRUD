package com.pedrofactory.model;

import com.pedrofactory.enums.AccountStatus;

import java.io.Serializable;

public class Account implements Serializable {
    static final long serialVersionUID = 2441964406473552452L;
    Long id;
    AccountStatus accountStatus;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountStatus=" + accountStatus +
                '}';
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Long getId() {
        return id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
