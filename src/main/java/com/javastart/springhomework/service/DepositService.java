package com.javastart.springhomework.service;

import com.javastart.springhomework.entity.Account;
import com.javastart.springhomework.entity.Bill;
import com.javastart.springhomework.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service

public class DepositService {

    private final AccountService accountService;

    @Autowired
    public DepositService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Object deposit(Long accountId, BigDecimal paymentAmount){
        Account account = accountService.getAccountById(accountId);
        Bill defaultBill = AccountUtils.findDefaultBill(account);
        defaultBill.setAmount(defaultBill.getAmount().add(paymentAmount));
        accountService.updateAccount(account);
        return "Success";
    }
}
