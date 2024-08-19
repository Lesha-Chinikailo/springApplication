package com.javastart.springhomework.service;

import com.javastart.springhomework.entity.Account;
import com.javastart.springhomework.entity.Bill;
import com.javastart.springhomework.exceptions.NotDefaultBillException;
import com.javastart.springhomework.repository.AccountRepository;
import com.javastart.springhomework.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {

    private final AccountService accountService;

    private final AccountRepository accountRepository;

    @Autowired
    public TransferService(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    public Object transfer(Long accountIdFrom, Long accountIdTo, BigDecimal amount) {
        Account accountFrom = accountService.getAccountById(accountIdFrom);
        Account accountTo = accountService.getAccountById(accountIdTo);
        Bill billFrom = AccountUtils.findDefaultBill(accountFrom);
        Bill billTo = AccountUtils.findDefaultBill(accountTo);
        if (billFrom != null) {
            billFrom.setAmount(billFrom.getAmount().subtract(amount));
        }
        if (billTo != null) {
            billTo.setAmount(billTo.getAmount().add(amount));
        }
        accountService.updateAccount(accountFrom);
        accountService.updateAccount(accountTo);
        return "Success";
    }


}
